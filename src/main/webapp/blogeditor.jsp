<%@page import="pblog.entity.BlogClass"%>
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
<title>编辑博文</title>
<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<form id="TextArea1" action="<%=basePath%>/editor/editorArticleResult" name="myform"
		method="post">
		标题 <input name="title" type="text" maxlength="50"
			style="width: 800px; height: 25px" value="${title}" /><br /> 类型 <select
			name="blogClassId">
			<s:iterator value="classList" id="blogClass">
				<s:if test="#blogClass.blogClassId==thisBlogClassId">
					<option value="${blogClass.blogClassId}" selected="selected">${blogClass.className }</option>
				</s:if>
				<s:else>
					<option value="${blogClass.blogClassId}">${blogClass.className }</option>
				</s:else>
				<br />
			</s:iterator>
		</select> 置顶<select name="topPost">
			<s:if test="topPost==0">
				<option value="0" selected="selected">否</option>
				<option value="1">是</option>
			</s:if>
			<s:else>
				<option value="0">否</option>
				<option value="1" selected="selected">是</option>
			</s:else>
		</select> 隐藏<select name="hidden">
			<s:if test="hidden==0">
				<option value="0" selected="selected">否</option>
				<option value="1">是</option>
			</s:if>
			<s:else>
				<option value="0">否</option>
				<option value="1" selected="selected">是</option>
			</s:else>
		</select>
		<ckfinder:setupCKEditor editor="content" basePath="ckfinder/" />
		<ckeditor:editor basePath="ckeditor/" editor="content" value="${content }" />
		<input type="hidden" name="articleId" value="${articleId }"> <input
			type="submit" value="上传文章" />
		<s:debug></s:debug>
	</form>
</body>
</html>