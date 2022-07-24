package com.gxl.filter;

import com.gxl.model.User;
import com.gxl.service.UserService;
import com.gxl.service.impl.UserServiceImpl;
import com.gxl.utils.Base64Utils;
import com.gxl.utils.Constants;
import com.gxl.utils.MD5Utils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login.jsp")
public class AutoLoginFilter implements Filter { // 自动登录过滤器，默认情况虾过滤器只会过滤正常请求和重定向请求，如果想要过滤所有请求，可以使用Filter.ALL
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("进入自动登录过滤器");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String content = null;

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constants.AUTO_USER)) {
                    content = Base64Utils.decode(cookie.getValue());
                    System.out.println("自动登录的用户名和密码：" + content);
                }
            }

            if (content != null) {
                String[] split = content.split(":");

                User user = new User();
                user.setUsername(split[0]);
                user.setPassword(split[1]);

                System.out.println("分离出来的自动登录的用户名和密码：" + user.getUsername() + "," + user.getPassword());

                UserService userService = new UserServiceImpl();
                User isUser = userService.loginUser(user);

                System.out.println("查询到的对象：" + isUser);

                if (isUser != null) {
                    request.getSession().setAttribute(Constants.SESSION_USER, isUser);
                    response.sendRedirect(request.getContextPath() + Constants.INDEX_PATH);
                } else {
                    chain.doFilter(req, resp);
                }
            }
        }

        //本地没有cookie，放行即可
        chain.doFilter(req, resp);
    }
}
