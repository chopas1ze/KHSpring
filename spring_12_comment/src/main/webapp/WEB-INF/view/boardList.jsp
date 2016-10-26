<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
	<div id="wrap">
		<table>
			<tr>
				<th>BNO</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>REGDATE</th>
				<th>VIEWCNT</th>
			</tr>
			<c:forEach items="${list}" var="boardDTO">
				<tr>
					<td>${boardDTO.bno}</td>
					<td><a href="boardView.do?bno=${boardDTO.bno}">${boardDTO.title}</a></td>
					<td>${boardDTO.writer}</td>
					<td>${boardDTO.regdate}</td>
					<td>${boardDTO.viewcnt}</td>
				</tr>

			</c:forEach>


		</table>
	</div>
</body>
</html>