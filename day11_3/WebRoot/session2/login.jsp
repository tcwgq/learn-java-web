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

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function _change() {
		var img = document.getElementById("img");
		//后面的参数用来蒙骗浏览器的缓存
		img.src = "/day11_3/VerifyCodeServlet?aaa=" + new Date().getTime();
	}
</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>登录</h1>
	<%
		String name = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("name")) {
					name = cookie.getValue();
				}
			}
		}
	%>
	<%
		String message = "";
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			message = msg;
		}
	%>

	<form action="/day11_3/LoginServlet" method="post">
		<table>
			<caption>登录</caption>
			<tr>
				<td>&nbsp;</td>
				<td><font color="red"><%=message%></font></td>
			</tr>
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" name="username" />
				</td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td align="right">验证码：</td>
				<td><input type="text" name="verifyCode" size="10" /> <img
					id="img" src="/day11_3/VerifyCodeServlet" /> <a
					href="javascript:_change()">换一张</a>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="登录" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
