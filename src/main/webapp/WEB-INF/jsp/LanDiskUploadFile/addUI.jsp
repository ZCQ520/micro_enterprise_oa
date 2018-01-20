<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
<TITLE>文件属性</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
	<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/jquery.js"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/pageCommon.js" CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
    <LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <SCRIPT TYPE="text/javascript">
    </SCRIPT>
</HEAD>
<BODY>

<!-- 标题显示 -->
<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 文件属性
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<!--显示表单内容-->
<DIV ID=MainArea>
    <FORM ACTION="${pageContext.request.contextPath}/LanDiskFolder/uploadFile" enctype="multipart/form-data" onsubmit="return submitFile()" method="post">
        <DIV CLASS="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 文件属性</DIV>  -->
        </DIV>
        
        <!-- 表单内容显示 -->
        <DIV CLASS="ItemBlockBorder">
            <DIV CLASS="ItemBlock">
                <TABLE CELLPADDING="0" CELLSPACING="0" CLASS="mainForm">
                    <TR>
                        <TD WIDTH="100">文件信息</TD>
                        <TD><INPUT TYPE="file" id="file" NAME="resource" CLASS="InputStyle" STYLE="width: 400px;"/></TD>
                    </TR>
                    <TR>
                        <TD>文件描述</TD>
                        <TD><TEXTAREA NAME="description" CLASS="TextareaStyle"></TEXTAREA></TD>
                    </TR>
					<TR>
                        <TD>所属文件夹</TD>
                        <TD>
                            <input type="hidden" name="pid" value="${pid}">
                            <INPUT TYPE="TEXT" NAME="parentId" READONLY VALUE="${currentPath}" CLASS="InputStyle" /></TD>
                    </TR>
                </TABLE>
            </DIV>
        </DIV>
        
        <!-- 表单操作 -->
        <DIV ID="InputDetailBar">
            <INPUT TYPE="image" SRC="${pageContext.request.contextPath}/style/images/save.png"/>
            <A HREF="javascript:history.go(-1);"><IMG SRC="${pageContext.request.contextPath}/style/images/goBack.png"/></A>
        </DIV>
    </FORM>
</DIV>

<DIV CLASS="Description">
	说明：<BR />
	1，选择的文件的名称，就是这个文件的显示名称，注意不要与本文件夹中已有的文件重名。<BR />
</DIV>

<script type="text/javascript">
    function submitFile() {


        var file = $("#file").val();
        if (file==null||file == ''){
            alert("请选择上传文件");
            return false;
        }

    }
</script>

</BODY>
</HTML>
