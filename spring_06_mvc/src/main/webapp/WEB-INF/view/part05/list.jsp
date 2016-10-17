<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="memInsert.htm">글쓰기</a>
<c:forEach items="${aList}" var="dto">
<p>${dto.num} / ${dto.name} / ${dto.age} / ${dto.loc}</p>
</c:forEach>

</body>
</html>