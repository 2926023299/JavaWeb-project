/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-05-22 07:08:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1652528015486L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1653203290884L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login2.css\">\r\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<title>华为首页</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color: #F3F3F4FF\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login2.css\">\r\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("\t<title>头部</title>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/TypeServlet?method=findAll\",\r\n");
      out.write("                type: \"GET\",\r\n");
      out.write("                dataType: \"json\",\r\n");
      out.write("                success: function (data) {\r\n");
      out.write("                    for (var i in data) {\r\n");
      out.write("                        var a = $(\"<a id='type' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/ProductServlet?method=show&tid=\" + data[i].tId + \"'>\" + data[i].tName + \"</a>\");\r\n");
      out.write("                        $(\"#goodsType\").append(a);\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                error: function () {\r\n");
      out.write("                    alert(\"失败\");\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color: #FDFDFDFF\">\r\n");
      out.write("<div id=\"top\">\r\n");
      out.write("\t<div id=\"topdiv\">\r\n");
      out.write("            <span>\r\n");
      out.write("                <a href=\"index.jsp\" id=\"a_top\" target=\"_blank\">华为商城</a>\r\n");
      out.write("            </span>\r\n");
      out.write("\r\n");
      out.write("\t\t<span style=\"float:right\">\r\n");
      out.write("           \t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("       \t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"second\" style=\"display: flex; justify-content: space-between; align-self: center; border-radius: 25px\">\r\n");
      out.write("\t\t<div style=\"width: 200px; height:66px;\"><a href=\"index.jsp\" id=\"seimg\" style=\" margin-top:17px;\"><img id=\"gif\" src=\"image/logo.jpg\" width=\"180\" height=\"66\"/></a></div>\r\n");
      out.write("\t\t<div style=\"display: flex; justify-content: center; align-self: center\">\r\n");
      out.write("\t\t\t<p id=\"goodsType\"></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"cart\" style=\"display: flex; justify-content: center; align-self: center\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/CartServlet?method=show&uid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"shorpcar\">购物车</a></div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<!--网站中间内容开始-->\r\n");
      out.write("<div id=\"thred\">\r\n");
      out.write("\t<img src=\"image/banner2.jpg\" width=\"1230\" height=\"460\"/>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"forth\">\r\n");
      out.write("\t<img src=\"image/banner3.jpg\" width=\"1230\" height=\"460\"/>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"fifth\" style=\"margin-top: 300px\">\r\n");
      out.write("\t<span id=\"fif_text\">华为最热单品</span>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"sixth\" style=\"background-color: #ffffff\">\r\n");
      out.write("            <span style=\"margin-left:0px; border-top:#ffa500 1px solid\">\r\n");
      out.write("            \t<a href=\"\" id=\"siximg\"><img src=\"image/index/index_nova9Pro.jpg\" width=\"234\" height=\"234\"/></a>\r\n");
      out.write("            \t<a href=\"\" id=\"na\">华为 nova9Pro</a>\r\n");
      out.write("                <p id=\"pri\">7499元起</p>\r\n");
      out.write("            </span>\r\n");
      out.write("\t<span style=\" border-top:#008000 1px solid\">\r\n");
      out.write("            \t<a href=\"\" id=\"siximg\"><img src=\"image/index/index_nova9SE.jpg\" width=\"234\" height=\"234\"/></a>\r\n");
      out.write("                <a href=\"\" id=\"na\">华为 nova9SE</a>\r\n");
      out.write("                <p id=\"pri\">8499元起</p>\r\n");
      out.write("            </span>\r\n");
      out.write("\t<span style=\"border-top:#0000ff 1px solid\">\r\n");
      out.write("            \t<a href=\"\" id=\"siximg\"><img src=\"image/index/index_P50.jpg\" width=\"234\" height=\"234\"/></a>\r\n");
      out.write("                <a href=\"\" id=\"na\">华为 P50</a>\r\n");
      out.write("                <p id=\"pri\">6299元起</p>\r\n");
      out.write("            </span>\r\n");
      out.write("\t<span style=\"border-top:#ff0000 1px solid\">\r\n");
      out.write("            \t<a href=\"\" id=\"siximg\"><img src=\"image/index/index_P50E.jpg\" width=\"234\" height=\"234\"/></a>\r\n");
      out.write("                <a href=\"\" id=\"na\">华为 P50E</a>\r\n");
      out.write("                <p id=\"pri\">3999元起</p>\r\n");
      out.write("            </span>\r\n");
      out.write("\t<span style=\"border-top:#008080 1px solid\">\r\n");
      out.write("            \t<a href=\"\" id=\"siximg\"><img src=\"image/index/index_P50Pro+.jpg\" width=\"234\" height=\"234\"/></a>\r\n");
      out.write("                <a href=\"\" id=\"na\">华为P50Pro+</a>\r\n");
      out.write("                <p id=\"pri\">8988元起</p>\r\n");
      out.write("            </span>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 底部 -->\r\n");
      out.write("\r\n");
      out.write("<!--网站版权部分开始-->\r\n");
      out.write(" <div id=\"seventh\">\r\n");
      out.write("    \t<p id=\"sevep1\">华为商城|HUAWEI|米聊|多看书城|华为路由器|视频电话|华为天猫店|华为淘宝直营店|华为网盟|华为移动|隐私政策|Select Region</p>\r\n");
      out.write("        <p id=\"sevep2\">©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</p>\r\n");
      out.write("        <p id=\"sevep3\">违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>\r\n");
      out.write(" </div>");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /header.jsp(39,13) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<div>\r\n");
        out.write("\t\t\t\t\t\t<a href=\"login.jsp\" id=\"a_top\">登录</a>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t<div>\r\n");
        out.write("\t\t\t\t\t\t<a href=\"register.jsp\" id=\"a_top\">注册</a>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /header.jsp(47,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<a href=\"AddressServlet?method=show\" id=\"a_top\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</a>\r\n");
        out.write("\t\t\t\t\t<li>|</li>\r\n");
        out.write("\t\t\t\t\t<a href=\"UserServlet?method=logOut\" id=\"a_top\">注销</a>\r\n");
        out.write("\t\t\t\t\t<li>|</li>\r\n");
        out.write("\t\t\t\t\t<a href=\"OrderServlet?method=show\" id=\"a_top\">我的订单</a>\r\n");
        out.write("\t\t\t\t\t<li>|</li>\r\n");
        out.write("\t\t\t\t\t<a href=\"AddressServlet?method=show\" id=\"a_top\">个人中心</a>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}