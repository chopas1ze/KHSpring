<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
<table>
<tr><td>title</td><td>image</td><td>author</td><td>sale_price</td></tr>
<x:parse xml="${total}" var="doc"/>
<x:forEach select="$doc/channel/item">
<tr>						
<td><a href="<x:out select='./link'/>"><x:out select="./title"/></a></td>	<!-- 아이템 요소의 하위요소 -->
<td><img src="<x:out select='./cover_l_url'/>"/></td>
<td><x:out select="./author"/></td>
<td><x:out select="./sale_price"/></td>
</tr>

</x:forEach>

</table>

</body>
</html>