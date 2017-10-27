<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Micro Enterprise OA</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame src="${pageContext.request.contextPath}/page/top" name="TopMenu" scrolling="no" noresize />
    <frameset cols="180,*" id="resize">
        <frame noresize name="menu" src="${pageContext.request.contextPath}/page/left" scrolling="yes" />
        <frame noresize name="right" src="${pageContext.request.contextPath}/page/right" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/page/bottom" />
</frameset>
<noframes>
    <body>
    </body>
</noframes>
</html>
