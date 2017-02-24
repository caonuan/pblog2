<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新建博客</title>
</head>
<body>
	<form id="TextArea1" action="<%=basePath%>/addArticleResult" name="myform" method="post">
		标题 <input name="title" type="text" maxlength="50"
			style="width: 800px; height: 25px" /><br /> 类型 <select name="blogClassId">
			<s:iterator value="classList" id="blogClass">
				<option value="${blogClass.blogClassId}">${blogClass.className }</option>
				<br />
			</s:iterator>
		</select> 置顶<select name="topPost">
			<option value="0" selected="selected">否</option>
			<option value="1">是</option>
		</select> 隐藏<select name="hidden">
			<option value="0" selected="selected">否</option>
			<option value="1">是</option>
		</select>
		<ckfinder:setupCKEditor editor="content" basePath="ckfinder/" />
		<ckeditor:editor basePath="ckeditor/" editor="content" />
		<input type="submit" value="上传文章" />
	</form>

</body>
</html>