<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login.action">
	账户:<input type="text" name="user.username" ><br>
	密码:<input type="password" name="user.userpass" >
	<input type="submit" value="登录">
</form>
</body>
</html>