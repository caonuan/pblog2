<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form id="TextArea1" action="" name="myform">
		标题 <input name="title" type="text" maxlength="50"
			style="width: 800px; height: 25px" /><br />类型 <input type="radio"
			name="blogclass" value="1" /> A <input type="radio" name="blogclass"
			value="2" /> B <input type="radio" name="blogclass" value="3" /> C
		<input type="radio" name="blogclass" value="4" /> D <input
			type="radio" name="blogclass" value="5" /> E<br />
		<ckfinder:setupCKEditor editor="content" basePath="ckfinder/" />
		<ckeditor:editor basePath="ckeditor/" editor="content" />
		<input type="submit" value="上传文章" />
	</form>

</body>
</html>