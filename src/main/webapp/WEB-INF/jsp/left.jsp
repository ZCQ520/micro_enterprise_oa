<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/jquery-1.4.2.js"></script>
<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/jquery-ztree-2.5.js"></script>
<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/menuData.js"></script>
<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/tree.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/menu.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body style="margin: 0">
<TABLE border=0 width="700">
	<TR>
		<TD width=340px align=center valign=top>
		<div class="zTreeDemoBackground">
			<ul id="menuTree" class="tree"></ul>
		</div>		
		</TD>
	</TR>
</TABLE>
</body>
</html>
