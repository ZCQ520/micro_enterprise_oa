<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js"
            charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css"/>
    <script type="text/javascript">
    </script>
</head>

<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.request.contextPath}/SystemUser/saveOrUpdateUser" onsubmit="return submitUserForm()">
        <div class="ItemBlock_Title1"><!-- 信息说明 -->
            <div class="ItemBlock_Title1">
                <img border="0" width="4" height="7"
                     src="${pageContext.request.contextPath}/style/blue/images/item_point.gif"/> 用户信息
            </div>
        </div>

        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">所属部门</td>
                        <td><select name="departmentId" class="SelectStyle">
                            <c:forEach items="${departments}" var="department">
                                <option value="${department.id}">${department.name}</option>
                            </c:forEach>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td>登录名</td>
                        <td><input id="username" type="text" name="username"  value="${user.username}" class="InputStyle"/> *
                            （登录名要唯一）
                        </td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><input id="password" type="password" name="password" class="InputStyle"/> *
                        </td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td><input id= "name" type="text" name="name" value="${user.name}" class="InputStyle"/> *
                        </td>
                    </tr>
                    <tr>
                        <td>性别</td>
                        <td>
                            <c:if test="${user.sex.equals('male')}">
                            <input type="RADIO" name="sex" value="male" id="male" checked /><label for="male">男</label>
                            </c:if>
                            <c:if test="${!user.sex.equals('male')}">
                                <input type="RADIO" name="sex" value="male" id="male" /><label for="male">男</label>
                            </c:if>
                            <c:if test="${user.sex.equals('female')}">
                                <input type="RADIO" name="sex" value="female" id="female" checked/><label for="female">女</label>
                            </c:if>
                            <c:if test="${!user.sex.equals('female')}">
                                <input type="RADIO" name="sex" value="female" id="female" /><label for="female">女</label>
                            </c:if>

                        </td>
                    </tr>
                    <tr>
                        <td>联系电话</td>
                        <td><input type="text" name="phone" class="InputStyle" value="${user.phone}"/></td>
                    </tr>
                    <tr>
                        <td>E-mail</td>
                        <td><input type="text" name="email" class="InputStyle" value="${user.email}"/></td>
                    </tr>
                    <tr>
                        <td>备注</td>
                        <td><input type="text" name="note" class="InputStyle" value="${user.note}"/></td>
                    </tr>
                    <input type="hidden" name="id" value="${user.id}">
                </table>
            </div>
        </div>

        <div class="ItemBlock_Title1"><!-- 信息说明 -->
            <div class="ItemBlock_Title1">
                <img border="0" width="4" height="7"
                     src="${pageContext.request.contextPath}/style/blue/images/item_point.gif"/> 岗位设置
            </div>
        </div>

        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">岗位</td>
                        <td><select name="roleIdList" multiple="true" size="10" class="SelectStyle">
                            <c:forEach items="${posts}" var="post">
                                <option value="${post.id}">${post.name}</option>
                            </c:forEach>
                        </select>
                            按住Ctrl键可以多选或取消选择
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
    说明：<br/>
    1，用户的登录名要唯一，在填写时要同时检测是否可用。<br/>
    2，新建用户后，密码被初始化为"1234"。<br/>
    3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br/>
    4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br/>
    5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br/>
    6，修改用户信息时，登录名不可修改。
</div>


</body>
<script type="text/javascript">
    function submitUserForm() {
        var username = $("#username").val();
        if (username.trim()==null||username.trim().length==0){
            alert("请输入登录名！");
            return false;
        }
        var password = $("#password").val();
        if (password.trim()==null||password.trim().length==0){
            alert("请输入登陆密码！");
            return false;
        }
        if ( password.length<6 ){
            alert("密码不能小于6位");
            return false;
        }
        var name = $("#name").val();
        if (name.trim()==null||name.trim().length==0){
            alert("请输入姓名！");
            return false;
        }
    }

</script>
</html>
