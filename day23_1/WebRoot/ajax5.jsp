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

<title>My JSP 'ajax5.jsp' starting page</title>

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
		var province = document.getElementById("province");
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("GET", "<c:url value='/ProvinceServlet'/>", true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var text = xmlHttp.responseText;
				var arr = text.split(",");
				for ( var i = 0; i < arr.length; i++) {
					var option = document.createElement("option");
					option.value = arr[i];//实际值
					var textNode = document.createTextNode(arr[i]);
					option.appendChild(textNode);//显示值
					province.appendChild(option);
				}
			}
		};
		province.onchange = function() {
			var city = document.getElementById("city");
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("POST", "<c:url value='/CityServlet'/>", true);
			xmlHttp.setRequestHeader("content-type",
					"application/x-www-form-urlencoded");
			xmlHttp.send("province=" + province.value);
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					var city = document.getElementById("city");
					// 获取其所有子元素
					var optionList = city.getElementsByTagName("option");
					// 循环遍历每个option元素，然后在citySelect中移除
					while (optionList.length > 1) {//子元素的个数如果大于1就循环，等于1就不循环了！
						city.removeChild(optionList[1]);//总是删除1下标，因为1删除了，2就变成1了！
					}
					var xml = xmlHttp.responseXML;
					var list = xml.getElementsByTagName("city");
					for ( var i = 0; i < list.length; i++) {
						var cname;
						if (window.addEventListener) {
							cname = list[i].textContent;//其他浏览器
						} else {
							cname = list[i].text;//IE
						}
						var option = document.createElement("option");
						option.value = cname;
						var textNode = document.createTextNode(cname);
						option.appendChild(textNode);
						city.appendChild(option);
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
	<h1>省市联动</h1>
	<select id="province" name="province">
		<option>---请选择省份---</option>
	</select>
	<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	<select id="city" name="city">
		<option>---请选择城市---</option>
	</select>
</body>
</html>
