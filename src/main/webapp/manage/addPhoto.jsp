<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加照片</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/demo/demo.css">
<script type="text/javascript" src="<%=basePath %>easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<div class="easyui-panel" title="添加照片" style="width: 400px" data-options="iconCls:'icon-save',tools:'#tt'">
		<div style="padding: 10px 60px 20px 60px" >
			<s:form action="addPhotoResult" method="post"
				enctype="multipart/form-data" namespace="/manage" class="easyui-form"
				data-options="novalidate:true">
				<s:select name="albumId" list="albumMap" value="albumId"></s:select>
				<!--<s:file name="myFile" label="MyFile" ></s:file>
				-->
				<input class="easyui-filebox" name="myFile" data-options="prompt:'选择一个图片'" style="width:100%">
				<br />
		文件名：<s:textfield name="photoName" label="photoName"></s:textfield>
				<br />
				<s:submit label="提交"></s:submit>
			</s:form>
		</div>
	</div>
	<div id="tt">
		<a  class="icon-back" href="<%=basePath%>manage/anageAlbum"></a>
	</div>
</body>
</html>
