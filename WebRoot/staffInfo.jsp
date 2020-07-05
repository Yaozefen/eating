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
		<title>果然好吃-员工信息</title>
		<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel = "stylesheet" href="css/bossMain.css" />
		<link rel="stylesheet" href="css/staffInfo.css" />
		<script type="text/javascript" src="js/bossMain.js" ></script>
		<script type="text/javascript" src="js/staffInfo.js" ></script>
	</head>
	<body>
		<div class = "container">
			<header class = "main_head row">
				<section class = "head_section">
					<div id = "logo" class = "col-lg-3">
						<img src = "img/littleLogo.jpg" alt = "logo">
					</div>
					<ul class = "nav nav-pills col-lg-4" id = "head_ul">
						<li><a href="bossMain.html">首页</a></li>
						<li><a href="#">我的店铺</a></li>
						<li><a href="#">客户服务</a></li>
						<li><a href="#">常见问题</a></li>
					</ul>
					<p id = "head_p" class = "col-lg-3 col-lg-offset-2">当前用户：<span><s:property value = "#session.user.username"/></span>(<span><s:property value = "#session.user.role"/></span>)&nbsp;&nbsp;|&nbsp;&nbsp;<a href = "${pageContext.request.contextPath }/noLogin.action">安全退出</a></p>
				</section>
			</header>
			<div id = "bread" class = "row">
				<ul class = "breadcrumb col-lg-10 col-lg-offset-1" style = "margin-top:1rem;">
					当前位置：
					<li><a href = "${pageContext.request.contextPath }/AllOrder.action">home</a></li>
					<li>信息管理</li>
					<li class = "active"><a href = "${pageContext.request.contextPath }/queryEmp.action">员工信息</a></li>
				</ul>
			</div>
			<article id = "main_article" >
					<nav id = "main_nav" >
						
						<ul class = "boss_first_nav">
					
							<img src= "img/show.jpg"> 
							<li>
								&nbsp;订&nbsp;单&nbsp;管&nbsp;理
								<ul class = "boss_second_nav">
									<li class = "active"><a href="${pageContext.request.contextPath }/AllOrder.action">订单中心</a></li>
								</ul>
							</li>
							<img src= "img/show.jpg"> 
							<li>
								&nbsp;菜&nbsp;品&nbsp;信&nbsp;息
								<ul class = "boss_second_nav">
									<li><a href="${pageContext.request.contextPath }/upperShelf.jsp">上架菜品</a></li>
									<li><a href="${pageContext.request.contextPath }/lowerShelf.jsp">下架菜品</a></li>
								</ul>	
							</li>
							<img src= "img/show.jpg"> 
							<li>
								&nbsp;信&nbsp;息&nbsp;管&nbsp;理
								<ul class = "boss_second_nav">
									<li><a href="${pageContext.request.contextPath }/queryEmp.action">员工信息</a></li>
									<li><a href="${pageContext.request.contextPath }/findNum.action">入职管理</a></li>
									<li><a href="${pageContext.request.contextPath }/quit.jsp">离职管理</a></li>
								</ul>
							</li>
							
							<img src= "img/show.jpg"> 
							<li>
								&nbsp;运&nbsp;营&nbsp;状&nbsp;况
								<ul class = "boss_second_nav">
									<li><a href="${pageContext.request.contextPath }/queryTurn.action">十日营业额</a></li>
									<li><a href="${pageContext.request.contextPath}/fsearch.action">生意经社区</a></li>
								</ul>
							</li>
						</ul>	
					</nav>
					
					<!--aside部分-->
					<aside id = "main_aside">
					<div class = "row">
						<s:iterator var = "list" value = "employeeList">
								<div class = "col-lg-3">
									<div class = "img">
										<img src = "img/employeeImg/<s:property value = "#list.employeeImg"/>">
									</div>
									<p>账号：<s:property value = "#list.username"/></p>
									<p>姓名：<s:property value = "#list.name"/></p>
									<p>性别：<s:property value = "#list.sex"/></p>
									<p>入职时间：<s:property value = "#list.comingDate"/></p>
								</div>
							
						</s:iterator>
					
						</div>
					</aside>
			</article>
			<footer class = "main_footer">
				<div class = "row col-lg-4 col-lg-offset-4">
					<ul class = "list-group list-inline" id = "footer_ul">
						<li class = "list-group-item"><a href = "#">法律声明</a></li>
						<li class = "list-group-item"><a href = "#">隐私政策声明</a></li>
						<li class = "list-group-item"><a href = "#">可接受的使用政策</a></li>
						<li class = "list-group-item"><a href = "#">用户协议</a></li>
						<li class = "list-group-item"><a href = "#">举报不良信息</a></li>
						<li class = "list-group-item"><a href = "#">欢迎监督</a></li>
					</ul>
				</div>
				<hr/>
				<p class = "text-center">所有方：广州魔斯拉信息科技有限公司|<a href = "#">营业执照</a></p>
				<p class = "text-center">Copyright © 2013-2018 guoranhaochi.com All Rights Reserved. 广ICP备110120119号 广公网安备1101201589</p>
			</footer>
		</div>
	</body>
</html>
