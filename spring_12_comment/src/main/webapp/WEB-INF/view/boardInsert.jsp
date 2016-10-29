<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<script type="text/javascript">
  $(document).ready(function(){
	 
	  $('#btnList').bind('click',function(){
		 history.back();
	  });
	  
	  $('#btnSave').bind('click',function(){
		  
		  $('#frm').attr('action','boardlist.do').submit();
	  });
	  
	   
  });
  
	function process() {
			$('[name=content]').val(
					$('[name=content]').val().replace(/\n/gi, '<br/>'));
			return true;
		}
</script>

</head>
<body>
	<form name="frm" id="frm" method="post"  onsubmit="return process()">
		<table>
			<tr>
				<td width="20%" align="center">제목</td>
				<td><input type="text" name="title" size="10" maxlength="10" /></td>
			</tr>

			<tr>
				<td width="20%" align="center">작성자</td>
				<td>				
				<input type="text" name="writer" size="40" /></td>
			</tr>
			<tr>
				<td width="20%" align="center">내용</td>
				<td><textarea name="content" rows="13" cols="40"></textarea></td>
			</tr>
		</table>
		<input type="button" id="btnSave" value="저장" />
		<input type="button" id="btnList" value="취소" />
	</form>
</body>
</html>
