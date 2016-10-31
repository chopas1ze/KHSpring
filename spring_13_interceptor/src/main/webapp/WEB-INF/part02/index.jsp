<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link href="css/header.css" type="text/css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var chk = '${empty sessionScope.chk}' == 'true' ? true : false;
		init(chk);

		/* var chk = '${empty sessionScope.chk}' == 'true' ? true : false;
		if (chk) {
			$('#logInPage').removeClass('hidePage').addClass('showPage');
			$('#logOutPage').removeClass('showPage').addClass('hidePage');
		} else {
			$('#logInPage').removeClass('showPage').addClass('hidePage');
			$('#logOutPage').removeClass('hidePage').addClass('showPage');
		} */

	});
</script>
</head>
<body>

<c:if test="${!empty param.returnUrl}">
<script>
 alert('로그인후 페이지 이동');
 </script>
</c:if>
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<div id="body">
		<p>main page</p>
	</div>

</body>
</html>