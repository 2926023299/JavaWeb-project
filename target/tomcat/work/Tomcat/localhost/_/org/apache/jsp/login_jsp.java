/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-05-20 07:23:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <title>登录</title>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function () {\r\n");
      out.write("            //1.验证用户名是否存在\r\n");
      out.write("            $(\"#username\").change(function () {\r\n");
      out.write("                $.get(\"checkUserName\", \"username=\" + this.value, function (data) {\r\n");
      out.write("                    if (data == 0) {\r\n");
      out.write("                        $(\"#nameMsg\").html(\"用户名不存在\").css(\"color\", \"red\");\r\n");
      out.write("                    } else {\r\n");
      out.write("                        $(\"#nameMsg\").html(\"\");\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("            });\r\n");
      out.write("            //2.点击验证码 跟新验证码\r\n");
      out.write("            $(\"#pagecode\").click(function () {\r\n");
      out.write("                $(\"#pagecode\").attr(\"src\", \"code?method=createCode&t=\" + Math.random());\r\n");
      out.write("            });\r\n");
      out.write("            //3.验证输入的验证码 是否正确\r\n");
      out.write("            $(\"#vcode\").change(function () {\r\n");
      out.write("                $.get(\"checkCode\", \"code=\" + this.value, function (data) {\r\n");
      out.write("                    if (data == 0) {\r\n");
      out.write("                        $(\"#checkMsg\").html(\"<font color='green'>OK</font>\");\r\n");
      out.write("                        $(\"#btn\").removeAttr(\"disabled\");\r\n");
      out.write("                    } else {\r\n");
      out.write("                        $(\"#checkMsg\").html(\"<font color='red'>ERROR</font>\");\r\n");
      out.write("                        $(\"#pagecode\").attr(\"src\", \"code?method=createCode&t=\" + Math.random());\r\n");
      out.write("                        $(\"#btn\").Attr(\"disabled\", true);\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("            });\r\n");
      out.write("            //4.两周以内自动登录  友好提示\r\n");
      out.write("            $(\"#autoLogin\").click(function () {\r\n");
      out.write("                if (this.checked) {\r\n");
      out.write("                    $(\"#autoLoginMsg\").html(\"公司电脑请勿勾选此项\").css(\"color\", \"red\");\r\n");
      out.write("                } else {\r\n");
      out.write("                    $(\"#autoLoginMsg\").html(\"\");\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- login -->\r\n");
      out.write("<div class=\"top center\">\r\n");
      out.write("    <div class=\"logo center\">\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index.jsp\" target=\"_blank\"><img src=\"./image/mistore_logo.png\"\r\n");
      out.write("                                                                                     alt=\"\"></a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<form method=\"post\" action=\"UserServlet?method=login\" class=\"form center\" id=\"userLogin\">\r\n");
      out.write("    <div class=\"login\">\r\n");
      out.write("        <div class=\"login_center\">\r\n");
      out.write("            <div class=\"login_top\">\r\n");
      out.write("                <div class=\"left fl\">会员登录</div>\r\n");
      out.write("                <div class=\"right fr\">您还不是我们的会员？<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/register.jsp\"\r\n");
      out.write("                                                   target=\"_self\">立即注册</a></div>\r\n");
      out.write("                <div class=\"clear\"></div>\r\n");
      out.write("                <div class=\"xian center\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"login_main center\">\r\n");
      out.write("                <div class=\"username\">\r\n");
      out.write("                    <div class=\"left fl\">用户名:&nbsp;</div>\r\n");
      out.write("                    <div class=\"right fl\">\r\n");
      out.write("                        <input class=\"shurukuang\" type=\"text\" name=\"username\" id=\"username\" placeholder=\"请输入你的用户名\"/>\r\n");
      out.write("                        <label id=\"nameMsg\"></label>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"username\">\r\n");
      out.write("                    <div class=\"left fl\">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</div>\r\n");
      out.write("                    <div class=\"right fl\">\r\n");
      out.write("                        <input class=\"shurukuang\" type=\"password\" name=\"password\" id=\"pwd\" placeholder=\"请输入你的密码\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"username\">\r\n");
      out.write("                    <div class=\"left fl\">验证码:&nbsp;</div>\r\n");
      out.write("                    <div class=\"right fl\"><input style=\"width: 100px\" class=\"yanzhengma\" name=\"code\" id=\"vcode\" type=\"text\"\r\n");
      out.write("                                                 placeholder=\"验证码\"/>\r\n");
      out.write("                        <img id=\"pagecode\" src=\"code?method=createCode&t=4\"><label id=\"checkMsg\"></label>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"username\">\r\n");
      out.write("                    <div class=\"left fl\">&nbsp;&nbsp;&nbsp;&nbsp;</div>\r\n");
      out.write("                    <div class=\"right fl\"><label id=\"checkMsg\"></label></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"username\">\r\n");
      out.write("                    <input id=\"autoLogin\" name=\"auto\" type=\"checkbox\"/>&nbsp;&nbsp;两周以内自动登录\r\n");
      out.write("                    <span id=\"autoLoginMsg\"></span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"login_submit\">\r\n");
      out.write("                    <input class=\"submit\" type=\"submit\" name=\"submit\" value=\"立即登录\" id=\"btn\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <span style=\"color:red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("<footer>\r\n");
      out.write("    <div class=\"copyright\">简体 | 繁体 | English | 常见问题</div>\r\n");
      out.write("    <div class=\"copyright\">华为公司版权所有-京ICP备10046444-<img src=\"./image/ghs.png\" alt=\"\">京公网安备11010802020134号-京ICP证110507号\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
