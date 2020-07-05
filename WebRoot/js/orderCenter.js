$(document).ready(function(){
	var state = $("#hidden").val();
	if(state=="待付款"){
		$("#li_nopay").children("a").addClass("color_change");
		$("#li_nopay").siblings("li").children("a").removeClass("color_change");
		$("#li_nopay").addClass("color_change");
		$("#li_nopay").siblings("li").removeClass("color_change");
	}
	else if(state=="待完成"){
		$("#li_yespay").children("a").addClass("color_change");
		$("#li_yespay").siblings("li").children("a").removeClass("color_change");
		$("#li_yespay").addClass("color_change");
		$("#li_yespay").siblings("li").removeClass("color_change");
	}
	else if(state=="已完成"){
		$("#li_finish").children("a").addClass("color_change");
		$("#li_finish").siblings("li").children("a").removeClass("color_change");
		$("#li_finish").addClass("color_change");
		$("#li_finish").siblings("li").removeClass("color_change");
	}
	else{
		$("#li_all").children("a").addClass("color_change");
		$("#li_all").siblings("li").children("a").removeClass("color_change");
		$("#li_all").addClass("color_change");
		$("#li_all").siblings("li").removeClass("color_change");
	}
	
	
	$(".deleteA").click(function(event){
		var com = window.confirm("确定删除该订单么？");
		if(!com&&event.preventDefault){
			event.preventDefault();
		}
		else if(!com&&!event.preventDefault){
			window.event.returnValue == false;
		}
		
	});
	return true;
	
});