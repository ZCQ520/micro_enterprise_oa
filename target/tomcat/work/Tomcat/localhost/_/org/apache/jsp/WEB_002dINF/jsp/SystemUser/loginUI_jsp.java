/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-24 12:18:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.SystemUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("    <META http-equiv=Content-Type CONTENT=\"text/html; charset=gbk\" />\n");
      out.write("\t<TITLE>Micro Enterprise OA</TITLE>\n");
      out.write("\t<LINK HREF=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/login.css\" type=text/css rel=stylesheet />\n");
      out.write("</HEAD>\n");
      out.write("\n");
      out.write("<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >\n");
      out.write("<FORM METHOD=\"post\" NAME=\"actForm\" ACTION=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/login\">\n");
      out.write("    <DIV ID=\"CenterAreaBg\">\n");
      out.write("        <DIV ID=\"CenterArea\">\n");
      out.write("            <DIV ID=\"LogoImg\"><IMG BORDER=\"0\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/images/logo.png\" /></DIV>\n");
      out.write("            <DIV ID=\"LoginInfo\">\n");
      out.write("                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>\n");
      out.write("                    <TR>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</TR>\n");
      out.write("                    <TR>\n");
      out.write("                        <TD width=45 CLASS=\"Subject\"><IMG BORDER=\"0\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/images/login/userId.gif\" /></TD>\n");
      out.write("                        <TD><INPUT SIZE=\"20\" CLASS=\"TextField\" TYPE=\"text\" NAME=\"account\" /></TD>\n");
      out.write("                        <TD ROWSPAN=\"2\" STYLE=\"padding-left:10px;\"><INPUT TYPE=\"image\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/images/login/userLogin_button.gif\"/></TD>\n");
      out.write("                    </TR>\n");
      out.write("                    <TR>\n");
      out.write("                        <TD CLASS=\"Subject\"><IMG BORDER=\"0\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/images/login/password.gif\" /></TD>\n");
      out.write("                        <TD><INPUT SIZE=\"20\" CLASS=\"TextField\" TYPE=\"password\" NAME=\"password\" /></TD>\n");
      out.write("                    </TR>\n");
      out.write("                </TABLE>\n");
      out.write("            </DIV>\n");
      out.write("            <DIV ID=\"CopyRight\"><A HREF=\"javascript:void(0)\">&copy; 2017 版权所有 王国建</A></DIV>\n");
      out.write("        </DIV>\n");
      out.write("    </DIV>\n");
      out.write("</FORM>\n");
      out.write("</BODY>\n");
      out.write("\n");
      out.write("</HTML>\n");
      out.write("\n");
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
