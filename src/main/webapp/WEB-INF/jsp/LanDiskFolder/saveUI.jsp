<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>文件夹属性</title>
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 文件夹属性
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.request.contextPath}/LanDiskFolder/addOrUpdateFolder" onsubmit="return submitFolder()">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 文件夹属性</DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">文件夹名称</td>
                        <td>
                            <input type="text" name="name" id="name" class="InputStyle"  value="${kynamic.name}"/> *
                        </td>
                    </tr>
                    <tr>
                        <td>文件夹描述</td>
                        <td><textarea name="description" class="TextareaStyle">${kynamic.description}</textarea></td>
                    </tr>
					<tr>
                        <td>上级文件夹</td>
                        <td>
                            <input type="hidden" name="id" value="${kynamic.id}">
                            <input type="hidden" name="pid" value="${pid}">
                            <input type="TEXT" name="parentId" readonly value="${currentPath}" class="InputStyle" /></td>
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
	说明：<br />
	1，文件夹的名称，注意不要与本文件夹中已有的文件夹重名。
</div>
<script type="text/javascript">
    function submitFolder() {

        var name = $("#name").val();
        if (name.trim()==null||name.trim().length==0){
            alert("请输入文件夹名称");
            return false;
        }


    }
</script>
</body>
</html>
