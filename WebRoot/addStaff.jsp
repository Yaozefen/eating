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
		<title>果然好吃-入职管理</title>
		<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel = "stylesheet" href="css/bossMain.css" />
		<script type="text/javascript" src="js/bossMain.js" ></script>
		<script type="text/javascript" src="js/addStaff.js" ></script>
	</head>
	<body>
		<div class = "container">
			<header class = "main_head row">
				<section class = "head_section">
					<div id = "logo" class = "col-lg-3">
						<img src = "img/littleLogo.jpg" alt = "logo">
					</div>
					<ul class = "nav nav-pills col-lg-4" id = "head_ul">
						<li><a href="#">首页</a></li>
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
					<li class = "active"><a href = "${pageContext.request.contextPath }/findNum.action">入职管理</a></li>
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
					<aside id = "main_aside">
						<h2 class = "col-lg-12 text-center">入职管理</h2>
						<br/>
						<s:form action = "addStaff.action" namespace="/" enctype="multipart/form-data" class = "form-horizontal" role = "form">
							<div class = "form-group">
								<br />
								<div class="row">
									<label for = "employee.username" class = "control-label col-lg-4 text-right">账号</label>
									<div class = "col-lg-5">
										<input class = "form-control" name = "employee.username" id = "username" value = "<s:property value = '#request.number'/>" />
									</div>
								</div>
								<br />
					
								<div class="row">
									<label for = "employee.name" class = "control-label col-lg-4 text-right">姓名</label>
									<div class = "col-lg-5">
										<input class = "form-control" placeholder="请输入姓名" name = "employee.name" id = "name">
									</div>
								</div>
								<br />
								<div class="row">
									<label for = "employee.sex" class = "control-label col-lg-4 text-right">性别</label>
									<div class = "col-lg-5">
										<label class = "radio-inline">
											<input type = "radio" name = "employee.sex" id = "option1" value = "男" checked="checked">男
										</label>
										<label class = "radio-inline">
											<input type = "radio" name = "employee.sex" id = "option2" value = "女">女
										</label>
									</div>
								</div>
								<br />
								<div class="row">
									<label for = "employee.password" class = "control-label col-lg-4 text-right">初始密码</label>
									<div class = "col-lg-5">
										<input class = "form-control" placeholder="请输入初始密码" name = "employee.password" id = "password" value = "123456">
									</div>
								</div>
								<br />
								<div class="row">
									<label for = "employee.comingDate" class = "control-label col-lg-4 text-right">入职时间</label>
									<div class = "col-lg-5">
									<input class = "form-control" placeholder="请输入入职时间" name = "employee.comingDate" id = "comingDate">
									</div>
								</div>
								<br/>
								<div class = "row">
									<label for = "employee.employeeImg" class = "control-label col-lg-4 text-right">员工照片</label>
									<div class = "col-lg-5">
									<s:file name = "upload" size = "30" id = "employeeImg"></s:file>
									</div>
								</div>
								<br />
								<input type = "submit" id = "add" class = "btn btn-info col-lg-2 col-lg-offset-5" value = "添加" >
							</div>
						</s:form>
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