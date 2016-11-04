<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8" />

<title>Socket.IO chat</title>
<style type="text/css">
	iframe {
	background-color: #e5e5e5;
}
#chat{
	text-align: center;
}

</style>
</head>
<body><br/>
	<input type="hidden" value="${sessionScope.memid }">
	<div id="chat">
	<p>문의하세요</p>
		<iframe width="850px" height="500px" src="http://192.168.10.29:3000/" name="iframe_a" ></iframe>
		
	</div>
	
</body>
</html>