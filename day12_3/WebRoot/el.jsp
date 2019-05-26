<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'el.jsp' starting page</title>

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
		pageContext.setAttribute("xxx", "pageContext_xxx");
		request.setAttribute("xxx", "request_xxx");
		session.setAttribute("xxx", "session_xxx");
		application.setAttribute("xxx", "application_xxx");
	%>
	${xxx}<br/>
	${pageScope.xxx}<br/>
	${requestScope.xxx}<br/>
	${sessionScope.xxx}<br/>
	${applicationScope.xxx}<br/>
	<!--千万别给我丢掉了Scope -->
</body>
</html>
