<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.web.*"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<h1>登录xx</h1>
<body>
	<span style="color: red"><%=session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)%></span>
	<form action="<%=basePath%>j_spring_security_check" method="post">
		Account：<Input name="j_username" /><br /> Password：<input name="j_password" type="password" /><br /> <input value="submit" type="submit" />
	</form>
</body>
</body>

</html>