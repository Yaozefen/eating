$(document).ready(function(){
	$("#add").click(function(){
		if($("#dishName").val()==""||$("#type").val()==""||$("#price").val()==""){
			return false;
		}
	});
})