<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的订单</title>
    <link rel="stylesheet" type="text/css" href="myorder/order-css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="myorder/order-css/default.css">
    <link rel="stylesheet" href="myorder/order-css/style.css">
    <link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/dish.css">
    <script src="js/jquery-2.1.0.js"></script>
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
</head>
<body>
<s:include value="header.jsp"></s:include>
<div class="htmleaf-container">
    <div class="container pb30">
        <div class="clear-backend">
            <div class="avatar">
                <div>
                    <img src="myorder/order-img/135px&126px.jpg" alt="">
                </div>
            </div>

            <!-- 侧边栏 -->
            <input type="radio" class="tab-1" name="tab" checked="checked">
            <span>我的订单</span><i class="fa fa-user"></i>

            <!-- 内容 -->
            <div class="tab-content">
                <section class="tab-item-1">
                    <s:include value="allorder.jsp"></s:include>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>