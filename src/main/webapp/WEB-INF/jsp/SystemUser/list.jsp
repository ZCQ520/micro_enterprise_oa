<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script language="javascript" src="${pageContext.request.contextPath}/style/js/jquery-1.4.2.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/style/js/jquery-ztree-2.5.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/zTreeStyle/zTreeStyle.css" type="text/css">
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js"
            charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/style/js/privilegeData.js"
            charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/style/js/privilegeTree.js"
            charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css"/>
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">

        ${msg}
        <!-- 表头-->
        <thead>
        <tr align=center valign=middle id=TableTitle>
            <td width="100">登录名</td>
            <td width="100">姓名</td>
            <td width="100">所属部门</td>
            <td>备注</td>
            <td>相关操作</td>
        </tr>
        </thead>

        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        <c:forEach items="${users}" var="user">
            <tr class="TableDetail1 template">
                <td>${user.user.username}&nbsp;</td>
                <td>${user.user.name}&nbsp;</td>
                <td>${user.departmentName}&nbsp;</td>
                <td>${user.user.note}&nbsp;</td>
                <td><a onClick="return delConfirm()" href="${pageContext.request.contextPath}/SystemUser/deleteUser?uid=${user.user.id}">删除</a>
                    <a href="saveUI.jsp">修改</a>
                    <a href="javascript:privilegeclick();">设置权限</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="${pageContext.request.contextPath}/SystemUser/saveUI"><img src="${pageContext.request.contextPath}/style/images/createNew.png"/></a>
        </div>
    </div>

    <div class="ItemBlock_Title1" id="userTitle" style="display: none;"><!-- 信息说明 -->
        <div class="ItemBlock_Title1">
            <img border="0" width="4" height="7"
                 src="${pageContext.request.contextPath}/style/blue/images/item_point.gif"/>用户:ww
            <div id="userImage"></div>
        </div>
        <div class="ItemBlock_Title1" id="privilegeTitle" style="display: none;">
            <div class="ItemBlock_Title1">
                <img border="0" width="4" height="7"
                     src="${pageContext.request.contextPath}/style/blue/images/item_point.gif"/>选择权限
            </div>
        </div>

        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder" style="display: none;" id="privilegeContent">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <!--表头-->
                    <thead>
                    <tr align="LEFT" valign="MIDDLE" id="TableTitle">
                        <td width="300px" style="padding-left: 7px;">
                            <!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
                            <input type="checkbox" id="allchecked"
                                   onchange="privilegeCheckedAll(this.checked,this.id)"/>
                            <label for="cbSelectAll">全选</label>
                        </td>
                    </tr>
                    </thead>

                    <!--显示数据列表-->
                    <tbody id="TableData">
                    <tr class="TableDetail1">
                        <!-- 显示权限树 -->
                        <td>
                            <ul id='privilegeTree' class="tree">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <image onclick="savePrivilege()" src="${pageContext.request.contextPath}/style/images/save.png"/>
        </div>
    </div>

</body>
</html>
