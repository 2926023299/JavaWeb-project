package com.gxl.controller;

import com.gxl.controller.base.BaseServlet;
import com.gxl.dao.UserDao;
import com.gxl.model.User;
import com.gxl.service.UserService;
import com.gxl.service.impl.UserServiceImpl;
import com.gxl.utils.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {
    /**
     * 用户注册检测用户名是否存在
     * @param request  请求携带{String username}
     * @param response 响应对象
     * @return 返回结果:true/false
     * @throws ServletException 异常
     * @throws IOException 异常
     */
    public String checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (username == null || username.trim().isEmpty()) {
            return Constants.HAS_USER;
        }
        // 检查用户名是否存在
        UserService userService = new UserServiceImpl();
        boolean isExist = userService.checkedUser(username);

        return isExist ? Constants.HAS_USER : Constants.NOT_HAS_USER;
    }

    /**
     * 用户注册
     * @param request  请求
     * @param response 响应对象
     * @return 返回registerSuccess.jsp(注册成功页面)
     * @throws IOException 异常
     */
    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();

        // 将参数封装到user对象中
        BeanUtils.populate(user, parameterMap);
        user.setStatus(Constants.USER_NOT_ACTIVE);  // 账号激活状态
        user.setRole(Constants.ROLE_CUSTOMER);    // 账号角色
        user.setCode(RandomUtils.createActive());   // 生成激活码

        //密码md5加密处理
        user.setPassword(MD5Utils.md5(user.getPassword()));

        UserService userService = new UserServiceImpl();
        boolean flag = userService.registerUser(user);
        if (!flag) {
            request.setAttribute("registerMsg", Constants.REGISTER_FAIL);
            return Constants.FORWARD + Constants.REGISTER_PATH;
        }

        // 发送激活邮件
        EmailUtils.sendEmail(user);
        return Constants.FORWARD + "/registerSuccess.jsp";
    }

    /**
     * 用户激活
     * @param request  请求携带{String code(验证码)}
     * @param response 响应对象
     * @return 返回message.jsp页面
     * @throws IOException 异常
     */
    public String activate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取激活码
        String dCode = request.getParameter("code");
        String code = Base64Utils.decode(dCode);

        //2.激活用户
        UserService userService = new UserServiceImpl();
        int flag = userService.activateUser(code);

        if (flag == Constants.ACTIVE_FAIL) {
            request.setAttribute("msg", "Constants.ACTIVATE_FAIL");
        } else if (flag == Constants.ALREADY_ACTIVATE) {
            request.setAttribute("activateMsg", "Constants.ALREADY_ACTIVATE");
        } else if (flag == Constants.ACTIVE_SUCCESS) {
            request.setAttribute("activateMsg", "Constants.ACTIVATE_SUCCESS");
        }
        return Constants.FORWARD + "/message.jsp";
    }

    /**
     * 用户自动登录
     * @param request  请求携带{user对象， auto（自动登录）}
     * @param response 响应对象
     * @return 返回登录成功页面
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        //1.获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        String auto = request.getParameter("auto"); //自动登录

        //2.封装user对象
        User user = new User();
        BeanUtils.populate(user, parameterMap);

        //验证码的判断
        String code = (String) request.getSession().getAttribute("code");
        if (code == null || !code.equalsIgnoreCase(user.getCode())) {
            request.setAttribute("msg", "验证码错误");
            return Constants.FORWARD + Constants.LOGIN_PATH;
        }

        //3.调用service层方法
        /*
         * 因为user调用了service层方法，在service层方法中，密码通过了md5加密，由于user对象传的是引用，
         * 所以user的密码会被md5加密，提前保存一下。
         * String pass = user.getPassword();
         */
        user.setPassword(MD5Utils.md5(user.getPassword()));
        UserService userService = new UserServiceImpl();
        User loginUser = userService.loginUser(user);

        //4.判断登录结果
        if (loginUser == null) {
            request.setAttribute("msg", "用户名或密码错误");
            return Constants.FORWARD + Constants.LOGIN_PATH;
        } else if (loginUser.getStatus() == Constants.USER_NOT_ACTIVE) {
            request.setAttribute("msg", "用户未激活");
            return Constants.FORWARD + Constants.LOGIN_PATH;
        }

        //判断是否自动登录
        if(auto != null){
            //自动登录
            String content = Base64Utils.encode((user.getUsername() + ":" + user.getPassword()));

            Cookie cookie = new Cookie(Constants.AUTO_USER, content);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
        }else{
            //普通登录
            Cookie cookie = new Cookie(Constants.AUTO_USER, "");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        //5.将用户信息存入session
        request.getSession().setAttribute(Constants.SESSION_USER, loginUser);

        return Constants.REDIRECT + Constants.INDEX_PATH;
    }

    /**
     * 用户退出
     * @param request 请求对象
     * @param response 响应对象
     * @return 转发到登录页面
     * @throws IOException 异常
     */
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.清除session
        request.getSession().removeAttribute(Constants.SESSION_USER);

        //2.清除cookie
        Cookie cookie = new Cookie(Constants.AUTO_USER, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        //3.转发到登录页面
        request.setAttribute("msg", "退出成功");
        return Constants.FORWARD + Constants.LOGIN_PATH;
    }
}
