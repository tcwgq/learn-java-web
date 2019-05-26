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

<title>My JSP 'json3.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<c:url value='/ajax-lib/ajax.js'/>">
	
</script>
<script type="text/javascript">
	window.onload = function() {
		var btn = document.getElementById("btn");
		btn.onclick = function() {
			ajax({
				url : "<c:url value='/BServlet'/>",
				type : "json",
				callback : function(data) {
					document.getElementById("h1").innerHTML = data.id + ", "
							+ data.username + ", " + data.password;
				}
			});
		};
	};
</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>测试自己封装的小工具</h1>
	<h1 id="h1"></h1>
	<button id="btn">点击这里有惊喜</button>
</body>
</html>
