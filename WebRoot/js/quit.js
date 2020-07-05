var j = jQuery.noConflict();
j(document).ready(function(){
	
});

//弹框函数
function iosAlert(){
	var json = {
			title:"错误信息",
			msg:j("#hidden").val(),
			buttons:[
				{ title:"back",color:"red",click:function(){} },
			]
		}
	
        j.alertView(json);
}

//ajax函数,异步检查用户存在
function validate(){
	var url = "json/eAjax.action";
	var params = $("quitform").serialize("content");		//序列化form表单中的
	var myAjax = new Ajax.Request(url,{
		method: "post",
		parameters: params,
		onComplete: processResponse,
		asynchronous: true
	});
}
function processResponse(request){
	var dish = JSON.parse(request.responseType);
}