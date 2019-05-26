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

<title>My JSP 'core.jsp' starting page</title>

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
	<h1>演示jstl核心标签</h1>
	<h2>set标签</h2>
	<c:set var="code" value="<script>alert('hello');</script>"
		scope="request"></c:set>
	<h2>out标签</h2>
	<c:out value="${code }" escapeXml="true" default="abc"></c:out>
	<h2>remove标签</h2>
	<c:set var="salary" scope="session" value="${2000*2}" />
	<p>
		Before Remove Value:
		<c:out value="${salary}" />
	</p>
	<c:remove var="salary" scope="session" />
	<p>
		After Remove Value:
		<c:out value="${salary}" />
	</p>
	<hr />
	<h2>url标签与param标签</h2>
	<!-- param标签用于在url标签中指定参数，而且与URL编码相关。 -->
	<c:url value="/index.jsp" />
	<br />
	<!-- 保存在变量中就不输出了 -->
	<c:url var="url" value="/index.jsp" scope="request" />
	<br />
	<c:url value="/index.jsp">
		<!-- 参数是中文时，自动URL编码 -->
		<c:param name="username" value="张三" />
		<c:param name="password" value="123" />
	</c:url>
	<br />
	<a href="<c:url value='/index.jsp' />">点击这里，回到主页</a>
	<hr />
	<h2>if标签</h2>
	<c:set var="a" value="hello" />
	<c:if test="${not empty a }">
		<c:out value="${a }"></c:out>
	</c:if>
	<hr />
	<h2>choose, when, otherwise标签</h2>
	<c:set var="score" value="110" />
	<c:choose>
		<c:when test="${score <0 || score > 100 }">
			<c:out value="分数错误" />
		</c:when>
		<c:when test="${score>= 90}">
			<c:out value="A" />
		</c:when>
		<c:when test="${score>= 80}">
			<c:out value="B" />
		</c:when>
		<c:when test="${score>= 70}">
			<c:out value="C" />
		</c:when>
		<c:when test="${score>= 60}">
			<c:out value="D" />
		</c:when>
		<c:otherwise>
			<c:out value="不及格" />
		</c:otherwise>
	</c:choose>
	<hr />
	<h2>catch标签</h2>
	<c:catch var="catchException">
		<%
			int a = 10 / 0;
		%>
	</c:catch>
	<c:if test="${not empty catchException }">
		<c:out value="${catchException }"></c:out>
	</c:if>
	<hr />
	<h2>import标签</h2>
	<%--<c:import>标签提供了所有<jsp:include>行为标签所具有的功能，同时也允许包含绝对URL。 --%>
	<%--context属性为/紧接着一个本地网络应用程序的名称，表示项目的相对路径 --%>
	<c:import var="data" url="/index.jsp" charEncoding="utf-8"
		context="/day13_1" />
	<c:out value="${data }" />
	<hr />
	<h2>redirect标签</h2>
	<%--访问day12_1项目下的index.jsp，只需添加context="/day12_1" --%>
	<%--<c:redirect url="/index.jsp">
		<c:param name="username" value="张三"/>
	</c:redirect>
	--%>
	<hr />
	<h2>forEach标签</h2>
	<hr />
	<h2>forTokens标签</h2>
	<!-- 简单用法 -->
	<%--相当于for(int i = 1; i <= 10; i++)--%>
	<c:forEach var="i" begin="1" end="10" step="2">
		<c:out value="${i }"></c:out>
	</c:forEach>
	<br />
	<%--迭代集合或数组 --%>
	<%
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("java");
		list.add("PHP");
		request.setAttribute("list", list);
	%>
	<%--  begin：如果指定了items，那么迭代就从items[begin]开始进行迭代；如果没有指定items，那么就从begin开始迭代。它的类型为整数。 --%>
	<%--  end：如果指定了items，那么就在items[end]结束迭代；如果没有指定items，那么就在end结束迭代。它的类型也为整数。 --%>
	<c:forEach var="ele" begin="2" end="3" items="${requestScope.list }">
		<c:out value="${ele }"></c:out>
	</c:forEach>
	<br />
	<%
		List<String> arr = new ArrayList<String>();
		arr.add("aaa");
		arr.add("bbb");
		arr.add("ccc");
		arr.add("ddd");
		arr.add("eee");
		request.setAttribute("arr", arr);
	%>
	<table border="1">
		<tr>
			<td>item</td>
			<td>index</td>
			<td>count</td>
			<td>current</td>
			<td>begin</td>
			<td>end</td>
			<td>step</td>
			<td>first</td>
			<td>last</td>
		</tr>
		<c:forEach var="item" begin="0" end="10" step="1"
			items="${requestScope.arr}" varStatus="vs">
			<tr>
				<td><c:out value="${item }" /></td>
				<td><c:out value="${vs.index }" /></td>
				<td><c:out value="${vs.count }" /></td>
				<td><c:out value="${vs.current }" /></td>
				<td><c:out value="${vs.begin }" /></td>
				<td><c:out value="${vs.end }" /></td>
				<td><c:out value="${vs.step }" /></td>
				<td><c:if test="${vs.first }">这是第一个</c:if></td>
				<td><c:if test="${vs.last }">这是最后一个</c:if></td>
			</tr>
		</c:forEach>
	</table>
	<hr />
</body>
</html>
