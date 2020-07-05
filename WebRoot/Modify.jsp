<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>修改收货信息</title>
		<link href="../css/index.css" rel="stylesheet" type="text/css"  />
		<link rel="stylesheet" href="../css/ydui.css?rev=@@hash">
		<!--<link rel="stylesheet" href="../css/demo.css">-->
		<script src="../js/ydui.flexible.js"></script>
		
	</head>
	<body>
		<div id="container">

<table border="1" align="center">
	<form method="post" action="${pageContext.request.contextPath}/update.action">
	联系人:<input type="text" name="ad.name" value="<s:property value="#session.ad.name"/>"><br>
	详细地址:<input type="text" name="ad.address" value="<s:property value="#session.ad.address"/>"><br>
	手机号码:<input type="text" name="ad.cellphone" value="<s:property value="#session.ad.cellphone"/>"><br>
	省,市,区:<input type="text" name="ad.province" value="<s:property value="#session.ad.province"/>"><br>
	<input type="text" name="ad.absolutephone" value="<s:property value="#session.ad.absolutephone"/>" style="display:none"/><br>
	<input type="submit" value="修改">
	</form>
</table>
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
