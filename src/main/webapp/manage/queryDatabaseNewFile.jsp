<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查询数据库</title>
</head>
<body>
	<form action="">
		<input type="text" width="500px" height="100px" name="sql"> <input
			type="submit">
	</form>
	<table>
		<tr>
			<s:iterator value="lineName" id="name">
				<td>${name }</td>
			</s:iterator>
		</tr>
		<tr>
			<c:when test="resultSet.next()">
				<td>${result.getString(1) }</td>
			</c:when>
		</tr>
	</table>
</body>
</html>