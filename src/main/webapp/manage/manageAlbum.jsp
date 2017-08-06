<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String manager = (String) session.getAttribute("manager");
	if (manager == null )
		response.sendRedirect("/manage/login");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/default/easyui.css">
<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<title>相册管理</title>
</head>
<body>
	<script>
		/*
		function submitForm() {
			$('#createAlbumForm').form('submit', {
				onSubmit : function() {
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
		*/
	</script>
	<form class="easyui-form" id="createAlbumForm"
		action="<%=basePath%>/createAlbum"
		onsubmit="return submitForm()" data-options="novalidate:true">
		相册名称<input name="albumName" class="easyui-textbox" type="text"
			data-options="required:true" /> <input type="submit"
			class="easyui-linkbutton" value="创建相册" />
	</form>
	<br>
	<br>

	<table border="1">
		<tr>
			<td>相册名</td>
			<td>相册封面</td>
			<td>相册管理</td>
			<td>删除相册</td>
			<!-- <td>相册名更改</td>
			 -->
		</tr>
		<s:iterator value="albumList" id="album">
			<tr>
				<td>${album.albumName}</td>
				<td><img alt="${album.albumName }"
					src="${album.albumUrl }" width="150" height="200"></td>
				<td><a href="#"
					onclick="open1('<%=basePath%>manage/addPhoto?albumId=${album.albumId }')">添加图片</a><br />
					<a href="#"
					onclick="open1('<%=basePath%>manage/showPhotoForAlbum?albumId=${album.albumId }')">查看图片</a>
				</td>
				<td>
					<a href="#" onclick="open1('<%=basePath%>editor/deleteAlbum?albumId=${album.albumId}')">删除相册</a>
				</td>
				<!-- <td>
					<form action="/editor/updataAlbum">
						<input name="albumId" type="text" value="${album.albumId}"
							style="display: none" /> <input name="albumName" type="text"
							value="${album.albumName}" /> <input type="submit" value="更改相册" />
					</form>
				</td>
				 -->
			</tr>
		</s:iterator>
	</table>

</body>
</html>