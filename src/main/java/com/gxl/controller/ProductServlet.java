package com.gxl.controller;

import com.gxl.controller.base.BaseServlet;
import com.gxl.model.PageBean;
import com.gxl.model.Product;
import com.gxl.service.ProductService;
import com.gxl.service.impl.ProductServiceImpl;
import com.gxl.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/*
 * @author gxl
 * @description
 * @date 2020/03/24
 */
@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends BaseServlet {

    /**
     * 分页查询商品
     * @param request 请求携带{int tid, int currentPage}
     * @param response 响应
     * @return 返回goodsList.jsp展示商品列表
     * @throws IOException 异常
     */
    public String show(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int tid = Integer.parseInt(request.getParameter("tid"));

        //获取当前页数和容量
        int pageSize = 8;

        String currentPage = request.getParameter("currentPage");
        int page = 1;
        if (currentPage != null) {
            page = Integer.parseInt(currentPage);
        }

        //调用业务层方法得到前端需要展示的PageBean
        ProductService productService = new ProductServiceImpl();
        PageBean<Product> pageBean = productService.findByPage(page, pageSize, tid);

        //响应给前端
        request.setAttribute("pageBean", pageBean);

        return Constants.FORWARD + "/goodsList.jsp";
    }

    /**
     * 根据id查询商品详情
     * @param request 请求携带{int pid}
     * @param response 响应
     * @return 返回goodsDetail.jsp展示商品详情
     * @throws IOException 异常
     */
    public String detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取商品id
        int pid = Integer.parseInt(request.getParameter("pid"));

        //调用业务层方法得到商品对象
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findByPid(pid);

        System.out.println(product);

        //响应给前端
        request.setAttribute("product", product);

        return Constants.FORWARD + "/goodsDetail.jsp";
    }
}
