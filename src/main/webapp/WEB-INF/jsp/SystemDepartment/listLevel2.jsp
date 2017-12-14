<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <TITLE>部门列表</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8"/>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/jquery.js"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/pageCommon.js"
            CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
    <LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/pageCommon.css"/>
    <SCRIPT TYPE="text/javascript">
    </SCRIPT>
</HEAD>
<BODY>

<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13"
                 SRC="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 部门管理
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<DIV ID="MainArea">
    <TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle">
        ${msg}
        <!-- 表头-->
        <THEAD>
        <TR ALIGN=center VALIGN=middle ID=TableTitle>
            <TD WIDTH="150px">部门名称</TD>
            <TD WIDTH="150px">上级部门名称</TD>
            <TD WIDTH="200px">职能说明</TD>
            <TD>相关操作</TD>
        </TR>
        </THEAD>

        <!--显示数据列表-->
        <TBODY ID="TableData" CLASS="dataContainer" >
        <c:forEach items="${departments}" var="department">
        <TR CLASS="TableDetail1 template">
            <TD>${department.name}&nbsp;</TD>
            <TD>${department.parentName}&nbsp;</TD>
            <TD>${department.description}&nbsp;</TD>
            <TD><A onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" HREF="${pageContext.request.contextPath}/SystemDepartment/deleteDepartment?did=${department.id}">删除</A>
                <A HREF="${pageContext.request.contextPath}/SystemDepartment/toUpdateUI?did=${department.id}">修改</A>
            </TD>
        </TR>
        </c:forEach>
        </TBODY>
    </TABLE>

    <!-- 其他功能超链接 -->
    <DIV ID="TableTail">
        <DIV ID="TableTail_inside">
            <A HREF="${pageContext.request.contextPath}/SystemDepartment/toSecondDepartmentUI?did=${parentId}"><IMG SRC="${pageContext.request.contextPath}/style/images/createNew.png"/></A>
            <A HREF="${pageContext.request.contextPath}/page/SystemDepartment/list"><IMG
                    SRC="${pageContext.request.contextPath}/style/blue/images/button/ReturnToPrevLevel.png"/></A>
        </DIV>
    </DIV>
</DIV>
</BODY>
</HTML>
