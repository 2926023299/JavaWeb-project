package com.gxl.utils;

public class Constants {    //定义常量类

    /**
     * 定义前端的路径名
     */

    public static final String INDEX_PATH = "/index.jsp";
    public static final String LOGIN_PATH = "/login.jsp";
    public static final String REGISTER_PATH = "/register.jsp";

    /**
     * 定义BaseServlet类的路径常量
     */
    public static final String TAG = "method"; //定义方法标签
    public static final String FORWARD = "forward:"; //定义转发标签
    public static final String REDIRECT = "redirect:"; //定义重定向标签
    public static final String FLAG = ":"; //定义分隔符
    public static final String INDEX = "index"; //定义首页

    /*
      定义用户模块中的常量
     */
    public static final String HAS_USER = "1"; //定义用户存在
    public static final String NOT_HAS_USER = "0"; //定义用户不存在
    public static final String REGISTER_FAIL = "服务器异常,注册失败,请稍后再试！"; //定义注册失败
    public static final int USER_ACTIVE = 1; //定义用户已激活
    public static final int USER_NOT_ACTIVE = 0; //定义用户未激活
    public static final int ROLE_CUSTOMER = 0; //定义用户角色:0表示普通用户
    public static final int ROLE_ADMIN = 1; //定义用户角色:1表示管理员
    public static final int ACTIVE_FAIL = 0; //定义激活失败
    public static final int ACTIVE_SUCCESS = 1; //定义已经激活
    public static final int ALREADY_ACTIVATE = 2; //定义已经激活
    public static final String AUTO_USER = "autoUser"; //定义自动登录用户
    public static final String SESSION_USER = "loginUser"; //定义登录后存入session的用户
}
