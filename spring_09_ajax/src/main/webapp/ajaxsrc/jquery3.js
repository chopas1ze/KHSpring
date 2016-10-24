$(document).ready(function(){
	$('#btn').click(function(){
		$.ajax({
			type:'GET',
			dataType:'json',
			url:'process.do?data='+$('#data').val(),
			success:viewMessage
		});
		
	});
	
});


function viewMessage(data){
	
	//본인제외하고 자식요소 삭제
	/*$('#wrap').empty();*/
	
	//자신 삭제
	$('#wrap').children().remove();
	
	$('#wrap').append('<table><tr><td>first_name</td><td>email</td><td>hire_date</td><td>salary</td></tr></table>');
	$.each(data,function(index, value){
		$('#wrap table').append('<tr><td>'+value.first_name
										  +'</td><td>'+value.email
										  +'</td><td>'+value.hire_date
										  +'</td><td>'+value.salary+'</td></tr>');
	});
	
	$('#data').val('');
	$('#data').focus();
}//end viewMessage()