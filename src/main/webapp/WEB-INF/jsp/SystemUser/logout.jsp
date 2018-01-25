<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>您已退出Micro Enterprise OA系统</title>
	<link href="${pageContext.request.contextPath}/style/blue/logout.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
    function closewin(){
        var browserName=navigator.appName;
        if (browserName=="Netscape") {
            var opened=window.open('about:blank','_self');
            opened.opener=null;
            opened.close();
        } else if(browserName=="Microsoft Internet Explorer") {
            window.opener=null;
            window.open('','_self');
            window.close();
        }
    }
</script>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg><img id=LogoutImg src="${pageContext.request.contextPath}/style/blue/images/logout/logout.gif" border=0 /><img id=LogoutTitle src="${pageContext.request.contextPath}/style/blue/images/logout/logout1.gif" border=0 /></div>
					<div id=LogoutOperate>
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout2.gif" border=0 /> <a href="${pageContext.request.contextPath}/">重新进入系统</a>
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout3.gif" border=0 /> <a href="javascript: closewin();">关闭当前窗口</a>
                    </div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
