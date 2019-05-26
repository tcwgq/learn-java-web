<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/WEB-INF/tlds/mytag.tld"%>
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

<title>My JSP 'tag.jsp' starting page</title>

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
	<h1>
		<my:myTag1 />
	</h1>
	<h1>
		<my:myTag2 />
	</h1>
	<h1>
		<c:set var="name" value="zhangSan" scope="page" />
		<my:myTag3>${name }</my:myTag3>
	</h1>
	<h1>
		<my:myTag3>我是张三的小弟</my:myTag3>
	</h1>
	<h1>
		<my:myTag5 test="${empty param.xxx }">
			<my:myTag4 />
		</my:myTag5>
	</h1>
	<h1>这是最后面的内容！</h1>
</body>
</html>
