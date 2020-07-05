var j = jQuery.noConflict();
j(document).ready(function(){
	j("li#li_user").addClass("color_change").children("a").addClass("color_change");
	j(".li").click(function(){
		j(this).children("a").addClass("color_change");
		j(this).siblings("li").children("a").removeClass("color_change");
		j(this).addClass("color_change");
		j(this).siblings("li").removeClass("color_change");
	});
	j("li#li_user").click(function(){
		j("form#signIn_form_second").hide();
		j("form#uform").show();
	});
	j("li#li_phone").click(function(){
		j("form#uform").hide();
		j("form#signIn_form_second").show();
	});
	j("#user").blur(function(){
		if((j(this).val())==""){
			j("#user_span").html("账号不能为空");
		}
		else{
			j("#user_span").html("");
		}
	})
	j("#pass").blur(function(){
		if((j(this).val())==""){
			j("#pass_span").html("密码不能为空");
		}
		else{
			j("#pass_span").html("");
		}
	});
	j("#phone").blur(function(){
		var phoneReg = /^1[3|4|5|8][0-9]\d{8}/;			//手机号验证
		if((j(this).val())==""){
			j("#phone_span").html("请输入手机号");
		}
		else if(!phoneReg.test(j(this).val())){
			j("#phone_span").html("手机格式不正确");
		}
		else{
			j("#phone_span").html("");
		}
	})
	j("#get_code").click(function(event){
		var seconds = 60;
		event.preventDefault();
		if(j("#phone").val()!=""){
			j("#code").val("123456");
			window.setInterval(function(){
				seconds = seconds - 1;
				if(seconds > 0){
					j("#get_code").text(seconds+"秒后重新获取");
				}
				else{
					j("#get_code").text("获取验证码");
				}
			},1000);
		}
		else{
			j("#phone_span").html("请输入手机号");
		}
	});
	j("#btn").dblclick(function(){
		iosAlert();
	});
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

//ajax函数,异步检查用户存在
function validate(){
	var url = "json/lAjax.action";
	var params = $("uform").serialize("username");		//序列化form表单中的ID username
	var myAjax = new Ajax.Request(url,{
		method: "post",
		parameters: params,
		onComplete: processResponse,
		asynchronous: true
	});
}
function processResponse(request){
	var obj = JSON.parse(request.responseText);
	j("#user_span").html(obj.tip);
}