<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML>
<HEAD>
	<TITLE>知识管理</TITLE>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/pageCommon.js" CHARSET="utf-8"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
	<LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
	<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/jquery-1.4.2.js"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/jquery-ztree-2.5.js"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/kynamic.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></SCRIPT>
	<LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/file.css" />
	<LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/zTreeStyle/zTreeStyle.css" type="text/css">
	<link href="${pageContext.request.contextPath}/style/style/style.css" rel="stylesheet" type="text/css" />
	<SCRIPT TYPE="text/javascript">
		$(function(){
			$("#tree").treeview();
			$("#tree").find("span.folder").unbind();
		});
    </SCRIPT>
</HEAD>
<BODY STYLE="background-color: #F7FFFF;">	

<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 知识管理
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<!--当前路径-->
<DIV ID="QueryArea">
	<DIV ID="FilePath">
		<DIV CLASS="PathTitle">
			<A HREF="#" onClick="">当前路径：</A>
			<A HREF="#"><IMG BORDER="0" ALT="返回上级文件夹" SRC="${pageContext.request.contextPath}/style/images/folder_up.gif" /></A>
		</DIV>
		<!--当前显示的上级文件夹-->
		<DIV CLASS="PathShow">${currentPath}</DIV>
		<DIV CLASS="PathEnd">
			<A HREF="#"><IMG BORDER="0" ALT="返回上级文件夹" SRC="${pageContext.request.contextPath}/style/images/folder_up.gif" /></A>
			<A HREF="${pageContext.request.contextPath}/LanDiskFolder/showCurrentNodeList?id=${pid}" onClick="">向上</A>
		</DIV>
	</DIV>
</DIV>

<!--目录列表-->
<DIV ID="dirListArea" STYLE="width: 260px; float: left;">
	<DIV CLASS="Menu_head_Table" ID="dirListTitle">
		<IMG src=${pageContext.request.contextPath}/style/images/MenuIcon/FUNC20056.gif /> 知识管理
	</DIV>
	<DIV STYLE="margin-left: 15px;">
		<!--显示文件夹树-->
		<div ID="kynamicTree" class="tree">
		</div>
	</DIV>
</DIV>

<!--目录内容列表显示-->
<DIV ID="MainArea" STYLE="margin-left: 3px; width: 700px; float: left;">
	<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle">
		<!-- 表头-->
		<THEAD>
			<TR ALIGN="CENTER" VALIGN="MIDDLE" ID="TableTitle">
				<TD WIDTH="250px">名称</TD>
				<TD WIDTH="130px">创建时间</TD>
				<TD>相关操作</TD>
			</TR>
		</THEAD>
		
		<!--显示文件列表-->
		<TBODY ID="TableData" CLASS="dataContainer" dataKey="fileList">
		<!-- 上级 -->
		<TR CLASS="TableDetail1">
			<TD><IMG SRC="${pageContext.request.contextPath}/style/images/FileType/folder.gif"/>
				<A HREF="${pageContext.request.contextPath}/LanDiskFolder/showCurrentNodeList?id=${pid}">..</A>
			</TD>
			<TD><font size="5">${msg}</font></TD>
			<TD></TD>
		</TR>
		<c:forEach items="${kynamicDTOList}" var="kynamicDTO">
			<TR CLASS="TableDetail1 template">

				<c:if test="${kynamicDTO.kynamic.isParent == false}">
					<TD>
						<IMG SRC="${pageContext.request.contextPath}/style/images/FileType/${kynamicDTO.icon}"/>
						<A HREF="${pageContext.request.contextPath}/LanDiskUploadFile/downloadFile?id=${kynamicDTO.kynamic.id}" >${kynamicDTO.kynamic.name}</A>&nbsp;
					</TD>
				</c:if>

				<c:if test="${kynamicDTO.kynamic.isParent == true}">
					<TD>
						<IMG SRC="${pageContext.request.contextPath}/style/images/FileType/${kynamicDTO.icon}"/>
						<A HREF="${pageContext.request.contextPath}/LanDiskFolder/showCurrentNodeList?id=${kynamicDTO.kynamic.id}" TITLE="${kynamicDTO.kynamic.name}">${kynamicDTO.kynamic.name}</A>&nbsp;
					</TD>
				</c:if>



				<TD><fmt:formatDate value="${kynamicDTO.kynamic.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp;</TD>
				<TD>
					<c:if test="${kynamicDTO.kynamic.isParent == false}">
					<A HREF="${pageContext.request.contextPath}/LanDiskUploadFile/fileAttribution?name=${kynamicDTO.kynamic.name}&description=${kynamicDTO.kynamic.description}&currentPath=${currentPath}&id=${kynamicDTO.kynamic.id}&pid=${currentId}">属性</A>
					</c:if>
					<c:if test="${kynamicDTO.kynamic.isParent == true}">
						<A HREF="${pageContext.request.contextPath}/LanDiskFolder/folderAttribution?name=${kynamicDTO.kynamic.name}&description=${kynamicDTO.kynamic.description}&currentPath=${currentPath}&id=${kynamicDTO.kynamic.id}&pid=${currentId}">属性</A>
					</c:if>


					<c:if test="${kynamicDTO.kynamic.isParent == false}">
						<A HREF="${pageContext.request.contextPath}/LanDiskUploadFile/renameFileUI?name=${kynamicDTO.kynamic.name}&id=${kynamicDTO.kynamic.id}&pid=${currentId}">重命名</A>
					</c:if>
					<c:if test="${kynamicDTO.kynamic.isParent == true}">
						<A HREF="${pageContext.request.contextPath}/LanDiskFolder/renameFolderUI?name=${kynamicDTO.kynamic.name}&id=${kynamicDTO.kynamic.id}&pid=${currentId}">重命名</A>
					</c:if>


					<A onClick="return delConfirm()" HREF="${pageContext.request.contextPath}/LanDiskFolder/deleteNode?id=${kynamicDTO.kynamic.id}&pid=${currentId}">删除</A>
				</TD>
			</TR>
		</c:forEach>
		</TBODY>
	</TABLE>
	
	<!-- 其他功能超链接 -->
	<DIV ID="TableTail">
		<DIV ID="TableTail_inside">
			<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="10" ALIGN="left">
                <TR>
					<TD><DIV CLASS="FuncBtn">
                            <DIV class=FuncBtnHead></DIV>
                            <DIV class=FuncBtnMemo><A HREF="${pageContext.request.contextPath}/LanDiskFolder/saveUI?currentPath=${currentPath}&pid=${currentId}">新建文件夹</A></DIV>
                            <DIV class=FuncBtnTail></DIV>
                        </DIV></TD>
					<TD><DIV CLASS="FuncBtn">
                            <DIV class=FuncBtnHead></DIV>
                            <DIV class=FuncBtnMemo><A HREF="${pageContext.request.contextPath}/LanDiskUploadFile/addUI?currentPath=${currentPath}&pid=${currentId}">上传文件</A></DIV>
                            <DIV class=FuncBtnTail></DIV>
                        </DIV></TD>
                </TR>
			</TABLE>
		</DIV>
	</DIV>
	

</DIV>

</BODY>
</HTML>
