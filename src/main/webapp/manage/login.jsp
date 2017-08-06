<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人博客管理登录</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>img/favicon.ico" />
</head>
<body>
	<%
		String admin = (String) session.getAttribute("manager");
		//System.out.print(admin);
		//if (admin == null) {
	%>
	<div id="loginBox">
		<div class="title" id="Mdown">
			<span class="t1">登录</span>
		</div>
		<div class="login">
			<form method="post" action="<%=basePath%>manage/managerlogin">
				<table>
					<tr>
						<td>用户名:</td>
						<td><input type="text" name="username" size="12"
							maxlength="10"></td>
					</tr>
					<tr>
						<td>密 码:</td>
						<td><input type="password" name="password" size="12"
							maxlength="10"></td>
					</tr>
					<tr>
						<td></td>
						<td><button class="submit" type="submit">登陆</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%
	//	} else {
	%>
	<div>
			<s:debug></s:debug>
	</div>
	<%
	//	}
	%>
</body>
</html>