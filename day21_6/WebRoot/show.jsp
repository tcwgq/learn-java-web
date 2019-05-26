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

<title>My JSP 'show.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1 align="center">显示结果</h1>
	<table align="center" width="60%" border="1">
		<tr>
			<th>图书</th>
			<th>单价</th>
			<th>分类</th>
		</tr>
		<c:forEach items="${requestScope.books }" var="book">
			<tr>
				<td>${book.bname }</td>
				<td>${book.price }</td>
				<td><c:choose>
						<c:when test="${book.category eq 1 }">JavaSE</c:when>
						<c:when test="${book.category eq 2 }">JavaEE</c:when>
						<c:when test="${book.category eq 3 }">Framework</c:when>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
