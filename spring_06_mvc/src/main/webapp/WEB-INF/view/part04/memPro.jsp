<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Member data</p>
<p>이름:${name}</p>
<p>나이:${age}</p>
<hr/>

<!-- 클래스이름첫글자는 무조건 소문자 -->
<p>이름:${memDTO.name}</p>
<p>나이:${memDTO.age}</p>
<hr/>

 <p>이름:${dto.name}</p>
<p>나이:${dto.age}</p> 


</body>
</html>