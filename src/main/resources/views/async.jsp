<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Async</title>
</head>
<body>
	<script type="text/javascript" src="assets/js/jquery.js"></script>
	<script type="text/javascript">
		//	打开页面就请求
		deferred();
		
		function deferred() {
			//	使用jQuert-Ajax的get请求
			$.get('deferr', function(data) {
				//	输出在控制台，页面无变化
				console.log(data);
				//	循环发送请求
				deferred();
			});
		}
	</script>
</body>
</html>