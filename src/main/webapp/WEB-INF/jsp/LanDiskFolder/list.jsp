<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
	<TITLE>知识管理</TITLE>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/jquery.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/pageCommon.js" CHARSET="utf-8"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
	<LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
	
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></SCRIPT>
	<LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/file.css" />
	<LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />
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
		<DIV CLASS="PathShow">/oa使用说明书/</DIV>
		<DIV CLASS="PathEnd">
			<A HREF="#"><IMG BORDER="0" ALT="返回上级文件夹" SRC="${pageContext.request.contextPath}/style/images/folder_up.gif" /></A>
			<A HREF="#" onClick="">向上</A>
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
		<UL ID="tree">
			<LI><SPAN CLASS="folder"><A HREF="#">根目录</A></SPAN>
				<UL>
					<LI><SPAN CLASS="folder"><A HREF="#">oa常见问题</A></SPAN></LI>
					<LI><SPAN CLASS="folder"><A HREF="#">oa使用说明书</A></SPAN></LI>
					<LI><SPAN CLASS="folder"><A HREF="#">系统维护</A></SPAN>
						<UL>
							<LI><SPAN CLASS="folder"><A HREF="#">oa管理</A></SPAN></LI>
							<LI><SPAN CLASS="folder"><A HREF="#">数据库管理</A></SPAN></LI>
						</UL>
					</LI>
				</UL>
			</LI>
		</UL>
	</DIV>
</DIV>

<!--目录内容列表显示-->
<DIV ID="MainArea" STYLE="margin-left: 3px; width: 700px; float: left;">
	<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle">
		<!-- 表头-->
		<THEAD>
			<TR ALIGN="CENTER" VALIGN="MIDDLE" ID="TableTitle">
				<TD WIDTH="250px">名称</TD>
				<TD WIDTH="100px">大小</TD>
				<TD WIDTH="130px">创建时间</TD>
				<TD>相关操作</TD>
			</TR>
		</THEAD>

		<!--显示文件夹列表-->
		<TBODY ID="TableData" CLASS="dataContainer" dataKey="dirList">
			<!-- 上级 -->
			<TR CLASS="TableDetail1">
				<TD><IMG SRC="${pageContext.request.contextPath}/style/images/FileType/folder.gif"/> 
					<A HREF="#">..</A>
				</TD>
				<TD>&nbsp;</TD>
				<TD>2010-5-24 09:56:33</TD>
				<!--<TD>${file.description}&nbsp;</TD>-->
				<TD><A HREF="saveUI.html">属性</A></TD>
			</TR>
			<TR CLASS="TableDetail1 template">
				<TD><IMG SRC="${pageContext.request.contextPath}/style/images/FileType/folder.gif"/>
					<A HREF="#">${dir.name}</A>&nbsp;
				</TD>
				<TD>&nbsp;</TD>
				<TD>${dir.creationTime}&nbsp;</TD>
				<TD><A HREF="saveUI.html">属性</A>
					<A HREF="renameUI.html">重命名</A>
					<A HREF="moveUI.html">移动</A>
					<A onClick="return delConfirm()" HREF="#">删除</A>
				</TD>
			</TR>
		</TBODY>
		
		<!--显示文件列表-->
		<TBODY ID="TableData" CLASS="dataContainer" dataKey="fileList">
			<TR CLASS="TableDetail1 template">
				<TD><IMG SRC="${pageContext.request.contextPath}/style/images/FileType/${file.fileType.icon}"/>
					<A HREF="#" TITLE="${file.description}">${file.name}</A>&nbsp;
				</TD>
				<TD ALIGN="right" STYLE="padding-right: 15px;">${file.size}&nbsp;</TD>
				<TD>${file.creationTime}&nbsp;</TD>
				<TD><A HREF="${pageContext.request.contextPath}/LanDisk_UploadFile/editUI.html?method=edit">属性</A>
					<A HREF="${pageContext.request.contextPath}/LanDisk_UploadFile/renameUI.html">重命名</A>
					<A HREF="${pageContext.request.contextPath}/LanDisk_UploadFile/moveUI.html">移动</A>
					<A onClick="return delConfirm()" HREF="list.html">删除</A>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	
	<!-- 其他功能超链接 -->
	<DIV ID="TableTail">
		<DIV ID="TableTail_inside">
			<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="10" ALIGN="left">
                <TR>
					<TD><DIV CLASS="FuncBtn">
                            <DIV class=FuncBtnHead></DIV>
                            <DIV class=FuncBtnMemo><A HREF="saveUI.html">新建文件夹</A></DIV>
                            <DIV class=FuncBtnTail></DIV>
                        </DIV></TD>
					<TD><DIV CLASS="FuncBtn">
                            <DIV class=FuncBtnHead></DIV>
                            <DIV class=FuncBtnMemo><A HREF="${pageContext.request.contextPath}/LanDisk_UploadFile/addUI.html?method=add">上传文件</A></DIV>
                            <DIV class=FuncBtnTail></DIV>
                        </DIV></TD>
                </TR>
			</TABLE>
		</DIV>
	</DIV>
	
	<DIV CLASS="Description">
		说明1：左侧的文件夹列表<BR />
		1，显示为树形结构。<!-- 显示根目录 --><BR />
		2，点击某节点时，则显示指定的文件夹。<BR />
		<BR />
		说明2：右侧的文件夹列表<BR />
		1，一次显示一层的文件夹列表，默认显示根目录下的文件夹列表（顶级文件夹列表）。<BR />
		2，在文件夹列表的最上面，显示的".."表示上一级。<BR />
		3，如果当前显示的是最顶级文件夹列表，则不显示上一级文件夹行（".."）。<BR />
		4，点击文件夹的名称，可以打开这个文件夹。<BR />
		5，删除文件夹：只能删除空文件夹。<BR />
		6，文件夹列表默认按创建时间升序排列。<!-- 默认按名称的升序排列 --><BR />
		<BR />
		说明3：文件列表<BR />
		1，文件列表默认按创建时间升序排列。<!-- 默认按名称的升序排列 --><BR />
		2，不同的文件类型，显示不同的图标。<BR />&nbsp;&nbsp;
			图标所在的目录为"style/images/FileType/"，
			名称格式为"${file.extension}.gif"，
			默认是"default.gif"。<BR />
		3，文件大小显示格式（保留小数点后两位数字）：<BR/>&nbsp;&nbsp;
			a，小于1024的是显示单位为B（字节）。<BR />&nbsp;&nbsp;
			b，大于等于1K，且小于1M的，显示单位为KB（千字节）。<BR />&nbsp;&nbsp;
			c，大于等于1M的，显示单位为MB（兆字节）。<BR />
		3，点击文件的名称，可以下载这个文件。下载时指定存储的名称为文件名<BR />
	</DIV>
</DIV>

</BODY>
</HTML>
