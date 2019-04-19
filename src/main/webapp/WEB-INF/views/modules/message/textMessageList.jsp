<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>文本信息记录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }

	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/message/textMessage/">文本信息记录列表</a></li>
		<shiro:hasPermission name="message:textMessage:edit"><li><a href="${ctx}/message/textMessage/form">文本信息记录添加</a></li></shiro:hasPermission>
	</ul>
	<%--<form:form id="searchForm" modelAttribute="textMessage" action="${ctx}/message/textMessage/" method="post" class="breadcrumb form-search">--%>
		<%--<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>--%>
		<%--<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>--%>
		<%--&lt;%&ndash;<ul class="ul-form">&ndash;%&gt;--%>
			<%--&lt;%&ndash;<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>&ndash;%&gt;--%>
			<%--&lt;%&ndash;<li class="clearfix"></li>&ndash;%&gt;--%>
		<%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
	<%--</form:form>--%>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>文件存放相对路径</th>
				<th>文类类型</th>
				<th>文件名称</th>
				<th>预留</th>
				<shiro:hasPermission name="message:textMessage:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="textMessage">
			<thead>
				<th>${textMessage.filepath}</th>
				<th>${textMessage.filetype}</th>
				<th>${textMessage.filename}</th>
				<th>${textMessage.extend}</th>
				<shiro:hasPermission name="message:textMessage:edit"><th>
					<%--<a href="${ctx}/message/textMessage/download?filepath=${textMessage.filepath}">下载文件</a>--%>
					<a href="${ctx}/message/textMessage/download?filepath=${textMessage.filepath}&filename=${textMessage.filename}" onclick="return confirmx('确认下载${textMessage.filename}.txt文件', this.href)">下载文件</a>
    				<a href="${ctx}/message/textMessage/form?id=${textMessage.id}">修改</a>
					<a href="${ctx}/message/textMessage/delete?id=${textMessage.id}" onclick="return confirmx('确认要删除该文本信息记录吗？', this.href)">删除</a>
				</th></shiro:hasPermission>
			</thead>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>