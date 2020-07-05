<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>收货地址信息确认展示</title>
</head>
<body>
<h2>您的收货信息接受成功！</h2>
<a href="/address/search.action">点击查看</a>
<%-- <c:choose>
	<c:when test="${!empty addrlist }">
		<c:forEach items="${addrlist }" var="addrmsg">
<table width="98%" border="1px" align="center" cellspacing="0" cellspadding="4" id="table2">
						<tr>
							<th scope="col" style="height:50px;">联系人</th>
							<th scope="col">固定电话</th>
							<th scope="col">地址</th>
							<th scope="col">联系电话</th>
							<th scope="col">省市区</th>
							<th scope="col">操作</th>
						</tr>
						<tr>
							<th scope="col" style="height:50px;">${addrmsg.name}</th>
							<th scope="col">${addrmsg.absolutephone }</th>
							<th scope="col">${addrmsg.address }</th>
							<th scope="col">${addrmsg.cellphone }</th>
							<th scope="col">${addrmsg.province }</th>
							<th scope="col">删除</th>
						</tr>
</table>
</c:forEach>
</c:when>
</c:choose> --%>

<tr></tr>
</table>
</body>
</html>