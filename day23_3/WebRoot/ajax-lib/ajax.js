function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();// 大多数浏览器
	} catch (e) {
		try {
			return ActvieXObject("Msxml2.XMLHTTP");// IE6.0
		} catch (e) {
			try {
				return ActvieXObject("Microsoft.XMLHTTP");// IE5.5及更早版本
			} catch (e) {
				alert("哥们儿，您用的是什么浏览器啊？");
				throw e;
			}
		}
	}
}
/*
 * option对象有如下属性
 */
/*
 * 请求方式method, 请求的url url, 是否异步asyn, 请求体params, 回调方法callback, 服务器响应数据转换成什么类型type
 */
function ajax(option) {
	var xmlHttp = createXMLHttpRequest();
	if (!option.method) {// 默认为GET请求
		option.method = "GET";
	}
	if (option.asyn == undefined) {// 默认为异步处理
		option.asyn = true;
	}
	xmlHttp.open(option.method, option.url, option.asyn);
	if ("POST" == option.method) {
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
	}
	xmlHttp.send(option.params);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {// 双重判断
			var data;
			if (!option.type) {// 如果type没有赋值，那么默认为文本
				data = xmlHttp.responseText;
			} else if (option.type == "xml") {
				data = xmlHttp.responseXML;
			} else if (option.type == "text") {
				data = xmlHttp.responseText;
			} else if (option.type == "json") {
				var text = xmlHttp.responseText;
				data = eval("(" + text + ")");
			}
			option.callback(data);
		}
	};
};

