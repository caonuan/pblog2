<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println(basePath+"  "+request.getAttribute("url"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${album.albumName}</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>img/favicon.ico"/>
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet" type="text/css"
          media="all"/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="<%=basePath%>css/show_image.css"/>
    <link  href="<%=basePath%>css/viewer.css" rel="stylesheet">
    <script src="<%=basePath%>js/viewer.js"></script>
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script type="application/x-javascript">
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);
	function hideURLbar(){
		window.scrollTo(0,1);
	}
</script>
<!--fonts
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
-->
<!--//fonts-->
<script type="text/javascript" src="<%=basePath%>js/move-top.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easing.js"></script>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript"
		charset="utf-8"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});


</script>

</head>
<body>
	<!--header-->
	<div class="container">
		<div class="header">
			<div class="header-top">
				<div class="logo">
					<a href="http://www.caonuan.science"><img src="<%=basePath%>img/logo.png"
						alt="" style="max-height: 100px"></a>
				</div>
				<div class="header-top-on">
					<ul class="social-in">
						<li><span>分享这篇文章:</span></li>
						<li><i></i></li>
						<li><a href="#"><i class="tin"> </i></a></li>
						<li><a href="#"><i class="message"> </i></a></li>
						<li><a href="#"
							onclick="javascript:window.open('http://service.weibo.com/share/share.php?url=<%=basePath%>article/viewArticle?pageNow=${pageNow }&appkey=1074373392title=&pic=&ralateUid=Panaceaea&language=zh_cn',
							'',
							'width=632,height=388,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes')"><i
								class="youtube"></i></a></li>
						<div style="display: block;">
							<wb:share-button appkey="1074373392" addition="simple" type="icon"
								default_text="Panaceaea技术博客" ralateUid="3956186163"></wb:share-button>
						</div>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<!---->
			<div class="header-bottom">
				<div class="top-nav">
					<span class="menu"> </span>
					<ul>
						<li><a href="<%=basePath%>${home_page}" data-hover="主页">主页</a></li>
						<li><a href="<%=basePath%>${article_page}" data-hover="博客">博客</a></li>
						<li class="active"><a href="<%=basePath%>${album_page}"> 相册 </a></li>
						<li><a href="<%=basePath%>${note_page}" data-hover="留言"> 留言</a></li>
					</ul>
					<!--script-->
					<script>
						$("span.menu").click(function() {
							$(".top-nav ul").slideToggle(500, function() {
							});
						});
					</script>
				</div>
				<div class="search">
					<form action="<%=basePath%>article/searchArticle">
						<input type="hidden" name="pageNow" value="1"> <input type="text"
							value="搜索.." onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '';}" name="keyWord"> <input
							type="submit" value="">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!---->
	<div class="container">
		<div class="events">
			<h2>相册</h2>
			<div class="events-grid" id="images">
				<s:iterator value="photoList" id="photo">
					<div class="col-md-4" style="text-align: center;">
						<img data-original="${photo.url}" src="${photo.tUrl}" style="top: 0px;max-width: 100%" alt="${photo.photoName}" />
							<span>${photo.photoName}</span>
					</div>
				</s:iterator>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

		<%@include  file="/bottom_tags.jsp"%>
		<script type="text/javascript">
			$(document).ready(function() {

				$().UItoTop({
					easingType : 'easeOutQuart'
				});

			});
            var options = {
                // inline: true,
                url: 'data-original',

            };
            var viewer = new Viewer(document.getElementById('images'),options);
		</script>
		<a href="#" id="toTop" style="display: block;"> <span id="toTopHover"
			style="opacity: 1;"> </span></a>
	</div>
</body>
</html>