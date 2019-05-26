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

<title>My JSP 'ajax1.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();//支持大多数浏览器
		} catch (e) {
			try {
				return ActiveXObjext("MSXML2.XMLHTTP");//ie6.0
			} catch (e) {
				try {
					return ActiveXObjext("Microsoft.XMLHTTP");//ie5.5及更早
				} catch (e) {
					alert("您用的浏览器不支持AJAX");
					throw e;
				}
			}
		}
	}
	window.onload = function() {
		var btn = document.getElementById("btn");
		btn.onclick = function() {
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("GET", "<c:url value='/AServlet'/>", true);
			xmlHttp.send(null);//get请求没有请求体
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					var text = xmlHttp.responseText;
					var h1 = document.getElementById("h1");
					h1.innerHTML = text;
				}
			};
		};
	};
</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1 id="h1"></h1>
	<button id="btn">点击这里有惊喜</button>
</body>
</html>
