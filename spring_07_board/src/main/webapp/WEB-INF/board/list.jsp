<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="bodywrap">
		<!-- 리스트 출력 -->
		<table>
			<tr>
				<th width="5%">번호</th>
				<th width="45%">제목</th>
				<th width="20%">글쓴이</th>
				<th width="5%">조회수</th>
			</tr>
			<c:forEach items="${aList}" var="dto">
				<tr>
					<td width="5%" style="text-align: center">${dto.num}</td>
					<td width="45%" style="text-align: center"><c:if
							test="${dto.re_level!=0}">
							<img src="images/level.gif" width="${35*dto.re_level}"
								height="15" />
							<img src="images/re.gif" />
						</c:if> ${dto.subject}</td>
					<td width="20%" style="text-align: center">${dto.writer}</td>
					<td width="5%" style="text-align: center">${dto.readcount}</td>
				</tr>
			</c:forEach>
		</table>
		
		<!-- 이전  -->
		<c:if test="${pv.startPage>1}">
		<%-- <span><a href="list.sb?currentPage=${pv.startPage-pv.blockPage}">이전</a></span> --%>
		<c:url var="prePage" value="list.sb">
		<c:param name="currentPage" value="${pv.startPage-pv.blockPage}"/>
		</c:url>
		<a href="${prePage}"><c:out value="이전"/></a>
		</c:if>

		<!-- 페이지 출력 시작 -->
		<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
			<%-- <c:url var="currPage" value="list.sb">
			<c:param name="currentPage" value="${i}"/>
			</c:url>
			<a href="${currPage}"><c:out value="${i}"/></a> --%>
			<a href="list.sb?currentPage=${i}">${i}</a>
		</c:forEach>
		<!-- 페이지 출력 끝 -->
		<!-- 다음 -->
		<c:if test="${pv.totalPage>pv.endPage}">
			<%-- <span><a href="list.sb?currentPage=${pv.startPage+pv.blockPage}">다음</a></span> --%>
				 <c:url var="nextPage" value="list.sb">
			<c:param name="currentPage" value="${pv.startPage+pv.blockPage}"/>
			</c:url>
			<a href="${nextPage}"><c:out value="다음"/></a>
		</c:if>
	</div>
</body>
</html>