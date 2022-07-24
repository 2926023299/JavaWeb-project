package com.gxl.controller;

import com.gxl.controller.base.BaseServlet;
import com.gxl.model.Address;
import com.gxl.model.User;
import com.gxl.service.AddressService;
import com.gxl.service.impl.AddressServiceImpl;
import com.gxl.utils.Constants;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(name = "AddressServlet", value = "/AddressServlet")
public class AddressServlet extends BaseServlet {
    /**
     *  展示地址列表
     * @param request 请求
     * @param response 响应
     * @return 转发到self_info.jsp
     * @throws ServletException ServletException
     * @throws IOException 异常
     */
    public String show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);

        if (user == null) {
            request.getSession().setAttribute("msg", "请先登录");
            return Constants.REDIRECT + "login.jsp";
        }

        int uid = user.getId();

        AddressService addressService = new AddressServiceImpl();
        List<Address> list = addressService.findByUid(uid);

        request.setAttribute("list", list);

        return Constants.FORWARD + "self_info.jsp";
    }

    /**
     *  添加地址
     * @param request 携带了新地址的请求
     * @param response 响应
     * @return 回调show方法
     * @throws InvocationTargetException 由调用的方法或构造函数抛出的异常
     * @throws IllegalAccessException 反射异常
     */
    public String addAddress(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        //获取参数
        Address address = new Address();
        BeanUtils.populate(address, request.getParameterMap());

        //设置状态为非默认地址
        address.setaState(0);

        AddressService addressService = new AddressServiceImpl();
        addressService.addAddress(address);

        return Constants.REDIRECT + "/AddressServlet?method=show";
    }

    /**
     * 删除地址
     * @param request 携带了要删除的地址的aid(地址id)
     * @param response
     * @return 回调show方法
     */
    public String delete(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        int aid = Integer.parseInt(request.getParameter("aid"));

        AddressService addressService = new AddressServiceImpl();
        addressService.delete(aid);

        return Constants.REDIRECT + "/AddressServlet?method=show";
    }

    /**
     * 设置默认地址
     * @param request 携带了{aid(地址id)}
     * @param response 响应
     * @return 回调show方法
     */
    public String setDefault(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        int aid = Integer.parseInt(request.getParameter("aid"));

        //将默认地址设置为非默认地址
        //获取uid
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        int uid = user.getId();

        AddressService addressService = new AddressServiceImpl();
        addressService.setNoDefault(uid);

        //设置默认地址
        addressService.setDefault(aid);

        return Constants.REDIRECT + "/AddressServlet?method=show";
    }

    /**
     * 修改地址
     * @param request 请求携带{address(地址)}
     * @param response 响应
     * @return 回调show方法
     * @throws InvocationTargetException 由调用的方法或构造函数抛出的异常
     * @throws IllegalAccessException 反射异常
     */
    public String update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        //获取参数
        Address address = new Address();
        BeanUtils.populate(address, request.getParameterMap());

        AddressService addressService = new AddressServiceImpl();
        addressService.update(address);

        return Constants.REDIRECT + "/AddressServlet?method=show";
    }
}
