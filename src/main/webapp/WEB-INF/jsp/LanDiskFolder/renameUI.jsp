<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
<TITLE>文件夹重命名</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/jquery.js"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/pageCommon.js" CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
    <LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <SCRIPT TYPE="text/javascript">
    </SCRIPT>
</HEAD>
<BODY>

<!-- 标题显示 -->
<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 文件夹重命名
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<!--显示表单内容-->
<DIV ID=MainArea>
    <FORM ACTION="${pageContext.request.contextPath}/LanDiskFolder/renameKynamic">
        <DIV CLASS="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 文件夹重命名</DIV>  -->
        </DIV>
        
        <!-- 表单内容显示 -->
        <DIV CLASS="ItemBlockBorder">
            <DIV CLASS="ItemBlock">
                <TABLE CELLPADDING="0" CELLSPACING="0" CLASS="mainForm">
                    <tr>${msg}</tr>
                    <TR HEIGHT="50">
						<TD WIDTH="150">
							<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							原文件夹名称
						</TD>
						<TD>${kynamic.name}</TD>

					</TR>
					<TR HEIGHT="25">
						<TD WIDTH="150">
							<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							新文件夹名称
						</TD>
						<TD>
                            <input type="hidden" name="oldName" value="${kynamic.name}">
                            <input type="hidden" name="id" value="${kynamic.id}">
                            <input type="hidden" name="pid" value="${kynamic.pid}">
                            <input type="hidden" name="isParent" value="1">
                            <INPUT TYPE="text" NAME="name" CLASS="InputStyle" /> *</TD>
						<TD></TD>
					</TR>
                </TABLE>
            </DIV>
        </DIV>
        
        <!-- 表单操作 -->
        <DIV ID="InputDetailBar">
            <INPUT TYPE="image" SRC="${pageContext.request.contextPath}/style/images/save.png"/>
            <A HREF="javascript:history.go(-1);"><IMG SRC="${pageContext.request.contextPath}/style/images/goBack.png"/></A>
        </DIV>
    </FORM>
</DIV>

<DIV CLASS="Description">
	说明：<BR />
	1，新的文件夹名称，注意不要与本文件夹中已有的文件夹重名。
</DIV>

</BODY>
</HTML>
