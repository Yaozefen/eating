$(document).ready(function(){
	var date = new Date();
	var today = date.toLocaleDateString();
	$("#comingDate").val(today);
	$("#add").click(function(){
		if($("#username").val()==""||$("#name").val()==""||$("#password").val()==""||$("#comingDate").val()==""){
			return false;
		}
	});
})