<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.tcwgq.domain.*"%>
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
		Address address = new Address();
		address.setCity("北京");
		address.setStreet("西三旗");
		Employee emp = new Employee();
		emp.setName("王五");
		emp.setSalary(123456);
		emp.setAddress(address);
		request.setAttribute("emp", emp);
	%>
	<!-- 相当于emp.getAddress().getCity() -->
	<!-- 当要存取的属性名称中包含一些特殊字符，如.或?等并非字母或数字的符号，就一定要使用 [] -->
	<!-- 如果要动态取值时，就可以用[]来做，而.无法做到动态取值 -->
	${requestScope.emp.name}<br/>
	${requestScope.emp.salary}<br/>
	${requestScope.emp.address.city}<br/>
	${requestScope.emp.address.street}<br/>
	${requestScope.emp.hehe}<br/>
</body>
</html>
