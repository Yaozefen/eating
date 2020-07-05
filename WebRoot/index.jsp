<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri = "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<% session.invalidate(); %>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>果然好吃-在线点餐</title>
		<link rel="stylesheet" href="css/index.css" />
		<link type="text/css" rel="stylesheet" href="css/uiAlertView-1.0.0.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src = "js/JSON2.js"></script>
		<script type="text/javascript" src = "js/prototype.js"></script>
		<script type="text/javascript" src="js/index.js" ></script>
        <script type="text/javascript" src="js/jquery.uiAlertView-1.0.0.js"></script>
	</head>
	<body 
		<s:if test="#request.message!=null">
			onload = "iosAlert()"
		</s:if>
	>		<!-- 用隐藏域来获得页面的错误信息，调用弹框插件显示错误信息 -->
		<img src = "img/whiteBack.jpg" alt = "logo图片" id = "logoImg">
		<div class = "signIn_div">
			<section class = "signIn_section">
				<div id = "contain">
					<div id = "choose_div">
						<ul class = "signIn_ul">
							<li class = "li" id = "li_user"><a>登录</a></li>
							<li class = "li" id = "li_phone"><a>手机动态码登录</a></li>
						</ul>
					</div>
					<form action = "${pageContext.request.contextPath }/login.action" method = "post" id = "uform" name = "uform">
						<div class = "input_div">
							<input type = "text" id = "username" name = "user.username" autocomplete="on" placeholder="手机 / 用户名 / 邮箱" onblur = "validate()">
							<span id = "user_span"></span>
						</div>
						<div class = "input_div">
							<input type = "password" id = "passname" name = "user.password" placeholder="输入6~16位密码">
							<span id = "pass_span"></span>
						</div>
						<label class = "sign_p" for = "role">
							<input type = "radio" name = "user.role" value = "user" checked="checked">会员
							<input type = "radio" name = "user.role" value = "employee">店员
							<input type = "radio" name = "user.role" value = "employer">店主
						</label>
						<p class = "sign_p">
							<input type = "checkbox">7日内免登录
							<a href = "changePw.jsp">忘记密码</a>
						</p>
						<input type = "submit" id = "btn" value = "登录">
						<!-- 隐藏域 -->
						<input id = "hidden" type="hidden" value="<s:property value = '#request.message'/>" />
					</form>
					<form action = "main.jsp" method = "post" id = "signIn_form_second">
						<div class = "input_div">
							<input type = "text" id = "phone" placeholder="请输入手机号">
							<span id = "phone_span"></span>
						</div>
						<div class = "input_div">
							<input type = "text" id = "code" placeholder="动态码">
							<button id ="get_code">获取验证码</button>
						</div>
						<input type = "submit" value = "登录" id = "btn">
					</form>
				</div>
			</section>
                      <!--
                      	作者：offline
                      	时间：2019-05-03
                      	描述：section结束，及左边登录框制作完成
                      -->
            <aside class = "coop_aside">
            	<div id = "coop_div">
            		<p>没有账号?<a href = "register.jsp">免费注册</a></p>
            		<p>—————&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;合作登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;—————</p>
            		<a href = "https://im.qq.com"><img src = "img/coorpretaSignIn/qq.jpg" alt = "qq.jpg"></a>
            		<a href = "https://open.weibo.com"><img src = "img/coorpretaSignIn/weibo.jpg" alt = "weoboi.jpg"></a>
            		<a href = "https://wx.qq.com"><img src = "img/coorpretaSignIn/wechat.jpg" alt = "wechat.jpg"></a>
            		<a href = "https://e.189.cn"><img src = "img/coorpretaSignIn/e.jpg" alt = "e.jpg"></a>
            	</div>
            </aside>
                    <!--
                    	作者：offline
                    	时间：2019-05-03
                    	描述：合作单位登录模块
                    -->
		</div>
	</body>
</html>
