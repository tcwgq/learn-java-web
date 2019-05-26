<!-- 这是jsp指令，它是一种特殊的额jsp标签 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- java代码片段 -->
<%
	//获取项目名称
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 向页面中输出basePath -->
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
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
	<%--这是jsp注释，不会出现在生成的Java文件中，因此不会发送给浏览器 --%>
	<h1>演示在jsp中嵌入Java代码</h1>
	<%
		//方法中能写什么，这个地方就能写什么
		int a = 10;
	%>
	<%
		out.print(a++);
	%>
	<br/>
	<!-- response.getWriter.write()，括号中能写什么，这里就能写什么 -->
	<%=a%>
	<br/>
	<%!
		//类中能写什么，这里就能写什么
		private int a = 100;
		public void fun(){
			System.out.println(a);
		}
	%>
	<%
		out.print(a++);
		out.print("<br/>");
		out.print(this.a++);
		fun();
	%>
	<br/>
	<br>
</body>
</html>
