<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head> 
</head>
<body>
	<h2>Hello World!</h2>
	<h3>这是主页 index</h3>
	<a href="<%=basePath%>sp/adminView.do">查看受保护页面</a>
	
	<a href="<%=basePath%>sp/indexAdd.do">actionAdd</a>
	
	<a href="<%=basePath%>sp/indexEdit.do?u=ab&p=qe">actionEdit</a>
	
	<a href="<%=basePath%>sp/indexDel.do?u=ab&p=qe">actionDel</a> 
</body>
</html>
