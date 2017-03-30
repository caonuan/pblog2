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
<style>
body, #Mdown {
	margin: 0;
	padding: 0;
	text-align: center;
	font: normal 14px/180% Tahoma, sans-serif;
}

#loginBox {
	margin: 0 auto;
	padding: 0px;
	text-align: left;
	width: 280px;
	height: 150px;
	background: #EAEEFF;
	font-size: 9pt;
	border: 1px solid #829AFF;
	overflow: hidden;
	filter: alpha(opacity = 90);
	opacity: 1;
}

#loginBox .title {
	text-align: left;
	padding-left: 10px;
	font-size: 11pt;
	border-bottom: 1px solid #829AFF;
	height: 25px;
	line-height: 25px;
	cursor: move;
}

#loginBox .t1 {
	float: left;
	font-weight: bold;
	color: #AA7B7B;
	text-decoration: none;
}

#loginBox .t2 {
	float: right;
	text-align: center;
	line-height: 18px;
	height: 18px;
	width: 18px;
	margin-top: 3px;
	margin-right: 2px;
	overflow: hidden;
	border: 1px solid #FF5889;
	background: #FFE0E9;
	cursor: pointer;
}

#loginBox .login {
	text-align: center;
	width: 100%;
	height: 100%;
}

input.submit {
	float: right;
	border: 1px solid #829AFF;
	FONT-SIZE: 9px;
	background: #EAEEFF;
	HEIGHT: 20px;
	margin-top: 5px;
	margin-right: 70px;
}

#bgDiv {
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0px;
	left: 0px;
	right: 0px;
	background-color: #777;
	opacity: 0.7;
}
</style>
</head>
<script type="text/javascript">
	var IsMousedown, LEFT, TOP, login;
	document.getElementById("Mdown").onmousedown = function(e) {
		login = document.getElementById("loginBox");
		IsMousedown = true;
		e = e || event;
		LEFT = e.clientX - parseInt(login.style.left);
		TOP = e.clientY - parseInt(login.style.top);
		document.onmousemove = function(e) {
			e = e || event;
			if (IsMousedown) {
				login.style.left = e.clientX - LEFT + "px";
				login.style.top = e.clientY - TOP + "px";
			}
		}
		document.onmouseup = function() {
			IsMousedown = false;
		}
	}
</SCRIPT>
<body>
	<%
		String admin = (String) session.getAttribute("manager");
		//System.out.print(admin);
		//if (admin == null) {
	%>
	<div id="bgDiv" style="display: none;"></div>
	<a href="javascript:"
		onClick="bgDiv.style.display='';loginBox.style.display='';">登录</a>
	<div id="loginBox"
		style="position: absolute; left: 367px; top: 150px; z-index: 1; display: none;">
		<div class="title" id="Mdown">
			<span class="t1">登录</span><span class="t2" title="关闭"
				onClick="login.style.display='none';bgDiv.style.display='none'">X</span>
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