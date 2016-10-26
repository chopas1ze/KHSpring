<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#replyAddBtn').click(function(){
		alert("d");
		$.ajax({
			type:'GET',
			dataType:'json',
			url:'replyInsertList.do?bno=${boardDTO.bno}&replyer='+$("#newReplyWriter").val()+'&replytext='+$("#newReplyText").val(),
			success:viewMessage,
		});
		});
});

function viewMessage(data){
	$('ul').empty();
	$('ul').append('<li class="time-label" id="repliesDiv">');
	$('ul').append('<span class="bg-green">  Replies List <small id="replycntSmall"> [ ${fn:length(boardDTO.replyList)} ] </small></span></li>');

	$.each(data,function(index, value){
		$('ul').append('<li class="time_sub"  id="'+value.rno+'">');
		$('ul').append('<p>'+value.replyer+'</p>');
		$('ul').append('<p>'+value.replytext+'</p>');
		$('ul').append('<p>'+value.regdate+'</p>');
		$('ul').append('<p><a href="replyDelete.do?bno=${boardDTO.bno}&rno='+value.rno+'">delete</a></p></li>');
		
	});
	
};

	
</script>
</head>
<body>
	<div class="wrap">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> <input type="text"
					name='title' class="form-control" value="${boardDTO.title}"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="content" rows="3"
					readonly="readonly">${boardDTO.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label> <input type="text"
					name="writer" class="form-control" value="${boardDTO.writer}"
					readonly="readonly">
			</div>
		</div>
		
			  <div class="box-footer">
			    <button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
			    <button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
			    <button type="submit" class="btn btn-primary" id="goListBtn">GO LIST </button>
			  </div>
		<hr/>
		
		<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">ADD NEW REPLY</h3>
				</div>
				<div class="box-body">
					<label for="exampleInputEmail1">Writer</label> <input
						class="form-control" type="text" placeholder="USER ID"
						id="newReplyWriter"> <label for="exampleInputEmail1">Reply
						Text</label> <input class="form-control" type="text"
						placeholder="REPLY TEXT" id="newReplyText">
				</div>
				
				
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="button" class="btn btn-primary" id="replyAddBtn">ADD
						REPLY</button>
				</div>
			</div>


			<!-- The time line -->
			<ul class="timeline">
				<!-- timeline time label -->
				<li class="time-label" id="repliesDiv">
				<span class="bg-green">	  Replies List <small id='replycntSmall'> [ ${fn:length(boardDTO.replyList)} ] </small></span></li>
			
			  <c:forEach items="${boardDTO.replyList}" var="replyDTO">
			 	<li class="time_sub"  id="${replyDTO.rno}">
			 	 <p>${replyDTO.replyer}</p>
			 	  <p>${replyDTO.replytext }</p>
			 	  <p>${replyDTO.regdate}</p>
			 	  <p><a href="replyDelete.do?bno=${boardDTO.bno}&rno=${replyDTO.rno}">delete</a></p>
			 	 
			 	  
			 	</li>
			 	</c:forEach> 
			</ul>
			
			
			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">

				</ul>
			</div>
		
		
		
	</div>
</body>
</html>