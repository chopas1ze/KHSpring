<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

	<form name="frm" method="post" action="logpro.do">
		<p>
			<label for="id">아이디</label>
			<input type="text"  name="id" />
		</p>

       <p>
        <label for="pass">비밀번호</label>
        <input type="text" name="pass" />
       </p>
       
       <p>
       <input type="hidden" name="returnUrl" value="${param.returnUrl }" />
        <input type="submit" value="로그인" />
       </p>
	</form>
</body>
</html>