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

<title>My JSP 'regist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function _change() {
		var img = document.getElementById("img");
		//后面的参数用来蒙骗浏览器的缓存
		img.src = "<c:url value='/VerifyCodeServlet' />?aaa=" + new Date().getTime();
	}
</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>注册</h1>
	<form action='<c:url value='/RegistServlet'/>' method="post">
		<table>
			<tr>
				<td>&nbsp;</td>
				<td><font color="red">${msg }</font></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"
					value="${user.username }" />
					<font color="red">${errors.username }</font>
				</td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="text" name="password"
					value="${user.password }" />
					<font color="red">${errors.password }</font>
				</td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="verifyCode" value="${user.verifyCode }" size="10" /> 
				<a href="javascript:_change()">
					<img id="img" src="<c:url value='/VerifyCodeServlet' />" border="1" />
				</a>
				<font color="red">${errors.verifyCode }</font>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="注册" /> <input type="reset"
					value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
