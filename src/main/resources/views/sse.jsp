<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSE</title>
</head>
<body>
	<div id="msgFromPush"></div>
	<script type="text/javascript" src="<c:url value="assets/js/jquery.js" />"></script>
	<script type="text/javascript">
		/*
			EventSource对象只有新式浏览器才有(Chrome、Firefox等)
			EventSource是SSE的客户端
		*/
		if (!!window.EventSource) {
			var source = new EventSource('push');
			s = '';
			//	添加SSE客户端监听，在此获得服务器推送的消息。
			source.addEventListener('message', function(e) {
				s += e.data + "<br/>";
				$("#msgFromPush").html(s);
			});
			
			source.addEventListener('open', function(e) {
				console.log("连接打开");
			}, 'false');
			
			source.addEventListener('error', function(e) {
				if (e.readyState == EventSource.CLOSED) {
					console.log("连接关闭");
				} else {
					console.log(e.readyState);
				}
			}, 'false');
		} else {
			console.log("您的浏览器不支持SSE");
		}
	</script>
</body>
</html>