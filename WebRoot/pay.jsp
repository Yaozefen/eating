<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>支付页面</title>
		
		<link rel="stylesheet" href="css/pay.css" />
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/pay.js" ></script>
	</head>
	<body onload="remainingTime()">
		<section class = "payContainer">
			<p>收银台</p>
			<p>订单提交成功，请尽快付款！取餐号:<span></span></p>
			<p>请您在30分钟内完成支付，否则订单会被自动取消</p>
			<p>剩余时间&nbsp;&nbsp;&nbsp;<span id = "time"></span></p>
			<br/>
			<div class = "payDiv">
				<p>
				<input type = "button" class = "wechatpay" value = "微信支付">
				</p>
				<p>
					<input type = "button" class = "alipay" value = "支付宝支付">
				</p>
				<p>
					<input type = "button" class = "unionpay" value = "银联支付">
				</p>
			</div>
		</section>
		
	</body>
</html>