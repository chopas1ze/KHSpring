<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.modifyShow {
	display: block;
	position: absolute;
	top: 150px;
	left: 200px;
	width: 400px;
	height: 180px;
	z-index: 1000;
	border: 1px solid black;
	background-color: yellow;
	text-align: center;
}

.modifyHide {
	visibility:hidden;
	width:0px; 
	height:0px;
}
</style>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- http://handlebarsjs.com/installation.html -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript">
var urno='';

$(document).ready(function() {
	//첫로딩 수정화면 숨김 
	$('#modifyModal').addClass('modifyHide');
	//첫로딩 보드수정화면 숨김
	$('#boardModifyModal').addClass('modifyHide');
	
	//보드수정화면 닫기
	$('#boardbtnClose').on('click',function(){
		$('#boardModifyModal').removeClass('modifyShow');
		$('#boardModifyModal').addClass('modifyHide');
		$('#updateBoardTitle').val('');
		$('#updateBoardContent').val('');
		$('#updateBoardWriter').val('');
	});
	
	//첫화면 Modify 클릭시
	$('#modifyBtn').on('click',function(){
		$('#boardModifyModal').removeClass('modifyHide');
		$('#boardModifyModal').addClass('modifyShow');
	});
	
	//보드수정화면 Modify 클릭시
	$('#boardbtnModify').on('click',board_update_send);
	
	
	//수정화면 닫기
	$('#btnClose').on('click',function(){
		$('#modifyModal').removeClass('modifyShow');
		$('#modifyModal').addClass('modifyHide');
		$('#filename2').val('');
		urno='';
	});
	
	//remove 버튼 클릭시
	$('#removeBtn').on('click',board_remove_send);
	
	//수정화면 modify 클릭시
	$('#btnModify').on('click',reply_update_send);
	
	//add reply	버튼 클릭시
	$('#replyAddBtn').on('click',reply_insert_send);
	
//delete, update 버튼 클릭시
$(document).on('click','.timeline button', reply_del_upt_btn);


});//$(document).ready end //////////////////////////


//Handlebars 설정
Handlebars.registerHelper("newDate", function(timeValue){
	var dateObj=new Date(timeValue);
	var year=dateObj.getFullYear();
	var month=dateObj.getMonth()+1;
	var date=dateObj.getDate();
	return year+"/"+month+"/"+date; 
	//return new Date(timeValue);
});

Handlebars.registerHelper("newUpload",function(rno, uploadFile){
	if(uploadFile!=null){
		var result = '<img src="images/save.gif"/><a href="contentdownload.do?rno=' + rno + '">' + uploadFile.substring(uploadFile.indexOf("_")+1) + '</a>';
		return new Handlebars.SafeString(result);
	}
	else
		return "첨부파일 없음";
	
});//end Handlebars


//공통 List 함수
function reply_list(data) {
	$('.timeline').empty();
	//앵간하면 한줄로 append하시오. 중간에 공백이 생겨버림 
	$('.timeline').append('<li class="time-label" id="repliesDiv"><span class="bg-green">  Replies List <small id="replycntSmall"> ['+ data.length +'] </small></span></li>');

	$.each(data, function(index, value) {
	/* 	$('ul').append('<li class="time_sub"  id="'+value.rno+'">');
		$('ul').append('<p>' + value.replyer + '</p>');
		$('ul').append('<p>' + value.replytext + '</p>');
		$('ul').append('<p>' + value.regdate + '</p>');
		$('ul').append('<p><button id="'+value.rno+'">delete</button><button id="'+value.rno+'">update</button></p></li>'); */
		
		/* handlebars.js(이런게있다정도로생각) 사용시 변수로 가져올값은 중괄호에 넣으면된다  */
		var source="<li class='time_sub' id='{{rno}}'> <p>{{replyer}}</p><p>{{replytext}}</p><p>{{newDate regdate}}</p><p>{{newUpload rno rupload}}</p><p><button id='{{rno}}'>delete</button><button id='{{rno}}'>update</button></p></li>";
		var template=Handlebars.compile(source);
		/* var date={rno:1 replyer:홍길동} 식으로 값이 넘어온다. JSON인 경우니까 */
		$('.timeline').append(template(value));
	});
	
};//end reply_list()//////////////


////////////////////////////////////////함수///////////////////////////////////////

//add reply 함수
function reply_insert_send(){
	var form_data=new FormData();
	form_data.append('bno','${boardDTO.bno}');
	form_data.append('replyer',$('#newReplyWriter').val());
	form_data.append('replytext',$('#newReplyText').val());
	//웹브라우저 콘솔창에서 확인
	console.log('filename',$('#filename')[0].files[0]);
	if($('#filename')[0].files[0]!=undefined){
		form_data.append('filename',$('#filename')[0].files[0]);			
	}

	$.ajax({
	type : 'POST',
	dataType : 'json',
	//contentType 이 true이면 applcation 방식이고 false이면 multipart-from-data방식이다.
	contentType: false,
	//encodingtype이 multipart/form-data 이면 contetntype,processData값을 false로 지정해야한다. 
	enctype:'multipart/form-data',
	processData: false,
	url : 'replyInsertList.do',
	data : form_data,
	success : reply_list,  
	});

	$('#newReplyWriter').val('');
	$('#newReplyText').val('');
	$('#filename').val('');
	
};//end reply_insert_send()/////////////

//delete,update버튼 함수
function reply_del_upt_btn(){
	
	if($(this).text()=='delete'){
		urno = $(this).prop('id');
		$.ajax({
			type : 'GET',
			dataType : 'json',
			url:'replyDelete.do?rno='+urno+'&bno=${boardDTO.bno}',
			success : reply_list,
		});
		
	}else if($(this).text()=='update'){
		urno = $(this).prop('id');
		$('#modifyModal').removeClass('modifyHide');
		$('#modifyModal').addClass('modifyShow');
	};
	
};//end reply_del_upt_btn()/////////


