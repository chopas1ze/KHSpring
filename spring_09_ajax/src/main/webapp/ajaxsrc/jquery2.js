$(document).ready(function(){
	$('#btn').on('click',process);
	
});

function process(){
	$.ajax({
		dataType:'text',
		type:'POST',
		url:'loginPro.do',
		data:"id="+$('#id').val()+"&pass="+$('#pass').val(),
		success:function(res){
			$('div').html(res);
		}
		
	});
	
}//end process()