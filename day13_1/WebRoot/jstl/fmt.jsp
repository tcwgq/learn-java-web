<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>My JSP 'fmt.jsp' starting page</title>

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
	<h1>演示格式化标签</h1>
	<h2>formatDate标签</h2>
	<c:set var="date" value="<%=new Date()%>" />
	<%--H代表24小时制，h代表12小时制 --%>
	<fmt:formatDate value="${date}" pattern="G yyyy-MM-dd HH:mm:ss" />
	<br />
	<c:set var="now" value="<%=new Date()%>" />
	<p>
		Formatted Date (1):
		<fmt:formatDate type="time" value="${now}" />
	</p>
	<p>
		Formatted Date (2):
		<fmt:formatDate type="date" value="${now}" />
	</p>
	<p>
		Formatted Date (3):
		<fmt:formatDate type="both" value="${now}" />
	</p>
	<p>
		Formatted Date (4):
		<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
			value="${now}" />
	</p>
	<p>
		Formatted Date (5):
		<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"
			value="${now}" />
	</p>
	<p>
		Formatted Date (6):
		<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
			value="${now}" />
	</p>
	<p>
		Formatted Date (7):
		<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />
	</p>
	<hr />
	<h2>formatNumber标签</h2>
	<c:set var="num" value="3.1415926" />
	<!-- 使用0位数不够时补0 -->
	<fmt:formatNumber value="${num}" pattern="0.00" />
	<br />
	<fmt:formatNumber value="${num}" pattern="0.000" />
	<br />
	<!-- 使用#位数不够时不补0 -->
	<fmt:formatNumber value="${num}" pattern="#.##" />
	<br />
	<fmt:formatNumber value="${num}" pattern="#.###" />
	<br />
	<c:set var="balance" value="120000.2309" />
	<p>
		Formatted Number :
		<fmt:formatNumber value="${balance}" />
	</p>
	<p>
		Formatted Number (1):
		<fmt:formatNumber value="${balance}" type="currency" />
	</p>
	<p>
		Formatted Number (2):
		<fmt:formatNumber type="number" maxIntegerDigits="3"
			value="${balance}" />
	</p>
	<p>
		Formatted Number (3):
		<fmt:formatNumber type="number" maxFractionDigits="3"
			value="${balance}" />
	</p>
	<p>
		Formatted Number (4):
		<fmt:formatNumber type="number" groupingUsed="true"
			value="${balance}" />
	</p>
	<p>
		Formatted Number (5):
		<fmt:formatNumber type="percent" maxIntegerDigits="3"
			value="${balance}" />
	</p>
	<p>
		Formatted Number (6):
		<fmt:formatNumber type="percent" minFractionDigits="10"
			value="${balance}" />
	</p>
	<p>
		Formatted Number (7):
		<fmt:formatNumber type="percent" maxIntegerDigits="3"
			value="${balance}" />
	</p>
	<p>
		Formatted Number (8):
		<!-- 0代表一位数字 -->
		<!-- #代表一位数字，没有则显示0 -->
		<!-- 下面表示以###.###*10^n次方的形式表示数据 -->
		<fmt:formatNumber type="number" pattern="###.###E0" value="${balance}" />
	</p>
	<p>
		Currency in USA :
		<!-- setLocale用来设置时区 -->
		<fmt:setLocale value="en_US" />
		<fmt:formatNumber value="${balance}" type="currency" />
	</p>
</body>
</html>
