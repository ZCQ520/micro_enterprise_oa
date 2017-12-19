<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
<TITLE>设计审批流程</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
	<SCRIPT LANGUAGE="javascript" SRC="../script/jquery.js"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="../script/pageCommon.js" CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="../script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="../script/DemoData.js" CHARSET="utf-8"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../script/DataShowManager.js" CHARSET="utf-8"></SCRIPT>
    <LINK TYPE="text/css" REL="stylesheet" HREF="../style/blue/pageCommon.css" />
    <SCRIPT TYPE="text/javascript">
    </SCRIPT>
</HEAD>
<BODY>

<!-- 标题显示 -->
<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="../style/images/title_arrow.gif"/> 设计审批流程
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<!--显示表单内容-->
<DIV ID=MainArea>
    <FORM ACTION="list.html">
        <DIV CLASS="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 部署流程定义 </DIV>  -->
        </DIV>
        
        <!-- 表单内容显示 -->
        <DIV CLASS="ItemBlockBorder">
            <DIV CLASS="ItemBlock">
                <TABLE CELLPADDING="0" CELLSPACING="0" CLASS="mainForm">
                    <TR>
						<TD><DIV CLASS="FuncBtn">
                            <DIV class=FuncBtnHead></DIV>
                            <DIV class=FuncBtnMemo><A HREF="saveProcessNodeUI.html">添加步骤</A></DIV>
                            <DIV class=FuncBtnTail></DIV>
                        </DIV></TD>
                    </TR>
                </TABLE>
            </DIV>
        </DIV>
		
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD WIDTH="100px">&nbsp;</TD>
					<TD WIDTH="200px">节点名称</TD>
					<TD WIDTH="200px">类型</TD>
					<TD WIDTH="200px">说明</TD>
					<TD>相关操作</TD>
				</TR>
			</THEAD>
			<TBODY ID="TableData" CLASS="dataContainer" dataKey="processNodeList">
				<TR CLASS="TableDetail1" STYLE=""><!--显示数据列表-->
					<TD STYLE="border-bottom: 1px solid #94C6E7;">第1步</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">申请人</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">新建申请</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">申请人新建并提交申请</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">&nbsp;</TD>
				</TR>
				<TR CLASS="TableDetail1 template"><!--显示数据列表-->
						<TD>第${processNode.ordinal}步</TD>
						<TD>${processNode.name}&nbsp;</TD>
						<TD>${processNode.type}&nbsp;</TD>
						<TD>${processNode.description}&nbsp;</TD>
						<TD><A onClick="return delConfirm()" HREF="list.html">删除</A>
							<A HREF="saveProcessNodeUI.html">修改</A>
							<A HREF="javascript:void(0)">上移</A>
							<A HREF="javascript:void(0)">下移</A>
						</TD>
				</TR>
			</TBODY>
		</TABLE>
    
        
        <!-- 表单操作 -->
        <DIV ID="InputDetailBar">
            <INPUT TYPE="image" SRC="../style/images/save.png"/>
            <A HREF="javascript:history.go(-1);"><IMG SRC="../style/images/goBack.png"/></A>
        </DIV>
    </FORM>
</DIV>

<DIV CLASS="Description">
	说明：<BR />
	1，第1步（申请人）是不可以修改与删除的。<BR />
	2，设计的是审批要经过的环节。<BR />
	3，步骤是的顺序的，新添加的步骤在最下面。<BR />
	4，可以使用上移或下移功能调整步骤的先后顺序，但第1步（申请人）不可以改变。<BR />
</DIV>

</BODY>
</HTML>
