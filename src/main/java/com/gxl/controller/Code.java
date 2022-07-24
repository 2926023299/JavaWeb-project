package com.gxl.controller;

import cn.dsna.util.images.ValidateCode;
import com.gxl.controller.base.BaseServlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/code")
public class Code extends BaseServlet {

    /**
     * 创建验证码
     * @param request 请求
     * @param response 响应
     * @throws IOException 异常
     */
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.生成验证码对象
        ValidateCode vc = new ValidateCode(100,35,5,20);
        // 2.获取验证码图片
        String code = vc.getCode();

        request.getSession().setAttribute("code", code);

        //向页面写回验证码
        ServletOutputStream out = response.getOutputStream();
        vc.write(out);
    }
}
