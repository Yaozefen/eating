$(document).ready(function(){
	$("#main_nav img").bind("click",function(){
		if($(this).attr("src")=="img/show.jpg"){
			$(this).prop("src","img/hide.jpeg");
			$(this).next("li").children("ul").children("li").hide();
		}
		else{
			$(this).prop("src","img/show.jpg");
			$(this).next("li").children("ul").children("li").show();
		}
	});
	var bgcolor = $(".boss_second_nav>li").css("background-color");
	$(".boss_second_nav>li").hover(function(){
		$(this).css("background-color","white");
	},function(){
		$(this).css("background-color",bgcolor);
	});
	return true;
});