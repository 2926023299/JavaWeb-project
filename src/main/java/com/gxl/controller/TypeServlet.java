package com.gxl.controller;


import com.google.gson.Gson;
import com.gxl.controller.base.BaseServlet;
import com.gxl.model.Type;
import com.gxl.service.TypeService;
import com.gxl.service.impl.TypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TypeServlet", value = "/TypeServlet")
public class TypeServlet extends BaseServlet {

    /**
     * 查询并展示出所有的商品类型
     * @param request 请求
     * @param response 响应
     * @return 返回类型列表的json字符串
     * @throws ServletException 异常
     * @throws IOException 异常
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TypeService typeService = new TypeServiceImpl();

        List<Type> types = typeService.findAll();

        Gson gson = new Gson();

        return gson.toJson(types);
    }
}
