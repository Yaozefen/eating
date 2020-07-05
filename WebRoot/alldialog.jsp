<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>生意论坛</title>
        <link href="${pageContext.request.contextPath}/css/dialog.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){
        	$("tr:odd").css("background-color","#B0C4DE");
        })
        </script>
    </head>
    <body>
    	<div id="container">
    		<div id="header">
    			<h2 style="width: 40%;padding-left: 2%;" >生意社区</h2>
    			<%-- <div id="a"><a href="#" class="button">刷新</a>
    				<a href="${pageContext.request.contextPath}/jsp/add.jsp" class="button">发帖</a>
    			</div> --%>
    		</div>
    		<center>
    	
    			<table width="80%" height="auto" align="center" cellspacing="0" cellspadding="2" id="tablist">
    				<tr style="font-size:25px;"><th>标题</th><th>作者</th><th>点击</th><th>时间</th></tr>
    	<c:choose> 
		<c:when test="${!empty flist}">  <!-- 获取list对象 -->
			<c:forEach items="${flist}" var="get"> <!-- 循环遍历，items(循环对象)是list，保存到listmap -->
    			<tr  align="center" >
				<td width="45%" align="center" style="height:50px;"><a href="${pageContext.request.contextPath}/fshow.action?f.headline=${get.headline}" target="_self">${get.headline}</a></td>	
				
				<td width="18%" align="center">${get.username}</td>
				<td width="3" align="center" >${get.count}</td>
			
				<td width="18%" align="center">${get.time}</td>
				
				
 		
 					 
				</td><!-- </div> -->
	</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>  <!--当为空时  -->
			
			<tr align="center"><td colspan="8" style="color:red;font-size:30px;">空空如也，快去发表帖子吧！</td></tr>
		</c:otherwise>
		</c:choose>
    			</table>
    			
    		</center>
    	</div>
 	</body>
</html>