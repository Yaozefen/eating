<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri = "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>果然好吃-用户注册</title>
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/register.css" />
		<link type="text/css" rel="stylesheet" href="css/uiAlertView-1.0.0.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src = "js/JSON2.js"></script>
		<script type="text/javascript" src = "js/prototype.js"></script>
		<script type="text/javascript" src="js/register.js" ></script>
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
						新用户注册
					</div>
					<form action = "${pageContext.request.contextPath }/register.action" method = "post" name = "form" id = "form">
						<div class = "input_div">
							<input type = "text" id = "username" name = "user.username" autocomplete="on" autofocus="autofocus" placeholder="请输入手机号" onchange = "validate()">
							<span id = "phone_span"></span>
						</div>
						<div class = "input_div">
							<input type = "text" id = "password" name = "user.password" placeholder="输入6~16位密码">
							<span id = "pass_span"></span>
							<ul class = "pass_ul">
								<li class = "pass_degree">弱</li>
								<li class = "pass_degree">中</li>
								<li class = "pass_degree">强</li>
							</ul>
						</div>
						<p class = "sign_p">
							<input type = "checkbox" checked="checked">同意
							<a href = "www.baidu.com">果然好吃用户协议</a>
						</p>
						<input type = "submit" value = "注册" id = "submit">
						<!-- 隐藏域 -->
						<input id = "hidden" type="hidden" value="<s:property value = '#request.message'/>" />
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
            		<p>已有账号?<a href = "index.jsp">立即登录</a></p>
            		<p>—————&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;合作登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;—————</p>
            
            		<img src = "img/coorpretaSignIn/qq.jpg" alt = "qq.jpg">
            		<img src = "img/coorpretaSignIn/weibo.jpg" alt = "weoboi.jpg">
            		<img src = "img/coorpretaSignIn/wechat.jpg" alt = "wechat.jpg">
            		<img src = "img/coorpretaSignIn/e.jpg" alt = "e.jpg">
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