//수정화면 modify 클릭 함수
function reply_update_send(){
	
	var form_data=new FormData();
	form_data.append('bno','${boardDTO.bno}');
	form_data.append('rno',urno);
	form_data.append('replytext',$('#updateReplyText').val());
	console.log('filename',$('#filename2')[0].files[0]);
	if($('#filename2')[0].files[0]!=undefined){
		form_data.append('filename',$('#filename2')[0].files[0]);			
	};
	
	$.ajax({
		
		type : 'POST',
		dataType : 'json',
		contentType: false,
		enctype:'multipart/form-data',
		processData: false,
		url : 'replyUpdate.do',
	    data : form_data,
		success : reply_list,  	
		
	});
	
	$('#updateReplyText').val('');
	$('#modifyModal').removeClass('modifyShow');
	$('#modifyModal').addClass('modifyHide');
	$('#filename2').val('');
	urno='';
	
};// end reply_update_send()/////////////////////


//board remove 버튼 함수
function board_remove_send(){

	$.ajax({
		dataType:'text',
		type:'POST',
		url:'boardRemove.do',
		data:'bno=${boardDTO.bno}',
		success: function(res){
			location.href='boardlist.do';
		}
	});
	
};//end board_remove_send()/////////////


//보드 modify 버튼 함수
function board_update_send(){
	
	$.ajax({
		dataType:'json',
		type:'POST',
		url:'boardUpdate.do',
		data:'bno=${boardDTO.bno}&content='+$('#updateBoardTitle').val()+'&title='+$('#updateBoardContent').val()+'&writer='+$('#updateBoardWriter').val(),
		success:board_change,
	});
	
};//end board_update_send()///////////


//보드 modify request 함수
function board_change(res){
	$('.box-body').empty();
	var sos = '<div class="form-group"><label for="exampleInputEmail1">Title</label> <input type="text"name="title" class="form-control" value="{{title}}"readonly="readonly"></div><div class="form-group"><label for="exampleInputPassword1">Content</label><textarea class="form-control" name="content" rows="3" readonly="readonly">{{content}}</textarea></div><div class="form-group">	<label for="exampleInputEmail1">Writer</label> <input type="text" name="writer" class="form-control" value="{{writer}}" readonly="readonly"></div>';
	var temp=Handlebars.compile(sos);
	$('.box-body').append(temp(res));
	$('#boardModifyModal').addClass('modifyHide');
	
};//end board_change()///////


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
			<button type="submit" class="btn btn-danger" id="removeBtn" >REMOVE</button>
			<button type="submit" class="btn btn-primary" id="goListBtn" onclick="location.href='boardlist.do'">GO
				LIST</button>
		</div>
		<hr />

		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>
			<div class="box-body2">
				<label for="exampleInputEmail1">Writer</label> <input
					class="form-control" type="text" placeholder="USER ID"
					id="newReplyWriter"> <label for="exampleInputEmail1">Reply
					Text</label> <input class="form-control" type="text"
					placeholder="REPLY TEXT" id="newReplyText">
					<label for="filename">upload</label>
					<input type="file" id="filename" name="filename"/>
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
			<li class="time-label" id="repliesDiv"><span class="bg-green">
					Replies List <small id='replycntSmall'> [
						${fn:length(boardDTO.replyList)} ] </small>
			</span></li>

			<c:forEach items="${boardDTO.replyList}" var="replyDTO">
				<li class="time_sub" id="${replyDTO.rno}">
					<p>${replyDTO.replyer}</p>
					<p>${replyDTO.replytext}</p>
					<p><fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${replyDTO.regdate}"/></p>
					<c:choose>
					<c:when test="${replyDTO.rupload!=null}">
						<img src="images/save.gif" /><a href="contentdownload.do?rno=${replyDTO.rno}">${fn:substringAfter(replyDTO.rupload,"_")}</a>
					</c:when>
					<c:otherwise>
					<p>첨부파일 없음</p>
					</c:otherwise>
					</c:choose>
					<p>
						<button id="${replyDTO.rno}">delete</button>
						<button id="${replyDTO.rno}">update</button>
					</p>

				</li>
			</c:forEach>
		</ul>


		<div class='text-center'>
			<ul id="pagination" class="pagination pagination-sm no-margin ">

			</ul>
		</div>

				<!-- Modal -->
		<div id="modifyModal">
			<p>
				<label for="updateReplyText">Reply Text</label> <input
					class="form-control" type="text" placeholder="REPLY TEXT"
					id="updateReplyText"><br/><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="filename2">upload</label>
				<input type="file" id="filename2" name="filename2"/>
			</p>
			<p>			    
				<button id="btnModify">Modify</button>
				<button id="btnClose">Close</button>
			</p>
		</div>
		
		<!--  board Modal -->
		<div id="boardModifyModal">
			<p>
				<label for="updateBoardTitle">Title</label> <input
					class="form-control" type="text" placeholder="title"
					id="updateBoardTitle"/><br/>
				<label for="updateBoardContent">Content</label> 
				<textarea class="form-control" id="updateBoardContent" rows="3" placeholder="Content"></textarea><br/>
				<label for="updateBoardWriter">Writer</label> <input
					class="form-control" type="text" placeholder="Writer"
					id="updateBoardWriter"/>
			</p>
			<p>			    
				<button id="boardbtnModify">Modify</button>
				<button id="boardbtnClose">Close</button>
			</p>
		</div>
		

	</div>
</body>
</html>