<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="orderInsert.htm" method="post">
		상품1: ID-<input type="text" name="list[0].id"> 
		갯수-<input
			type="text" name="list[0].cnt" > 주의-<input
			type="text" name="list[0].remark"><br />
	  상품2: ID-<input
			type="text" name="list[1].id"> 갯수-<input
			type="text" name="list[1].cnt"> 주의-<input
			type="text" name="list[1].remark"><br /> 
			주소 <input	type="text" name="address" /><br /> <input type="submit">
	</form>
</body>
</html>

