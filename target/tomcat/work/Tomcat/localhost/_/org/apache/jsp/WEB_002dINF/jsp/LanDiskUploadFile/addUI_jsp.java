/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-31 07:53:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.LanDiskUploadFile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("<TITLE>文件属性</TITLE>\n");
      out.write("    <META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=utf-8\" />\n");
      out.write("\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/script/jquery.js\"></SCRIPT>\n");
      out.write("    <SCRIPT LANGUAGE=\"javascript\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/script/pageCommon.js\" CHARSET=\"utf-8\"></SCRIPT>\n");
      out.write("    <SCRIPT LANGUAGE=\"javascript\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/script/PageUtils.js\" CHARSET=\"utf-8\"></SCRIPT>\n");
      out.write("    <LINK TYPE=\"text/css\" REL=\"stylesheet\" HREF=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/pageCommon.css\" />\n");
      out.write("    <SCRIPT TYPE=\"text/javascript\">\n");
      out.write("    </SCRIPT>\n");
      out.write("</HEAD>\n");
      out.write("<BODY>\n");
      out.write("\n");
      out.write("<!-- 标题显示 -->\n");
      out.write("<DIV ID=\"Title_bar\">\n");
      out.write("    <DIV ID=\"Title_bar_Head\">\n");
      out.write("        <DIV ID=\"Title_Head\"></DIV>\n");
      out.write("        <DIV ID=\"Title\"><!--页面标题-->\n");
      out.write("            <IMG BORDER=\"0\" WIDTH=\"13\" HEIGHT=\"13\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/title_arrow.gif\"/> 文件属性\n");
      out.write("        </DIV>\n");
      out.write("        <DIV ID=\"Title_End\"></DIV>\n");
      out.write("    </DIV>\n");
      out.write("</DIV>\n");
      out.write("\n");
      out.write("<!--显示表单内容-->\n");
      out.write("<DIV ID=MainArea>\n");
      out.write("    <FORM ACTION=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/LanDiskFolder/uploadFile\" enctype=\"multipart/form-data\" onsubmit=\"return submitFile()\" method=\"post\">\n");
      out.write("        <DIV CLASS=\"ItemBlock_Title1\"><!-- 信息说明<DIV CLASS=\"ItemBlock_Title1\">\n");
      out.write("        \t<IMG BORDER=\"0\" WIDTH=\"4\" HEIGHT=\"7\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/images/item_point.gif\" /> 文件属性</DIV>  -->\n");
      out.write("        </DIV>\n");
      out.write("        \n");
      out.write("        <!-- 表单内容显示 -->\n");
      out.write("        <DIV CLASS=\"ItemBlockBorder\">\n");
      out.write("            <DIV CLASS=\"ItemBlock\">\n");
      out.write("                <TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" CLASS=\"mainForm\">\n");
      out.write("                    <TR>\n");
      out.write("                        <TD WIDTH=\"100\">文件信息</TD>\n");
      out.write("                        <TD><INPUT TYPE=\"file\" id=\"file\" NAME=\"resource\" CLASS=\"InputStyle\" STYLE=\"width: 400px;\"/></TD>\n");
      out.write("                    </TR>\n");
      out.write("                    <TR>\n");
      out.write("                        <TD>文件描述</TD>\n");
      out.write("                        <TD><TEXTAREA NAME=\"description\" CLASS=\"TextareaStyle\"></TEXTAREA></TD>\n");
      out.write("                    </TR>\n");
      out.write("\t\t\t\t\t<TR>\n");
      out.write("                        <TD>所属文件夹</TD>\n");
      out.write("                        <TD>\n");
      out.write("                            <input type=\"hidden\" name=\"pid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("                            <INPUT TYPE=\"TEXT\" NAME=\"parentId\" READONLY VALUE=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" CLASS=\"InputStyle\" /></TD>\n");
      out.write("                    </TR>\n");
      out.write("                </TABLE>\n");
      out.write("            </DIV>\n");
      out.write("        </DIV>\n");
      out.write("        \n");
      out.write("        <!-- 表单操作 -->\n");
      out.write("        <DIV ID=\"InputDetailBar\">\n");
      out.write("            <INPUT TYPE=\"image\" SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/save.png\"/>\n");
      out.write("            <A HREF=\"javascript:history.go(-1);\"><IMG SRC=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/goBack.png\"/></A>\n");
      out.write("        </DIV>\n");
      out.write("    </FORM>\n");
      out.write("</DIV>\n");
      out.write("\n");
      out.write("<DIV CLASS=\"Description\">\n");
      out.write("\t说明：<BR />\n");
      out.write("\t1，选择的文件的名称，就是这个文件的显示名称，注意不要与本文件夹中已有的文件重名。<BR />\n");
      out.write("</DIV>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function submitFile() {\n");
      out.write("\n");
      out.write("\n");
      out.write("        var file = $(\"#file\").val();\n");
      out.write("        if (file==null||file == ''){\n");
      out.write("            alert(\"请选择上传文件\");\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</BODY>\n");
      out.write("</HTML>\n");
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
