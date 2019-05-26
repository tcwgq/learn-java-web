<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		Locale locale = request.getLocale();
		ResourceBundle rb = ResourceBundle.getBundle("res", locale);
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("login"));
	%>
	<h1><%=rb.getString("username") %></h1>
	<form action="">
		<%=rb.getString("username") %>：<input type="text" name="username" /><br /> 
		<%=rb.getString("password") %>：<input type="text" name="password" /><br /> <input type="submit"
			value="<%=rb.getString("login") %>" />
	</form>
</body>
</html>
