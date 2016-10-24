$(document).ready(function(){
	$('#btn').on('click',process);
	
});

function process(){
	$.ajax({
		type:'GET', //기본이 겟방식이라 생략가능.   method
		dataType:'text',  //text로 받는거면 생략가능. 응답형식.   요즘에는 jSon 으로 받는다. http://jSon.org
		url:'customer.do?name='+$('#name').val(),
		success:function(res){			        //서버에서 응답이 올떄까지 기다리다 응답이 오면 함수를 실행. res(임의)는 응답값
			$('div').html(res);
		}   
	});
	
}//end process()