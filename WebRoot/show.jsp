<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--      <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> --%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社区详情</title>
		<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
		<style type="text/css">
			
			#one{
				height: 35px;
				width: 30%;
				 background: #4588db; 
				color: white;
				font-size: 20px;
				margin-left: 35%;
				margin-top:3%;
				padding-top:5px;
				border-radius:5px;
			}
			#two{
				height: 35px;
				/* background-color: bisque; */
			}
			#three{
				width: 75%;
				height: auto;
				/* background-color: yellowgreen; */
				margin-left: 12%;
				margin-top: 3%;
			}
			#textput{
				width: 88%;
				height: 300px;
				/* background-color: greenyellow; */
				font-size: 20px;
			}
			
				* {
		margin: 0px;
		padding: 0px;
	}
body {
		background: url("${pageContext.request.contextPath}/img/bg.jpg") no-repeat fixed;
	}

	#qq {
		width: 600px;
		/*宽*/
		height: 170px;
		/*高*/
		background: #fff;
		/*背景颜色*/
		margin: 50px auto 30px;
		border-radius: 5px;
		/*Html5 圆角*/
	}

	#qq p {
		font-size: 12px;
		color: #666;
		font-family: "微软雅黑";
		line-height: 45px;
		text-indent: 20px;
	}

	#qq .message {
		width: 560px;
		height: 70px;
		margin: 0 auto;
		overflow: hidden;
		outline: none;
		border: 1px solid #ddd;
		padding: 8px;
		box-sizing: border-box;
		font-size: 14px;
		-webkit-background-clip: text;
		color: transparent;
		background-image: linear-gradient(to right, #778899 0%, #333 100%);
		/*粗细 风格 颜色*/
	}

	#qq .But {
		width: 560px;
		height: 35px;
		margin: 15px auto 0px;
		position: relative;
		/*相对，参考对象*/
	}

	#qq .But img.bq {
		float: left;
		/*左浮动*/
	}

	#qq .But span.submit {
		width: 80px;
		height: 30px;
		background: #ff8140;
		display: block;
		float: right;
		/*右浮动*/
		line-height: 30px;
		border-radius: 5px;
		cursor: pointer;
		/*手指*/
		color: #fff;
		font-size: 12px;
		text-align: center;
		font-family: "微软雅黑";
	}

	/*face begin*/
	#qq .But .face {
		width: 440px;
		background: #fff;
		border: 1px solid #ddd;
		box-shadow: 0 0 12px #666;
		position: absolute;
		/*绝对定位*/
		top: 21px;
		left: 15px;
		display: none;
		/*隐藏*/
	}

	#qq .But .face ul {
		width: 100%;
		height: 100%;
		display: flex;
		flex-wrap: wrap;
		padding: 8px;
		box-sizing: border-box;
	}

	#qq .But .face ul li {
		width: 30px;
		height: 30px;
		list-style-type: none;
		cursor: pointer;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	/*msgCon begin*/
	.msgCon {
		width: 600px;
		margin: 0px auto;
		margin-bottom: 60px;
	}

	.msgCon .msgBox {
		background: #fff;
		padding: 10px;
		box-sizing: border-box;
		margin-top: 16px;
		border-radius: 4px;
	}

	.msgCon .msgBox .headUrl {
		width: 100%;
		height: 60px;
		border-bottom: 1px dotted #ddd;
		display: flex;
		align-items: center;
	}

	.msgCon .msgBox .headUrl img {
		width: 46px;
		height: 46px;
		border-radius: 50%
	}

	.msgCon .msgBox .headUrl div {
		flex: 1;
		display: flex;
		flex-flow: column;
		font-size: 16px;
		margin-left: 16px;
		-webkit-background-clip: text;
		color: transparent;
		background-image: linear-gradient(to top, #b224ef 0%, #7579ff 100%);
	}

	.msgCon .msgBox .headUrl div .time {
		font-size: 14px;
		margin-top: 6px;
		-webkit-background-clip: text;
		color: transparent;
		background-image: linear-gradient(to right, #74ebd5 0%, #9face6 100%);
	}

	.msgCon .msgBox .headUrl a {
		font-size: 14px;
		padding: 10px;
		color: salmon;
		cursor: pointer;
	}

	.msgCon .msgBox .msgTxt {
		font-size: 14px;
		color: #666;
		min-height: 40px;
		line-height: 24px;
		padding: 10px;
		box-sizing: border-box;
		word-wrap: break-word;
		-webkit-background-clip: text;
		color: transparent;
		background-image: linear-gradient(to right, #778899 0%, #333 100%);
	}
		</style>
	</head>
	
	<!--
    	布局
    -->
	<body style="background-color: aliceblue;"><script src="/demos/googlegg.js"></script>
	
	<s:iterator value="#request.fslist" var="show">
		<div id="one" align="center">
			<p><s:property value="#show.headline"/></p>
		</div>
		<div id="two" align="center">
			<span>楼主：<s:property value="#show.username"/></span>&nbsp;&nbsp;<span>时间：<s:property value="#show.time"/></span>&nbsp;&nbsp;<span>点击：${show.count}</span>
		</div>
		<div id="three" align="center">
			<div id="textput">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#show.text"/></div>
			<div id="imgput">
				<img src="${pageContext.request.contextPath}/img/<s:property value="#show.img"/>" width="65%" height="400px"/>
			</div>
			
		</div>
	</s:iterator>
		
		

				<div id="qq">
		<p>有什么有意思的想法告诉大家?</p>
		<div class="message" contentEditable='true'></div>
		<div class="But">
			<img src="${pageContext.request.contextPath}/img/bba_thumb.gif" class='bq' />
			<span class='submit'>发表</span>
			<!--face begin-->
			<div class="face">
				<ul>
					<li><img src="${pageContext.request.contextPath}/img/smilea_thumb.gif" title="呵呵]"></li>
					<li><img src="${pageContext.request.contextPath}/img/tootha_thumb.gif" title="嘻嘻]"></li>
					<li><img src="${pageContext.request.contextPath}/img/laugh.gif" title="[哈哈]"></li>
					<li><img src="${pageContext.request.contextPath}/img/tza_thumb.gif" title="[可爱]"></li>
					<li><img src="${pageContext.request.contextPath}/img/kl_thumb.gif" title="[可怜]"></li>
					<li><img src="${pageContext.request.contextPath}/img/kbsa_thumb.gif" title="[挖鼻屎]"></li>
					<li><img src="${pageContext.request.contextPath}/img/cj_thumb.gif" title="[吃惊]"></li>
					<li><img src="${pageContext.request.contextPath}/img/shamea_thumb.gif" title="[害羞]"></li>
					<li><img src="${pageContext.request.contextPath}/img/zy_thumb.gif" title="[挤眼]"></li>
					<li><img src="${pageContext.request.contextPath}/img/bz_thumb.gif" title="[闭嘴]"></li>
					<li><img src="${pageContext.request.contextPath}/img/bs2_thumb.gif" title="[鄙视]"></li>
					<li><img src="${pageContext.request.contextPath}/img/lovea_thumb.gif" title="[爱你]"></li>
					<li><img src="${pageContext.request.contextPath}/img/sada_thumb.gif" title="[泪]"></li>
					<li><img src="${pageContext.request.contextPath}/img/heia_thumb.gif" title="[偷笑]"></li>
					<li><img src="${pageContext.request.contextPath}/img/qq_thumb.gif" title="[亲亲]"></li>
					<li><img src="${pageContext.request.contextPath}/img/sb_thumb.gif" title="[生病]"></li>
					<li><img src="${pageContext.request.contextPath}/img/mb_thumb.gif" title="[太开心]"></li>
					<li><img src="${pageContext.request.contextPath}/img/ldln_thumb.gif" title="[懒得理你]"></li>
					<li><img src="${pageContext.request.contextPath}/img/yhh_thumb.gif" title="[右哼哼]"></li>
					<li><img src="${pageContext.request.contextPath}/img/zhh_thumb.gif" title="[左哼哼]"></li>
					<li><img src="${pageContext.request.contextPath}/img/x_thumb.gif" title="[嘘]"></li>
					<li><img src="${pageContext.request.contextPath}/img/cry.gif" title="[衰]"></li>
					<li><img src="${pageContext.request.contextPath}/img/wq_thumb.gif" title="[委屈]"></li>
					<li><img src="${pageContext.request.contextPath}/img/t_thumb.gif" title="[吐]"></li>
					<li><img src="${pageContext.request.contextPath}/img/k_thumb.gif" title="[打哈气]"></li>
					<li><img src="${pageContext.request.contextPath}/img/bba_thumb.gif" title="[抱抱]"></li>
					<li><img src="${pageContext.request.contextPath}/img/angrya_thumb.gif" title="[怒]"></li>
					<li><img src="${pageContext.request.contextPath}/img/yw_thumb.gif" title="[疑问]"></li>
					<li><img src="${pageContext.request.contextPath}/img/cza_thumb.gif" title="[馋嘴]"></li>
					<li><img src="${pageContext.request.contextPath}/img/88_thumb.gif" title="[拜拜]"></li>
					<li><img src="${pageContext.request.contextPath}/img/sk_thumb.gif" title="[思考]"></li>
					<li><img src="${pageContext.request.contextPath}/img/sweata_thumb.gif" title="[汗]"></li>
					<li><img src="${pageContext.request.contextPath}/img/sleepya_thumb.gif" title="[困]"></li>
					<li><img src="${pageContext.request.contextPath}/img/sleepa_thumb.gif" title="[睡觉]"></li>
					<li><img src="${pageContext.request.contextPath}/img/money_thumb.gif" title="[钱]"></li>
					<li><img src="${pageContext.request.contextPath}/img/sw_thumb.gif" title="[失望]"></li>
					<li><img src="${pageContext.request.contextPath}/img/cool_thumb.gif" title="[酷]"></li>
					<li><img src="${pageContext.request.contextPath}/img/hsa_thumb.gif" title="[花心]"></li>
					<li><img src="${pageContext.request.contextPath}/img/hatea_thumb.gif" title="[哼]"></li>
					<li><img src="${pageContext.request.contextPath}/img/gza_thumb.gif" title="[鼓掌]"></li>
					<li><img src="${pageContext.request.contextPath}/img/dizzya_thumb.gif" title="[晕]"></li>
					<li><img src="${pageContext.request.contextPath}/img/bs_thumb.gif" title="[悲伤]"></li>
					<li><img src="${pageContext.request.contextPath}/img/crazya_thumb.gif" title="[抓狂]"></li>
					<li><img src="${pageContext.request.contextPath}/img/h_thumb.gif" title="[黑线]"></li>
					<li><img src="${pageContext.request.contextPath}/img/yx_thumb.gif" title="[阴险]"></li>
					<li><img src="${pageContext.request.contextPath}/img/nm_thumb.gif" title="[怒骂]"></li>
					<li><img src="${pageContext.request.contextPath}/img/hearta_thumb.gif" title="[心]"></li>
					<li><img src="${pageContext.request.contextPath}/img/unheart.gif" title="[伤心]"></li>
					<li><img src="${pageContext.request.contextPath}/img/pig.gif" title="[猪头]"></li>
					<li><img src="${pageContext.request.contextPath}/img/ok_thumb.gif" title="[ok]"></li>
					<li><img src="${pageContext.request.contextPath}/img/ye_thumb.gif" title="[耶]"></li>
					<li><img src="${pageContext.request.contextPath}/img/good_thumb.gif" title="[good]"></li>
					<li><img src="${pageContext.request.contextPath}/img/no_thumb.gif" title="[不要]"></li>
					<li><img src="${pageContext.request.contextPath}/img/z2_thumb.gif" title="[赞]"></li>
					<li><img src="${pageContext.request.contextPath}/img/come_thumb.gif" title="[来]"></li>
					<li><img src="${pageContext.request.contextPath}/img/sad_thumb.gif" title="[弱]"></li>
					<li><img src="${pageContext.request.contextPath}/img/lazu_thumb.gif" title="[蜡烛]"></li>
					<li><img src="${pageContext.request.contextPath}/img/clock_thumb.gif" title="[钟]"></li>
					<li><img src="${pageContext.request.contextPath}/img/cake.gif" title="[蛋糕]"></li>
					<li><img src="${pageContext.request.contextPath}/img/m_thumb.gif" title="[话筒]"></li>
					<li><img src="${pageContext.request.contextPath}/img/weijin_thumb.gif" title="[围脖]"></li>
					<li><img src="${pageContext.request.contextPath}/img/lxhzhuanfa_thumb.gif" title="[转发]"></li>
					<li><img src="${pageContext.request.contextPath}/img/lxhluguo_thumb.gif" title="[路过这儿]"></li>
					<li><img src="${pageContext.request.contextPath}/img/bofubianlian_thumb.gif" title="[bofu变脸]"></li>
					<li><img src="${pageContext.request.contextPath}/img/gbzkun_thumb.gif" title="[gbz困]"></li>
					<li><img src="${pageContext.request.contextPath}/img/boboshengmenqi_thumb.gif" title="[生闷气]"></li>
					<li><img src="${pageContext.request.contextPath}/img/chn_buyaoya_thumb.gif" title="[不要啊]"></li>
					<li><img src="${pageContext.request.contextPath}/img/daxiongleibenxiong_thumb.gif" title="[dx泪奔]"></li>
					<li><img src="${pageContext.request.contextPath}/img/cat_yunqizhong_thumb.gif" title="[运气中]"></li>
					<li><img src="${pageContext.request.contextPath}/img/youqian_thumb.gif" title="[有钱]"></li>
				</ul>
			</div>
			<!--face end-->
		</div>
</div>
	<!--qq end-->
	<div class="msgCon"></div>
	<!--
    	js
    -->
	<script type="text/javascript">
	//从缓存中获取数据并渲染
	let msgBoxList = JSON.parse(window.localStorage.getItem('msgBoxList')) || [];
	innerHTMl(msgBoxList)

	//点击小图片，显示表情
	$(".bq").click(function (e) {
		$(".face").slideDown(); //慢慢向下展开
		e.stopPropagation(); //阻止冒泡事件
	});

	//在桌面任意地方点击，关闭表情框
	$(document).click(function () {
		$(".face").slideUp(); //慢慢向上收
	});

	//点击小图标时，添加功能
	$(".face ul li").click(function () {
		let simg = $(this).find("img").clone();
		$(".message").append(simg); //将表情添加到输入框
	});

	//点击发表按扭，发表内容
	$("span.submit").click(function () {
		let txt = $(".message").html(); //获取输入框内容
		if (!txt) {
			$('.message').focus(); //自动获取焦点
			return;
		}
		let obj = {
			msg: txt
		}
		msgBoxList.unshift(obj) //添加到数组里
		window.localStorage.setItem('msgBoxList', JSON.stringify(msgBoxList)) //将数据保存到缓存
		innerHTMl([obj]) //渲染当前输入框内容
		$('.message').html('') // 清空输入框

	});

	//删除当前数据
	$("body").on('click', '.del', function () {
		let index = $(this).parent().parent().index();
		msgBoxList.splice(index, 1)
		window.localStorage.setItem('msgBoxList', JSON.stringify(msgBoxList)) //将数据保存到缓存
		$(this).parent().parent().remove()
	})

	//渲染html
	function innerHTMl(List) {
		List = List || []
		List.forEach(item => {
			let str =
				`<div class='msgBox'>
					<div class="headUrl">
						<img src='${pageContext.request.contextPath}/img/tx.jpg' width='50' height='50'>
						<div>
							<span class="title">木林森里没有木</span>
							<span class="time">2018-01-01</span>
						</div>
						<a class="del">删除</a>
					</div>
					<div class='msgTxt'>
						${item.msg}
					</div>
				</div>`
			$(".msgCon").prepend(str);
		})
	}
</script>
	

			
		
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">

</div>
	</body>
</html>
