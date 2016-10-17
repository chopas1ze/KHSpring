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

<form name="frm" action="mem.htm" method="post">
    <label for="fname">이름</label>
    <input type="text" name="name" id="fname" /><br/>
    <label for="fage">나이</label>
    <input type="text" name="age" id="fage"/>
    <input type="submit" value="send" />
  </form>

</body>
</html>