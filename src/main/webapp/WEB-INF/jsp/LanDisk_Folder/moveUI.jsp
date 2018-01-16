<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
	<TITLE>移动文件夹</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
	<SCRIPT LANGUAGE="javascript" SRC=${pageContext.request.contextPath}/script/jquery.js"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC=${pageContext.request.contextPath}/script/pageCommon.js" CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC=${pageContext.request.contextPath}/script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC=${pageContext.request.contextPath}/script/DemoData.js" CHARSET="utf-8"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC=${pageContext.request.contextPath}/script/DataShowManager.js" CHARSET="utf-8"></SCRIPT>
    <LINK TYPE="text/css" REL="stylesheet" HREF=${pageContext.request.contextPath}/style/blue/pageCommon.css" />
	
	<SCRIPT LANGUAGE="javascript" SRC=${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></SCRIPT>
	<LINK TYPE="text/css" REL="stylesheet" HREF=${pageContext.request.contextPath}/style/blue/file.css" />
	<LINK TYPE="text/css" REL="stylesheet" HREF=${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />
	<SCRIPT TYPE="text/javascript">
		$(function(){
			$("#dirTree").treeview();
		});
    </SCRIPT>
</HEAD>
<BODY>

<!-- 标题显示 -->
<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC=${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 移动文件夹
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<!--显示表单内容-->
<DIV ID="MainArea">
    <FORM ACTION="list.html">
        <DIV CLASS="ItemBlock_Title1"><!-- 信息说明 --><DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC=${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 请选择目标文件夹</DIV> 
        </DIV>
        
        <!-- 表单内容显示 -->
        <DIV CLASS="ItemBlockBorder">
            <DIV CLASS="ItemBlock">
			
                <!--目录列表-->
				<DIV ID="dirListArea" STYLE="width: 100%; float: left;">
					<DIV CLASS="Menu_head_Table" ID="dirListTitle"> 
						<IMG src=../style/images/MenuIcon/FUNC20056.gif /> 知识管理
					</DIV>
					
					<DIV STYLE="margin-left: 15px;">
						<UL ID="dirTree">
							<LI><INPUT TYPE="RADIO" NAME="folderId" CHECKED /><SPAN CLASS="folder">根目录</SPAN>
								<UL>
									<LI><INPUT TYPE="RADIO" NAME="folderId" /><SPAN CLASS="folder">oa常见问题</SPAN></LI>
									<LI><INPUT TYPE="RADIO" NAME="folderId" /><SPAN CLASS="folder">oa使用说明书</SPAN></LI>
									<LI><INPUT TYPE="RADIO" NAME="folderId" /><SPAN CLASS="folder">系统维护</SPAN>
										<UL>
											<LI><INPUT TYPE="RADIO" NAME="folderId" /><SPAN CLASS="folder">oa管理</SPAN></LI>
											<LI><INPUT TYPE="RADIO" NAME="folderId" /><SPAN CLASS="folder">数据库管理</SPAN></LI>
										</UL>
									</LI>
								</UL>
							</LI>
						</UL>
					</DIV>
				</DIV>
            </DIV>
        </DIV>
        
        <!-- 表单操作 -->
        <DIV ID="InputDetailBar">
            <INPUT TYPE="image" SRC=${pageContext.request.contextPath}/style/images/save.png"/>
            <A HREF="javascript:history.go(-1);"><IMG SRC=${pageContext.request.contextPath}/style/images/goBack.png"/></A>
        </DIV>
    </FORM>
</DIV>

<DIV CLASS="Description">
	说明：<BR />
	1，移动时，不显示当前文件夹 所在的文件夹 及他所有的子孙文件夹，以防止选择自已 或自已的子文件夹 做为上级。
</DIV>

</BODY>
</HTML>