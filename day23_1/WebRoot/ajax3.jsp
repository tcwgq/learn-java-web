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

<title>My JSP 'ajax3.jsp' starting page</title>

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
		var usernameEle = document.getElementById("usernameEle");
		usernameEle.onblur = function() {
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("POST", "<c:url value='/ValidateServlet'/>", true);
			//post请求
			xmlHttp.setRequestHeader("content-type",
					"application/x-www-form-urlencoded");
			xmlHttp.send("username=" + usernameEle.value);
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					var text = xmlHttp.responseText;
					var errorSpan = document.getElementById("errorSpan");
					if (text == "1") {
						errorSpan.innerHTML = "用户名已被注册!";
					} else {
						errorSpan.innerHTML = "";
					}
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
	<h1>演示用户名是否被注册</h1>
	<form action="" method="post">
		用户名：<input id="usernameEle" type="text" name="username" /> 
				<span id="errorSpan"></span><br /> 
		密 码：<input type="password" name="password" /><br/>
				<input type="submit" value="注册" />
	</form>
</body>
</html>
