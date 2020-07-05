<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="s" uri = "/struts-tags" %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>果然好吃-订单中心</title>
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel = "stylesheet" href="css/bossMain.css"/>
		<link rel="stylesheet" href="css/OrderCenter.css"/>
		<script type="text/javascript" src="js/bossMain.js"></script>
		<script type="text/javascript" src="js/orderCenter.js"></script>
	</head>
	<!--通过数据库查询未完成，已完成，待付款订单 -->
		<!--Driver -->
		<sql:setDataSource
    	driver="com.mysql.jdbc.Driver"       
    	url = "jdbc:mysql://localhost:3306/eating" 
    	user="root" password="root" var="dataSource" scope="session"/>
		<sql:query var="query1" sql = "select * from orders where state = '待付款'" dataSource="${dataSource }"></sql:query>
		<sql:query var="query2" sql = "select * from orders where state = '待完成'" dataSource="${dataSource }"></sql:query>
		<sql:query var="query3" sql = "select * from orders where state = '已完成'" dataSource="${dataSource }"></sql:query>
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
					<li>订单管理</li>
					<li class = "active"><a href = "${pageContext.request.contextPath }/AllOrder.action">订单中心</a></li>
					<s:property value = "message"/>
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
						
						<div id = "choose_div">
							<ul id = "signIn_ul">
								<li class = "li" id = "li_all"><a href = "${pageContext.request.contextPath }/AllOrder.action">所有订单</a></li>
								<li class = "li" id = "li_nopay"><a href = "${pageContext.request.contextPath }/partOrder.action?content=待付款">待付款<span class="badge">${query1.rowCount }</span></a></li>
								<li class = "li" id = "li_yespay"><a href = "${pageContext.request.contextPath }/partOrder.action?content=待完成">待完成<span class="badge">${query2.rowCount }</span></a></li>
								<li class = "li" id = "li_finish"><a href = "${pageContext.request.contextPath }/partOrder.action?content=已完成">已完成<span class="badge">${query3.rowCount }</span></a></li>
							</ul>
							<!-- 隐藏域 -->
							<input type = "hidden" value = "<s:property value = 'content'/>" id = "hidden"/>
						</div>
						<form action = "${pageContext.request.contextPath }/oSearch.action" method = "post" class = "form-horizontal" role = "form" id = "form">
							<div class = "form-group">
								<div class="row">
									<div class = "col-lg-5">
										<input class = "form-control" id = "content" name = "content" placeholder="输入订单号进行搜索" >
									</div>
									<input type = "submit" class = "col-lg-2 btn btn-danger" value = "订单搜索">
								</div>
							</div>
						</form>
						<br />
						<table class = "table table-striped table-bordered text-center table-hover">  
				
						<!--.table-bordered圆角表格  .striped隔行  table-hover悬停灰色背景-->
						<!--响应式表格中每个表格项固定，太小会出现滚动条-->
							<thead>
								<tr>
									<th class = "text-center">具体描述</th>
									<th class = "text-center">下单时间</th>
									<th class = "text-center">总价</th>
									
									<th class = "text-center">配送方式</th>
									<th class = "text-center">交易状态</th>
								</tr>
								<tr>
									<th colspan="6" class = "text-left"><input type = "checkbox" id = "allSelect" value = "全选">全选</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator var="map" value = "orderMap">
									<tr>
										<td colspan="5" class = "text-left">
											<input type = "checkbox"><b></b>
											<span>订单号：<b><s:property value = "#map.key"/></b></span>
											<a class = "deleteA" href = "${pageContext.request.contextPath }/deleteOrder.action?orders.orderNum=<s:property value = '#map.key'/>"><img src = "img/delete.png" alt = "delete.png" width = "20" height = "20" class = "pull-right" style = "margin-right:7%;"></a>
										</td>
									</tr>
									<s:iterator var = "list" value = "#map.value">
										<tr>
											<td><s:property value = "#list.dishName"/></td>
											<td><s:property value = "#list.orderTime"/></td>
											<td><s:property value = "#list.price"/></td>
											<td><s:property value = "#list.way"/></td>
											<td><s:property value = "#list.state"/></td>
										</tr>
									</s:iterator>
								</s:iterator>
								
							</tbody>
						</table>
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

