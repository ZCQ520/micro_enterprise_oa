<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>我的申请查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js"
            charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css"/>
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 我的申请查询
        </div>
        <div id="Title_End"></div>
    </div>
</div>


<div id="QueryArea">
    <div style="height: 30px">
        <form action="${pageContext.request.contextPath}/FlowFormFlowOld/queryApplication" method="post" >
            <table border=0 cellspacing=3 cellpadding=5>
                <tr>
                    <td>按条件查询：</td>
                    <td><select name="templateId" class="SelectStyle">
                        <option value="">查看全部模板</option>
                        <c:forEach items="${templates}" var="tempalte">
                            <option value="${tempalte.id}">${tempalte.name}</option>
                        </c:forEach>
                    </select>
                    </td>
                    <td><select name="status" class="SelectStyle">
                        <option value="">查看全部状态</option>
                        <option value="审批中">审批中</option>
                        <option value="未通过">未通过</option>
                        <option value="已通过">已通过</option>
                    </select>
                    </td>
                    <td><input type="IMAGE" src="${pageContext.request.contextPath}/style/blue/images/button/query.PNG"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
        <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            <td width="250px">标题</td>
            <td width="115px">申请人</td>
            <td width="115px">申请日期</td>
            <td width="115px">当前状态</td>
            <td>相关操作</td>
        </tr>
        </thead>

        <!--显示数据列表：被退回的我的表的单显示示例
        <tbody id="TableData" class="dataContainer" datakey="formList">
            -->
        <!-- 被退回的我的表的单显示示例
			<tr class="TableDetail1 template">
				<td><a href="${pageContext.request.contextPath}/Flow_Formflow/showForm.html">${form.title}</a></td>
				<td>${form.applicant.name}&nbsp;</td>
				<td>${form.applyTime}&nbsp;</td>
				<td>审批中&nbsp;</td>
				<td><a href="${pageContext.request.contextPath}/Flow_Formflow/showForm.html">查看申请信息</a>
					<a href="${pageContext.request.contextPath}/Flow_Formflow/approvedHistory.html">查看流转记录</a>
					<a href="${pageContext.request.contextPath}/Flow_Formflow/editAndResubmitUI.html">修改后再次提交</a>
					<a href="#" onClick="return delConfirm()">删除</a>
				</td>
			</tr>
		</tbody>
		-->

        <!--显示数据列表：正在审批或审批完成的表单显示示例-->
        <tbody id="TableData" class="dataContainer" datakey="formList">
        <!-- 正在审批或审批完成的表单显示示例 -->
        <c:forEach  items="${applicationDTOS}" var="applicationDTO">
        <tr class="TableDetail1 template">
            <td><a href="${pageContext.request.contextPath}/FlowFormFlow/showForm?applicationId=${applicationDTO.application.id}">${applicationDTO.application.title}</a></td>
            <td>${applicationDTO.user.username}&nbsp;</td>
            <td><fmt:formatDate value="${applicationDTO.application.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
            <td>${applicationDTO.application.status}&nbsp;</td>
            <td><a href="${pageContext.request.contextPath}/FlowFormFlow/showForm?applicationId=${applicationDTO.application.id}">查看申请信息</a>
                <a href="${pageContext.request.contextPath}/FlowFormFlow/approvedHistory?applicationId=${applicationDTO.application.id}">查看流转记录</a>
                    ${pageContext.request.contextPath}
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside"></div>
    </div>
</div>


<div class="Description">
    说明：<br/>
    <!--
    1，对于退回的表单，可以执行“修改后再次提交”与“删除”的操作。<br />&nbsp;&nbsp;
       其他状态表单（正在审批的或是审批完成的）则没有这两个操作。<br />
       2，删除退回的申请文档后，此文档相关的审批信息也要同时删除，对应的流程也终止了。<br />
       -->
</div>

</body>
</html>
