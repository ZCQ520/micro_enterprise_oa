<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>选择下一步</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript">
		function selectAndClose(){
			var win = window.dialogArguments;
			// win.document.forms[0].transitionName.value = $("");
			// submit与onsubmit的发生顺序:onsubmit -> submit 
			// 直接用脚本form.submit()提交表单是不会触发表单的onsubmit()事件的 
			// 可以自行触发onsubmit事件（onsubmit全是小写的，并且大小写敏感）
			// win.document.forms[0].onsubmit();
			// 如果是自行调用onsubmit()，则使用的jQuery.validate验证会不起作用！为什么？？
			// 如果使用$.submit()就可以让验证有效，但不会执行onsubmit()函数！为什么？？
			$(win.document.forms[0]).submit();
			window.close();
		}
	</script>
	<!--1，在模态窗口中使用<base target="_self">，不然点击超链接会打开一个新的IE
		2，target的值要是小写的，如果是大写，在IE下测试的不起作用-->
	<base target="_self" />
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 选择下一步
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.request.contextPath}/Flow_FormFlow/myTaskList.html">
		<div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 选择下一步 </DIV>  -->
        </div>
		
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
						<td><input type="RADIO" name="transitionName" id="r_1" value="部门经理" checked />
							<label for="r_1">部门经理</label>
						</td>
					</tr>
					<tr>
						<td><input type="RADIO" name="transitionName" id="r_2" value="总经理" />
							<label for="r_2">总经理</label>
						</td>
					</tr>
                </table>
            </div>
        </div>

		<!-- 表单操作 -->
        <div id="InputDetailBar">
			<img src="${pageContext.request.contextPath}/style/blue/images/button/select.PNG" onClick="selectAndClose();"/>
			<a href="javascript:window.close();"><img src="${pageContext.request.contextPath}/style/blue/images/button/close.png"/></a>
        </div>
    </form>
</div> 

<div class="Description">
	说明：<br />
	1，如果点击“选择”，会提交审批表单，并使用选择的Transition离开节点。<br />
	2，如果点击“关闭”，会关闭此窗口，但不提交审批表单。<br />
</div>

</body>
</html>
