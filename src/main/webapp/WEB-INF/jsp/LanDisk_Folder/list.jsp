<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
	<TITLE>知识管理</TITLE>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
	<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/jquery-1.4.2.js"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/jquery-ztree-2.5.js"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/kynamicData.js"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/style/js/kynamicTree.js"></script>
	<LINK TYPE="text/css" REL="stylesheet" HREF="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/zTreeStyle/zTreeStyle.css" type="text/css">
	<link href="${pageContext.request.contextPath}/style/style/style.css" rel="stylesheet" type="text/css" />
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
			当前路径:
		</DIV>
	</DIV>
</DIV>

<!--目录列表-->
<DIV ID="dirListArea" STYLE="width: 260px; float: left;">
	<DIV STYLE="margin-left: 15px;">
		<!--显示文件夹树-->
		<div ID="kynamicTree" class="tree">
		</div>
	</DIV>
</DIV>

<!--目录内容列表显示-->
<DIV ID="MainArea" STYLE="margin-left: 3px; width: 700px; float: left;" border="3">
	<table width="700" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #91C0E3;">
  <tr>
    <td width="94" height="40" align="center" valign="middle" bgcolor="#F0F7FD" style="color: #069;"><strong>标题</strong></td>
    <td width="540" bgcolor="#F0F7FD"><input name="" type="text" style="background-color: #FFFFFF;
    border: 1px solid #91C0E3;
    color: #004779;width:250px;" /></td>
  </tr>
  <tr>
    <td height="53" align="center" valign="middle" bgcolor="#F0F7FD" style="color:#069;"><strong>内容</strong></td>
    <td bgcolor="#F0F7FD"><textarea name="" cols="" rows="" style="background-color: #FFFFFF;
    border: 1px solid #91C0E3;
    color: #004779;width:250px;height:auto;" ></textarea></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#F0F7FD" height="50"><table width="199" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="100"><input name="" type="button" value="check in" style="background: #D3EDFC;border:1px solid  #91C0E3; cursor:pointer;"/></td>
        <td width="99"><input name="" type="button" value="check out" style="background: #D3EDFC;border:1px solid  #91C0E3; cursor:pointer;"/></td>
      </tr>
    </table></td>
    </tr>
</table>
</DIV>

<!--目录内容列表显示-->
<DIV ID="MainArea1" STYLE="margin-left: 3px; width: 700px; float: left; display:none;" border="2">
	 <table width="700" height="57" border="0" cellpadding="0" cellspacing="0" style="font-size:12px;">
  <tr>
    <td height="30"><table width="700" height="26" border="0" cellpadding="0" cellspacing="0" style="background: url(${pageContext.request.contextPath}/style/images/411.jpg) repeat-x;">
      <tr>
        <td align="center" valign="middle" style="border:1px solid #CBE3ED;border-right:none;">版本号</td>
        <td align="center" valign="middle" style="border:1px solid #CBE3ED;">修改时间</td>
        <td align="center" valign="middle" style="border:1px solid #CBE3ED;border-left:none;">相关操作</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="700" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="240" height="26" align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;">1</td>
    <td width="232" align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;">2010-5-24 09:56:33</td>
    <td width="231" align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;">删除</td>
  </tr>
  <tr >
    <td height="26" align="center" valign="middle" bgcolor="#F7F7F7" style="border-bottom:1px solid #f3f8fd;">2</td>
    <td align="center" valign="middle" bgcolor="#F7F7F7" style="border-bottom:1px solid #f3f8fd;">2010-5-24 09:56:33</td>
    <td align="center" valign="middle" bgcolor="#F7F7F7" style="border-bottom:1px solid #f3f8fd;">删除</td>
  </tr>
  <tr>
    <td height="26" align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;">3</td>
    <td align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;">2010-5-24 09:56:33</td>
    <td align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;">删除</td>
  </tr>
</table>
</td>
  </tr>
</table>
</DIV>
<div class="addnodes" id="rMenu" style="position:absolute;display:none;">
       <ul>
         <li style="background: url(${pageContext.request.contextPath}/style/images/jia.jpg) 10px 5px no-repeat;border-bottom:1px solid #8ab2e6;">增加节点</li>
         <li style="background: url(${pageContext.request.contextPath}/style/images/jian.jpg) 10px 9px no-repeat;">删除节点</li>
       </ul>
    </div>
</BODY>
</HTML>
