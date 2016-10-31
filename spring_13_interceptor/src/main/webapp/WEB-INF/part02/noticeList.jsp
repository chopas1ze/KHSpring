<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="css/header.css" type="text/css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	var chk = '${empty sessionScope.chk}' == 'true' ? true : false;
	init(chk);
});
</script>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="body">
<p>noticeList</p>
</div>
</body>
</html>