<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>收货地址模块</title>
		<link href="../css/add.css" rel="stylesheet" type="text/css"  />
		<link rel="stylesheet" href="../css/ydui.css?rev=@@hash">
		<!--<link rel="stylesheet" href="../css/demo.css">-->
		<script src="../js/ydui.flexible.js"></script>
		
	</head>
	<body>
		
		<div id="container">
		<div id="header">
			<h2 class="h">增添地址</h2>
			
		</div>
			<form action="${pageContext.request.contextPath}/addaddr.action" class="form" method="post">
			<div class="head">
				<p class="pmsg" >联系人信息</p><p class="mark" >标*为必填项</p>
				
				
			</div>
			<div id="center">
				<div id="group1">
					<div class="l-nameinput">
						<span id="mark">
						<label class="xin">*</label>
						<label class="name">姓名</label>
						</span>
						<input type="text" id="inputname" name="ad.name" placeholder="请填写联系人姓名" autocomplete="off" class="intputname" size="30"/>
					</div>
					<div id="R-absolutephone">
						<label class="phone1">固定电话</label>
						<input type="text"  name="ad.absolutephone" placeholder="请填写固定电话" autocomplete="off" id="absolutephone" size="30"/>
					</div>
				</div>
				<div id="group2">
					<div class="L2">
						<span id="mark2">
						<label class="xin2">*</label>
						<label class="address">详细地址</label>
						</span>
						<input type="text" id="address" name="ad.address" placeholder="请填写所有街道以及详细地址" autocomplete="off" class="address" size="30"/>
					</div>
					<div id="R2">
						<span id="mark">
						<label class="xin3">*</label>
						<label class="phone2">手机号码</label>
						</span>
						<input type="text" id="cellphone" name="ad.cellphone" placeholder="请填写手机号码" autocomplete="off" class="cellphone" size="30"/>
					</div>
				</div>
				<div id="group3">
						<span id="mark4">
						<label class="xin4">*</label>
						<label class="selectaddr">省市区</label>
						</span>
						<div id="selectaddr">
							 <div class="m-cell">
					            <div class="cell-item">
					                <!--<div class="cell-left">所在地区：</div>-->
					                <div class="cell-right cell-arrow">
					                    <input type="text" class="cell-input" readonly id="J_Address" placeholder="请选择所在地区，例如：广东省-深圳市-福田区" size="90" name="ad.province">
					                    <img src="../img/address.PNG" class="addr-img"/>
					                </div>
					            </div>
					        </div>	
								<!--<input type="text" id="province" name="province" placeholder="请选择所在地区，例如：广东省-深圳市-福田区" autocomplete="off" class="province" size="90"/>
							<img src="../img/address.PNG" class="addr-img"/>
							<div id="map"></div>-->
						</div>
					
					
				</div>
				<div id="group4">
					
					<input type="submit" value="确认" class="submit"></input>
				</div>
			</div>
			</form>
		</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/ydui.citys.js"></script>
<script type="text/javascript" src="../js/ydui.js"></script>	
<script type="text/javascript">
/**
 * 默认调用
 */
!function () {
	var $target = $('#J_Address');

	$target.citySelect();

	$target.on('click', function (event) {
		event.stopPropagation();
		$target.citySelect('open');
	});

	$target.on('done.ydui.cityselect', function (ret) {
		$(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
	});
}();

</script>
	</body>
</html>
