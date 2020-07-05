<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri = "/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/dish.css">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/dish.js"></script>
		<script>
			$(document).ready(function(){
				var sum = 0;
				var r = document.getElementsByClassName("value");
				for(var i = 0;i<r.length;i++){
					sum = sum + parseFloat($(".value").eq(i).val());
				}
				$("#sum").val(sum);
			})
			
		</script>
		<div id="header">
			<div class="menu">
				<div class="header-logo"><img src="img/littleLogo.jpg" height="58px"></div>
				<a href="${pageContext.request.contextPath}/queryfood.action?food.type=美味快餐" class="item" style="color: #FFFFFF;text-decoration: none;">首页</a>
				<a href="#" class="item"style="color: #FFFFFF;text-decoration: none;">我的订单</a>
				<a href="#" class="item"style="color: #FFFFFF;text-decoration: none;">加盟合作</a>
				<a href="#" class="item"style="color: #FFFFFF;text-decoration: none;">客服中心</a>
				<div class="nav-link">
					<a href="#" class="link1" style="color: #FFFFFF;text-decoration: none;">规则中心</a>
					<a href="#" class="link2" style="color: #FFFFFF;text-decoration: none;" ><img src="img/icon2.png" class="img2">手机应用</a>
				</div>
				<div class="l-and-r">
					<span><img src="img/icon.png" class="img"/></span>
				<!--	<a href="#" style="color: #FFFFFF;text-decoration: none;">登陆</a>/<a href="#" style="color: #FFFFFF;text-decoration: none;">注册</a>-->
					<s:property value = "#session.user.username"/>
					<ul class="nav nav-pills" style="float:right;">
						<li role="presentation" class="dropdown">
						<a class="dropdown-toggle" style="height:5rem;width:3.5rem; padding-top:0rem;" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"  aria-expanded="false" >
						  <span class="caret"></span>
						 </a>
						 <ul class="dropdown-menu">
							<li><a href="queryuser.action?id=<s:property value = "#session.user.username"/>" >个人中心</a></li>
							<li><a href="1.html">订单管理</a></li>
							<li><a href="2.html">收货地址</a></li>
							<li><a href="3.html">评价管理</a></li>
							<li><a href="${pageContext.request.contextPath }/noLogin.action">安全退出</a></li>
						 </ul>   
					</ul>
				</div>
			</div>
		</div>
