<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
    <a href="/day10_3/AServlet?username=zhangSan&password=123">点击这里</a>
	<form action="/day10_3/AServlet" method="post">
		<table>
			<caption>注册账号</caption>
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
				<td align="right">爱好：</td>
				<td>
					<input type="checkbox" name="hobby" value="sing" />唱歌 
					<input type="checkbox" name="hobby" value="dance" />跳舞
				    <input type="checkbox" name="hobby" value="travel" />旅游
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="注册" />
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
