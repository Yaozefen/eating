<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri = "/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" >

    <head>

        <meta charset="utf-8" />

        <title>上传图片实例</title>

        

    </head>

    <body>
    <h2>上传图片示例</h2>
    	<s:form action = "upload.action" enctype="multipart/form-data" namespace="/">
    		<s:textfield name = "title" label="文件标题" size = "30"></s:textfield>
    		<s:file name = "upload" label="选择文件" size = "30" />
    		<s:submit value = "上传"></s:submit>
    	</s:form>
    </body>

</html>
