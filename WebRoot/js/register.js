var j = jQuery.noConflict();
j(document).ready(function(){
	j("#username").blur(function(){
		var phoneReg = /^1[3|4|5|8][0-9]\d{8}$/;			//手机号验证
		if((j(this).val())==""){
			j("#phone_span").html("请输入手机号");
			j("#submit").attr("type","button");
		}
		else if(!phoneReg.test(j(this).val())){
			j("#phone_span").html("手机格式不正确");
			j("#submit").attr("type","button");
		}
		else{
			j("#phone_span").html("");
			j("#submit").attr("type","submit");
		}
	});
	
	j("#password").blur(function(){
		var pass = j(this).val();
		if(pass==""){
			j("#pass_span").html("请输入密码");
		}
		else if((pass.length<6)||(pass.length>32)){
			j("#pass_span").html("密码6-32个字符");
		}
		else{
			j("#pass_span").html("");
		}
	});
	j("#password").change(function(){
		var pass = j(this).val();
		var degree_reg1 = /^\d+$/;
		var degree_reg2 = /^\w+$/;
		var degree_reg3 = /^\w+(\!|\@)+$/;
		if(degree_reg1.test(pass)){
			j("li.pass_degree:first").css("background-color","orange").siblings("li").css("background-color","gainsboro");
		}
		else if(degree_reg2.test(pass)){
			
			j("li.pass_degree:last").css("background-color","gainsboro").siblings("li").css("background-color","orange");
		}
		else if(degree_reg3.test(pass)){
			j("li.pass_degree").css("background-color","orange");
		}
	})
	return true;
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

//ajax函数,异步检查用户名是否已注册
function validate(){
	var url = "json/rAjax.action";
	var params = $("form").serialize("username");		//序列化form表单中的ID username
	var myAjax = new Ajax.Request(url,{
		method: "post",
		parameters: params,
		onComplete: processResponse,
		asynchronous: true
	});
}
function processResponse(request){
	var obj = JSON.parse(request.responseText);
	j("#phone_span").html(obj.tip);
}
