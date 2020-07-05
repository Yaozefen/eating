<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>使用地址簿</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="container">
		<div id="header">
			<h2 class="h">从地址簿选择</h2>
			
		</div>
		<div id="center">
			<div id="up">
				<div id="left">
 				<form method="post" action="${pageContext.request.contextPath}/likesearch.action">
					<input type="text" id="searchvalue"  placeholder="请输入手机号进行查询" size="40" name="ad.keyword"/>
					<a href="${pageContext.request.contextPath}/likesearch.action">
					<input type="submit" id="search"  value="搜索">
					<!-- </a> -->
				</form>
					
				</div>
				<div id="right">
					<a href="${pageContext.request.contextPath}/jsp/index.jsp" target="_self"><button id="address" name="address">+&nbsp;新增地址</button></a>
				</div>
			</div>
			<!-- table -->
			<div id="down">
				<div id="alladdr">
					<table width="100%" border="1px" align="center" cellspacing="0" cellspadding="4" id="tablist"><!-- // -->
						<tr>
							<th scope="col" style="height:50px;">联系人</th>
							
							<th scope="col">详细地址</th>
							
							<th scope="col">手机号码</th>
							<th scope="col">操作</th>
							
						</tr>
	<tr  align="center" >
	<c:choose> 
		<c:when test="${!empty addrlist}">  <!-- 获取list对象 -->
			<c:forEach items="${addrlist}" var="get"> <!-- 循环遍历，items(循环对象)是list，保存到listmap -->
				<!-- <div id="row"> -->
				<td width="8%" align="center" style="height:50px;">${get.name}</td>	
				
				<td width="19%" align="center">${get.address}</td>
				<td width="9%" align="center" name="ad.cellphone">${get.cellphone}</td>
			
				<td width="6%" align="center"><a href="${pageContext.request.contextPath}/delete.action?ad.address=${get.address}">删除</a>&nbsp;<a href="${pageContext.request.contextPath}/modify.action?ad.cellphone=${get.cellphone}">修改</a></td>
				
				
 		
 					 
				</td><!-- </div> -->
	</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>  <!--当为空时  -->
			
			<tr align="center"><td colspan="8" style="color:red;font-size:30px;"><img alt="" src="${pageContext.request.contextPath}/img/null.PNG"></td></tr>
		</c:otherwise>
		</c:choose>
			
	</table>
				</div>
			</div>
		</div>
		</div>
	</body>
</html>
