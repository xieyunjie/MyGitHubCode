<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<script language="javascript" type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<body>
	<h2>Hello World!</h2>
	<h3>这是另一个主页 index2</h3>
	<a href="<%=basePath%>/sp/adminView.do">查看受保护页面</a> 
</body>
</html>
