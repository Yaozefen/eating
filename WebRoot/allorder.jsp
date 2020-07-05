<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>所有订单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="myorder/order-css/myorder.css">
    <script src="js/jquery-2.1.0.js"></script>
    <script>
        $(document).ready(function () {
            $(".add").click(function () {
                $(".page").css("display", "block");

            });
            $(".esc").click(function () {
                $(".page").css("display", "none");
            });
        });

    </script>
<body>
<%--其他页面--%>
<h2 style="text-align: center;"><a href="queryAll.action" style="color:black;">所有订单</a></h2></br>
<%--<h2 style="text-align: center"><a href="state.action?content=待付款">待付款</a></h2>--%>
<%--<h2 style="text-align: center"><a href="state.action?content=已完成">已完成</a></h2>--%>
<%--查和返回--%>
<form action="queryNum.action" method="post" style="text-align: center">
    <span>
        <input type="text" name="orders.orderNum" placeholder="请输入完整的订单号">
        <input type="submit" value="搜索">
    </span>
</form>
<div id="back" style="text-align: center">
    <input type="button" class="btn"  value="返回" onclick="javascript:history.go(-1);" />
</div>
<h3 style="text-align: right">
    <td>来一份：<a href="#" class="add"><img src="myorder/order-img/add.jpg" style="width: 20px; height: 20px"></a></td>
</h3>
</br>
<%--输出--%>
<s:iterator var="map" value="orderMap">
    <table width="99%" border="1">
        <col align="top">
        <tr>
            <td colspan="7" class="text-left">
                <input type="checkbox" name="delbook"  id="delbook"><b></b>
                <span>订单号：<b><s:property value="#map.key"/></b></span>
            </td>
            <td>
            </td>
        </tr>
        <tr style="text-align: center">
            
            <th style="text-align: center">菜名</th>
            <th style="text-align: center">价格</th>
            <th style="text-align: center">配送方式</th>
            <th style="text-align: center">订单状态</th>
            <th style="text-align: center">下单时间</th>
            <th style="text-align: center">删除订单
            </th>
        </tr>

        <s:iterator var="list" value="#map.value">
            <tr style="text-align: center">

              

                <td><s:property value="#list.dishName"/></td>

                <td><s:property value="#list.price"/></td>

                <td><s:property value="#list.way"/></td>

                <td><s:property value="#list.state"/></td>

                <td><s:property value="#list.orderTime"/></td>

                <td>
                    <a href="${pageContext.request.contextPath}/del.action?id=<s:property value="#map.key"/>">
                        <img src="myorder/order-img/delete.jpg" style="width: 20px; width: 20px"/>
                    </a>
                </td>

            </tr>
        </s:iterator>
    </table>
</s:iterator>
<%--隐藏框架--%>
<div class="page" style="display:none;">                            <!--隐藏框-->
    <div class="content" style="opacity:1;">
        <div class="up-header"><h3>来一份</h3></div>
        <div class="esc">
            <a href="#" style="text-decoration: none;color: #000000;">X</a>
        </div>
        <form action="add.action" method="post" class="form">
            <table style=" border-collapse: separate; border-spacing: 10px 20px; text-align: left">
               <tr>
                    <td>菜名：</td>
                    <td>
                        <select name="orders.dishName">
                            <option value="麻辣下龙虾">麻辣小龙虾</option>
                            <option value="油焗小龙虾">油焗小龙虾</option>
                            <option value="香煎秋刀鱼">香煎秋刀鱼</option>
                            <option value="白切鸭">白切鸭</option>
                            <option value="吉利鸡扒">吉利鸡扒</option>
                            <option value="蒜香小鸡吡">蒜香小鸡吡</option>
                            <option value="白切鸭腿">白切鸭腿</option>
                            <option value="红烧狮子头">红烧狮子头</option>
                            <option value="咖喱鱼蛋">咖喱鱼蛋</option>
                            <option value="招牌手撕鸡">招牌手撕鸡</option>
                            <option value="爆炒田螺">爆炒田螺</option>
                            <option value="清蒸鲜虾">清蒸鲜虾</option>
                            <option value="茶香虾">茶香虾</option>
                            <option value="香脆藤椒鸡排">香脆藤椒鸡排</option>
                            <option value="香芋地瓜丸">香芋地瓜丸</option>
                            <option value="拉丝芝士棒">拉丝芝士棒</option>
                            <option value="奥尔良鸡排">奥尔良鸡排</option>
                            <option value="芝士鸡排">芝士鸡排</option>
                            <option value="上校鸡块">上校鸡块</option>
                            <option value="热狗肠">热狗肠</option>
                            <option value="骨肉相连">骨肉相连</option>
                            <option value="鸡柳">鸡柳</option>
                            <option value="薯条">薯条</option>
                            <option value="烤鸡">烤鸡</option>
                            <option value="劲爆鸡米花">劲爆鸡米花</option>
                            <option value="香菇滑鸡饭">香菇滑鸡饭</option>
                            <option value="东坡肉">东坡肉</option>
                            <option value="糖醋里脊">糖醋里脊</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>份量:</td>
                    <td>
                        <select name="orders.price">
                            <option value="10">10元份</option>
                            <option value="12">12元份</option>
                            <option value="14">14元份</option>
                            <option value="16">16元份</option>
                            <option value="18">18元份</option>
                            <option value="20">20元份</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>当前状态：<input type="text" value="待付款" name="orders.state" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>外送/堂食：</td>
                    <td>
                        <select name="orders.way">
                            <option value="外送">外送</option>
                            <option value="堂食">堂食</option>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="确认" class="submit"/>
        </form>
    </div>
</div>

</body>
</html>
