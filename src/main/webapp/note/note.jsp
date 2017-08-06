<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>留言</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>img/favicon.ico" />
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=basePath%>js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<script type="text/javascript" src="<%=basePath%>js/move-top.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easing.js"></script>
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
						<div class="fb-share-button"
							data-href="http://www.caonuan.sicence/article/showArticle?articleId=21"
							data-layout="button" data-size="small" data-mobile-iframe="true">
							<a class="fb-xfbml-parse-ignore" target="_blank"
								href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Fwww.caonuan.sicence%2Farticle%2FshowArticle%3FarticleId%3D21&amp;src=sdkpreparse">分享</a>
						</div>
						<li><a href="#" id="shareFacebook"><i></i></a></li>
						<li><a href="#"><i class="tin"> </i></a></li>
						<li><a href="#"><i class="message"> </i></a></li>
						<li><a href="#"><i class="youtube"> </i></a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<!---->
			<div class="header-bottom">
				<div class="top-nav">
					<span class="menu"> </span>
					<ul>
						<li><a href="<%=basePath%>/home" data-hover="主页">主页</a></li>
						<li><a href="<%=basePath%>article/viewArticle?pageNow=1" data-hover="博客">博客</a></li>
						<li><a href="#"  data-hover='相册'> 相册 </a></li>
						<li class="active"><a href="<%=basePath%>note/showNote"> 留言</a></li>
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
		<div class="contact">
			<div class="col-md-7 contact-para">
				<p class="class-para">请填写相关信息</p>
				<h5>留言</h5>
				<form>
					<div class="grid-contact">
						<div class="col-md-6 contact-grid">
							<p>NAME</p>
							<input type="text" value="" onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='';}">
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="grid-contact">
						<div class="col-md-6 contact-grid">
							<p>E-MAIL ADDRESS</p>
							<input type="text" value="" onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='';}">
						</div>
						<div class="clearfix"></div>
					</div>
					<p class="your-para">MESSAGE</p>
					<textarea cols="77" rows="6" value=" " onfocus="this.value='';"
						onblur="if (this.value == '') {this.value = '';}"></textarea>
					<div class="send">
						<input type="submit" value="提交留言">
					</div>
				</form>
			</div>
			<div class="col-md-5 contact-map">
				<h5>GOOGLE-MAP</h5>
				<div class="map">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d37494223.23909492!2d103!3d55!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x453c569a896724fb%3A0x1409fdf86611f613!2sRussia!5e0!3m2!1sen!2sin!4v1415776049771"></iframe>

				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!---->
	<%@include file="../bottom_tags.jsp" %>
</body>
</html>