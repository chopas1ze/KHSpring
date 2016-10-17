<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<c:forEach items="${aList}" var="dto">
			<c:forEach items="${dto.list}" var="item">
				<p>${item.id}/ ${item.cnt} /
				   ${item.remark}/ ${dto.address}</p>
			</c:forEach>
		</c:forEach>
</body>
</html>











