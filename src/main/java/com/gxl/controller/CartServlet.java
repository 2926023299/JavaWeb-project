package com.gxl.controller;

import com.gxl.controller.base.BaseServlet;
import com.gxl.model.Cart;
import com.gxl.model.User;
import com.gxl.service.CartService;
import com.gxl.service.impl.CartServiceImpl;
import com.gxl.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BaseServlet {
    /**
     * 创建购物车
     * @param request 请求携带了商品的pid
     * @param response 响应
     * @return 转发到cartSuccess.jsp
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    public String create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 判断用户是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        if (user == null) {
            session.setAttribute("msg", "请先登录！");
            response.sendRedirect(request.getContextPath() + Constants.LOGIN_PATH);
        }

        // 获取参数
        String pid = request.getParameter("pid");
        assert user != null;
        int id = user.getId();

        // 创建购物车
        CartService cartService = new CartServiceImpl();
        cartService.create(id, pid);
        return Constants.FORWARD + "cartSuccess.jsp";
    }

    /**
     * 查询购物车
     * @param request  请求
     * @param response 响应
     * @return 转发到cart.jsp
     * @throws IOException 异常
     */
    public String show(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 判断用户是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        if (user == null) {
            session.setAttribute("msg", "请先登录！");
            response.sendRedirect(request.getContextPath() + Constants.LOGIN_PATH);
        }

        // 获取参数
        String uid = request.getParameter("uid");

        // 查询购物车
        CartService cartService = new CartServiceImpl();
        List<Cart> list = cartService.findAll(Integer.parseInt(uid));
        request.setAttribute("list", list);

        return Constants.FORWARD + "cart.jsp";
    }

    /**
     * 删除购物车中的商品
     * @param request 请求携带了购物车的cid(购物车id)
     * @param response 响应
     * @return 回调到show方法
     */
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        // 获取参数
        String cid = request.getParameter("cid");
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);

        // 删除购物车
        CartService cartService = new CartServiceImpl();
        cartService.delete(Integer.parseInt(cid));

        return Constants.FORWARD + "/CartServlet?method=show&uid=" + user.getId();
    }

    /**
     * 更新购物车数量和价格
     * @param request 请求携带{cid(购物车id), cNum(数量), cPrice(价格)}
     * @param response 响应
     * @return 转发到show重新刷新页面
     */
    public String update(HttpServletRequest request, HttpServletResponse response) {
        // 获取参数
        String cid = request.getParameter("cid");
        String cNum = request.getParameter("cNum");
        String pPrice = request.getParameter("cPrice");
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);

        // 更新购物车
        CartService cartService = new CartServiceImpl();
        cartService.updateCartByNum(Integer.parseInt(cid), Integer.parseInt(cNum), Integer.parseInt(pPrice));

        return Constants.FORWARD + "/CartServlet?method=show&uid=" + user.getId();
    }

    /**
     * 清空购物车
     * @param request 请求
     * @param response 响应
     * @return 转发到show重新刷新页面
     */
    public String clearCart(HttpServletRequest request, HttpServletResponse response) {
        User user = (User)request.getSession().getAttribute(Constants.SESSION_USER);

        CartService cartService = new CartServiceImpl();
        cartService.clearCart(user.getId());

        return Constants.FORWARD + "/CartServlet?method=show&uid=" + user.getId();
    }
}
