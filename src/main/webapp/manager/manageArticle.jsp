<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String manager = (String) session.getAttribute("manager");
	if (manager == null )
		response.sendRedirect("/manager/login");
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/default/easyui.css">
<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<title>管理日志</title>
</head>
<body>
	<div class="easyui-panel" id="main">
		<div>
			<input type="button" class="easyui-linkbutton"
				onclick="open1('<%=basePath%>createArticle')" value="新建博客">
		</div>
		<table>
			<tr>
				<td>博文编号</td>
				<td>标题</td>
				<td>删除</td>
				<td>修改</td>
			</tr>
			<s:iterator value="articleList" id="article">
				<tr>
					<td><s:property value="#article.articleId" /></td>
					<td><s:property value="#article.title" /></td>
					<td><a href="#"
						onclick="open1('<%=path %>/deleteArticle?articleId=${article.articleId }')">删除</a></td>
					<td><a href="#"
						onclick="open1('<%=path %>/updateArticle?articleId=${article.articleId }')">修改</a></td>
				</tr>
			</s:iterator>
		</table>
		<div class="easyui-pagination" id="pagination"
			data-options="total: ${pageCount*10 },showPageList: false,showRefresh: false,displayMsg: '',pageNumber:${page },
			onSelectPage:function(pageNumber, pageSize){
				$('#main').panel('refresh','<%=basePath%>manager/manageArticle?page='+pageNumber);
			}"
			style="width: 225px"></div>
	</div>
	<!-- <a id="backPage"
		href="<%=basePath%>manager/manageArticle?page=${page-1}">上一页</a>
	${page}/${pageCount}
	<a id="nextPage"
		href="<%=basePath%>manager/manageArticle?page=${page+1}">下一页</a>
	<br>
	<c:forEach var="i" begin="1" end="${pageCount}">
		<a href="<%=basePath%>manager/manageArticle?page=${i}">${i}</a>
	</c:forEach>
	<script type="text/javascript">
		page = $
		{
			page
		};
		pageCount = $
		{
			pageCount
		};
		if (page <= 1) {
			document.getElementById('backPage').removeAttribute("href");
		}
		if (page >= pageCount) {
			document.getElementById('nextPage').removeAttribute("href");
		}
	</script>
	 -->
</body>
</html>