<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>修改密码</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 修改密码
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.request.contextPath}/PersonConfig/updatePassword" onsubmit="return submitEditPasswordForm()">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 修改密码 </DIV>  -->
        </div>

       ${msg}

        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">

            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr height="50">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							请输入原密码
						</td>
						<td><input type="password" id="oldPassword" name="oldPassword" class="InputStyle" /> *</td>
					</tr>
					<tr height="25">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							请填写新密码
						</td>
						<td><input type="password" id="password" name="password" class="InputStyle" /> *</td>
						<td></td>
					</tr>
					<tr height="25">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							再次输入新密码
						</td>
						<td><input type="password" id="password2" name="password2" class="InputStyle" /></td>
						<td></td>
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
	验证规则：<br />
	1，旧密码不能为空。<br />
	2，新密码不能为空。<br />
	3，再次输入的密码要和新密码一致。<br />
</div>

</body>
<script type="text/javascript">
    function submitEditPasswordForm() {
        var oldPassword = $("#oldPassword").val();
        if (oldPassword.trim()==null||oldPassword.trim().length==0){
            alert("请输入旧密码");
            return false;
        }
        var password = $("#password").val();
        if (password.trim()==null||password.trim().length==0){
            alert("请输入新密码");
            return false;
        }
        if ( password.length<6 ){
            alert("密码不能小于6位");
            return false;
        }
        var password2 = $("#password2").val();
        if (password2.trim()==null||password2.trim().length==0){
            alert("请再次输入新密码");
            return false;
        }
        if(password!=password2){
            alert("两次密码不一致");
            return false;
        }

    }

</script>

</html>
