/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-12-17 07:04:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("    <title>Top</title>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/top.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"PageBody\" style=\"margin: 0\">\r\n");
      out.write(" \r\n");
      out.write("\t<div id=\"Head1\">\r\n");
      out.write("\t\t<div id=\"Logo\">\r\n");
      out.write("\t\t\t<a id=\"msgLink\" href=\"javascript:void(0)\"></a>\r\n");
      out.write("            <font color=\"#0000CC\" style=\"color:#F1F9FE; font-size:28px; font-family:Arial Black, Arial\">Micro Enterprise OA</font>\r\n");
      out.write("\t\t\t<!--<img border=\"0\" src=\"style/blue/images/logo.png\" />-->\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"Head1Right\">\r\n");
      out.write("\t\t\t<div id=\"Head1Right_UserName\">\r\n");
      out.write("                <img border=\"0\" width=\"13\" height=\"14\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/user.gif\" /> 您好，<b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</b>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"Head1Right_UserDept\"></div>\r\n");
      out.write("\t\t\t<div id=\"Head1Right_UserSetup\">\r\n");
      out.write("            \t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/page/PersonConfig/editUserInfoUI\" target=\"right\" >\r\n");
      out.write("\t\t\t\t\t<img border=\"0\" width=\"13\" height=\"14\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/user_setup.gif\" /> 个人设置\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"Head1Right_Time\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("        <div id=\"Head1Right_SystemButton\">\r\n");
      out.write("            <a target=\"_parent\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/logout\">\r\n");
      out.write("\t\t\t\t<img width=\"78\" height=\"20\" alt=\"退出系统\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/images/top/logout.gif\" />\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t\r\n");
      out.write("        <div id=\"Head1Right_Button\">\r\n");
      out.write("            <a target=\"desktop\" href=\"/desktop?method=show\">\r\n");
      out.write("\t\t\t\t<img width=\"65\" height=\"20\" alt=\"显示桌面\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/images/top/desktop.gif\" />\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"Head2\">\r\n");
      out.write("        <div id=\"Head2_Awoke\">\r\n");
      out.write("            <ul id=\"AwokeNum\">\r\n");
      out.write("                <li><a target=\"desktop\" href=\"javascript:void(0)\">\r\n");
      out.write("\t\t\t\t\t\t<img border=\"0\" width=\"11\" height=\"13\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/msg.gif\" /> 消息\r\n");
      out.write("\t\t\t\t\t\t<span id=\"msg\"></span>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("                <li class=\"Line\"></li>\r\n");
      out.write("                <li><a target=\"desktop\" href=\"javascript:void(0)\">\r\n");
      out.write("\t\t\t\t\t\t<img border=\"0\" width=\"16\" height=\"11\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/mail.gif\" /> 邮件\r\n");
      out.write("\t\t\t\t\t\t<span id=\"mail\"></span>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("                <li class=\"Line\"></li>\r\n");
      out.write("\t\t\t\t  <!-- 是否有待审批文档的提示1，数量 -->\r\n");
      out.write("                <li><a href=\"Flow_Formflow/myTaskList.html\" target=\"desktop\">\r\n");
      out.write("                \t\t<img border=\"0\" width=\"12\" height=\"14\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/wait.gif\" />\r\n");
      out.write("                \t\t待办事项（<span id=\"wait\" class=\"taskListSize\">1</span>）\r\n");
      out.write("                \t</a>\r\n");
      out.write("                </li>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("                <!-- 是否有待审批文档的提示2，提示审批 -->\r\n");
      out.write("                <li id=\"messageArea\">您有 1 个待审批文档，请及时审批！★★★★★</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("\t\t<div id=\"Head2_FunctionList\">\r\n");
      out.write("\t\t\t<marquee style=\"WIDTH: 100%;\" onMouseOver=\"this.stop()\" onMouseOut=\"this.start()\" \r\n");
      out.write("\t\t\t\tscrollamount=1 scrolldelay=30 direction=left>\r\n");
      out.write("\t\t\t\t<b>这是滚动的消息</b>\r\n");
      out.write("\t\t\t</marquee>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
