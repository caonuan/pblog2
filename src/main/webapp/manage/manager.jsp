<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String manager = (String) session.getAttribute("manager");
	if (manager == null )
		response.sendRedirect(basePath+"/manage/login");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="manage/managerlogin"  method="post">
		<input type="text" name="username">
		<input type="password" name="password">
		<input type="submit" name="登录">
	</form>

</body>
</html>