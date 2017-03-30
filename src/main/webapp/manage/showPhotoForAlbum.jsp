<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
<title>查看图片</title>
</head>
<body>
	<div>
		<s:iterator value="photoList" id="photo">
			<div style="float: left; width: 255px; height: 240px">
				<img alt="" src="<%=basePath %>../${photo.url}"
					style="max-width: 250px; max-height: 200px;"></br> <a
					href="<%=basePath%>manage/deletePhoto?photoId=${photo.photoId}&albumId=${albumId}">删除图片</a></br>

			</div>
		</s:iterator>
	</div>
</body>
</html>