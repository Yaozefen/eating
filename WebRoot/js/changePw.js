var j = jQuery.noConflict();
j(document).ready(function(){
	j("#username").blur(function(){
		var phoneReg = /^1[3|4|5|8][0-9]\d{8}$/;			//手机号验证
		if((j(this).val())==""){
			j("#user_span").html("请输入手机号");
		}
		else if(!phoneReg.test(j(this).val())){
			j("#user_span").html("手机格式不正确");
		}
		else{
			j("#user_span").html("");
		}
	});
	j("#newPass").blur(function(){
		var newpass = j(this).val();
		if(newpass==""){
			j("#newPass_span").html("请输入密码");
		}
		else if((newpass.length<6)||(newpass.length>32)){
			j("#newPass_span").html("密码6-32个字符");
		}
		else if(j("#comPass").val()!=""&&newpass!=j("#comPass").val()){
			j("#comPass_span").html("两次密码输入不一致");
			j("#submit").attr("type","button");
		}
		else{
			j("#newPass_span").html("");
			j("#submit").attr("type","submit");
		}
	});
	j("#comPass").blur(function(){
		var compass = j(this).val();
		if(compass==""){
			j("#comPass_span").html("请再次输入密码");
		}
		else if(compass!=j("#newPass").val()){
			j("#comPass_span").html("两次密码输入不一致");
			j("#submit").attr("type","button");
		}
		else{
			j("#comPass_span").html("");
			j("#submit").attr("type","submit");
		}
		
	});
	j("#get_code").click(function(event){
		var seconds = 60;
		event.preventDefault();
		if(j("#username").val()!=""){
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
			j("#user_span").html("请输入手机号");
		}
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