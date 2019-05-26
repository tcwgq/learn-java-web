<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户列表</title>

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
	<h3 align="center">客户列表</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>客户姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>手机</th>
			<th>邮箱</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach var="cs" items="${requestScope.pb.beanList }">
			<tr>
				<td>${cs.cname }</td>
				<td>${cs.gender }</td>
				<td>${cs.birthday }</td>
				<td>${cs.cellphone }</td>
				<td>${cs.email }</td>
				<td>${cs.description }</td>
				<td><a
					href="<c:url value='/CustomerServlet?method=find&cid=${cs.cid }'/>">编辑</a>
					<a
					href="<c:url value='/CustomerServlet?method=delete&cid=${cs.cid }'/>">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>
		<c:choose>
			<c:when test="${requestScope.pb.tp > -1 }">
				<span>第${requestScope.pb.pc }页/共${requestScope.pb.tp }页</span>
				<a href="${requestScope.pb.url }&pc=1">首页</a>
				<c:if test="${requestScope.pb.pc > 1 }">
					<a href="${requestScope.pb.url }&pc=${requestScope.pb.pc - 1 }">上一页</a>
				</c:if>
				<!-- 页码表显示10个 -->
				<c:choose>
					<c:when test="${requestScope.pb.tp <=10 }">
						<!-- 默认为page域 -->
						<c:set var="begin" value="1" />
						<c:set var="end" value="${requestScope.pb.tp }" />
					</c:when>
					<c:otherwise>
						<c:set var="begin" value="${requestScope.pb.pc - 5 }" />
						<c:set var="end" value="${requestScope.pb.pc + 4 }" />
						<c:if test="${begin < 1 }">
							<c:set var="begin" value="1" />
							<c:set var="end" value="10" />
						</c:if>
						<c:if test="${end > requestScope.pb.tp }">
							<c:set var="begin" value="${requestScope.pb.tp - 9 }" />
							<c:set var="end" value="${requestScope.pb.tp }" />
						</c:if>
					</c:otherwise>
				</c:choose>
				<c:forEach var="page" begin="${begin }" end="${end }">

					<c:choose>
						<c:when test="${requestScope.pb.pc eq page }">
							<font size="5">[${page }]</font>
						</c:when>
						<c:otherwise>
							<a href="${requestScope.pb.url }&pc=${page }"><font size="5">${page
									}</font> </a>
						</c:otherwise>
					</c:choose>

				</c:forEach>
				<c:if test="${ requestScope.pb.pc < requestScope.pb.tp}">
					<a href="${requestScope.pb.url }&pc=${requestScope.pb.pc + 1 }">下一页</a>
				</c:if>
				<a href="${requestScope.pb.url }&pc=${requestScope.pb.tp }">尾页</a>
			</c:when>
			<c:otherwise>无指定条件的记录</c:otherwise>
		</c:choose>
	</center>
</body>
</html>
