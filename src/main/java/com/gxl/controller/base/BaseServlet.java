package com.gxl.controller.base;

import com.gxl.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.获取请求标记(要执行的方法的名称)
            String methodName = request.getParameter(Constants.TAG);

            if (methodName == null || methodName.trim().isEmpty()) {
                methodName = Constants.INDEX;
            }
            System.out.println("请求标记名称: " + methodName);
            System.out.println(this);
            //2.获取调用者类的字节码对象
            Class clazz = this.getClass();
            //3.获取方法的字节码对象
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //4.反射调方法执行
            Object obj = method.invoke(this, request, response);

            if (obj != null) {
                String str = (String) obj;

                if (str.startsWith(Constants.FORWARD)) {
                    //转发
                    String realPath = str.substring(str.indexOf(Constants.FLAG) + 1);
                    request.getRequestDispatcher(realPath).forward(request, response);
                } else if (str.startsWith(Constants.REDIRECT)) {
                    //重定向
                    String realPath = str.substring(str.indexOf(Constants.FLAG) + 1);
                    response.sendRedirect(realPath);
                } else {
                    //直接输出
                    response.getWriter().println(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "forward:/index.jsp";
    }
}
