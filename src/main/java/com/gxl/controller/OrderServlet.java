package com.gxl.controller;

import com.google.gson.Gson;
import com.gxl.controller.base.BaseServlet;
import com.gxl.model.*;
import com.gxl.service.AddressService;
import com.gxl.service.CartService;
import com.gxl.service.OrderService;
import com.gxl.service.impl.AddressServiceImpl;
import com.gxl.service.impl.CartServiceImpl;
import com.gxl.service.impl.OrderServiceImpl;
import com.gxl.utils.Constants;
import org.apache.ibatis.annotations.Delete;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BaseServlet {

    /**
     * 订单预览--在购物车页面点击按钮
     * @param request 请求携带{uid(用户id)}
     * @param response 响应携带{cartList(购物车列表),addressList(收货地址列表)}
     * @return 返回order.jsp（订单预览页面）
     */
    public String preView(HttpServletRequest request, HttpServletResponse response) {
        //获取参数
        String uid = request.getParameter("uid");

        //获取购物车列表
        CartService cartService = new CartServiceImpl();
        List<Cart> cartList = cartService.findAll(Integer.parseInt(uid));
        request.setAttribute("cartList", cartList);

        //获取地址信息
        AddressService addressService = new AddressServiceImpl();
        List<Address> addList = addressService.findByUid(Integer.parseInt(uid));
        request.setAttribute("addList", addList);

        return Constants.FORWARD + "order.jsp";
    }

    /**
     * 提交订单--创建订单项并创建订单
     * @param request 请求携带{uid(用户id),aid(收货地址id),sum(总价)}
     * @param response 响应
     * @return 返回orderSuccess.jsp（订单成功页面）
     */
    public String create(HttpServletRequest request, HttpServletResponse response) {
        //获取参数
        String uid = request.getParameter("uid");
        String aid = request.getParameter("aid");
        String total = request.getParameter("sum");

        //调用service
        OrderService orderService = new OrderServiceImpl();
        Orders orders = orderService.create(Integer.parseInt(uid), Integer.parseInt(aid), Double.parseDouble(total));

        request.setAttribute("msg", "下单成功");
        request.setAttribute("order", orders);

        return Constants.FORWARD + "orderSuccess.jsp";
    }

    /**
     * 查看订单
     * @param request 请求
     * @param response 响应
     * @return 返回orderList.jsp（订单列表页面）
     */
    public String show(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);

        if (user == null) {
            request.getSession().setAttribute("msg", "请先登录！");
            return Constants.REDIRECT + Constants.LOGIN_PATH;
        }

        OrderService orderService = new OrderServiceImpl();
        List<Orders> ordersList = orderService.findByUid(user.getId());

        request.setAttribute("ordersList", ordersList);

        return Constants.FORWARD + "orderList.jsp";
    }

    /**
     * 获取订单详情--订单详情页面
     * @param request 请求携带{oid(订单id)}
     * @param response 响应携带{orders(订单信息)}
     * @return 返回orderDetail.jsp（订单详情页面）
     */
    public String getOrderDetail(HttpServletRequest request, HttpServletResponse response) {
        String oid = request.getParameter("oid");

        OrderService orderService = new OrderServiceImpl();
        Orders orders = orderService.findByOid(oid);

        request.setAttribute("orders", orders);

        return Constants.FORWARD + "orderDetail.jsp";
    }

    /**
     * 支付订单
     * @param request 请求携带{oid(订单id)}
     * @param response 响应
     * @return 返回message.jsp（订单支付成功页面）
     */
    public String success(HttpServletRequest request, HttpServletResponse response) {
        String oid = request.getParameter("oid");

        OrderService orderService = new OrderServiceImpl();
        orderService.updateStatus(oid);

        //支付成功
        HttpSession session = request.getSession();
        session.setAttribute("msg", "支付成功！");

        return Constants.FORWARD + "/message.jsp";
    }

    /**
     * 取消订单
     * @param request 请求携带{oid(订单id)}
     * @param response 响应
     * @return 调用show方法展示订单列表
     */
    public String delOrder(HttpServletRequest request, HttpServletResponse response) {
        String oid = request.getParameter("oid");

        OrderService orderService = new OrderServiceImpl();
        orderService.delete(oid);

        return Constants.REDIRECT + "OrderServlet?method=show";
    }

    /**
     * 修改订单状态
     * @param request 请求携带{oid(订单id), status(订单状态)}
     * @param response 响应
     * @return 调用show方法展示订单列表
     */
    public String changeStatus(HttpServletRequest request, HttpServletResponse response) {
        String oid = request.getParameter("oid");
        String status = request.getParameter("status");

        OrderService orderService = new OrderServiceImpl();
        orderService.changeStatus(oid, status);

        return Constants.REDIRECT + "OrderServlet?method=show";
    }
}
