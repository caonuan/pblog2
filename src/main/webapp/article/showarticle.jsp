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
<title>${article.title}</title>
<html xmlns:wb="http://open.weibo.com/wb">
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>img/favicon.ico" />
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=basePath%>js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	 function hideURLbar(){ window.scrollTo(0,1); }

</script>
<!--fonts
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
-->
<!--//fonts-->
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
						<li class="active"><a href="#">博文 </a></li>
						<li><a href="<%=basePath%>/home" data-hover="主页">主页</a></li>
						<li><a href="<%=basePath%>article/viewArticle?pageNow=1" data-hover="博客">博客</a></li>
						<li><a href="#" data-hover="相册"> 相册 </a></li>
						<li><a href="#" data-hover="留言"> 留言</a></li>
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
	<div class="container" style="word-break: break-all;">
		<div class="single">
			<div class="col-md-9  single-top">
				<div class="text-in">
					<div class="single-men">
						<h5>${article.title }</h5>
						<p style="margin: 0px; color: #750000; font-size: 10px;">
							<span>类型：<s:property value="blogClass.className" /></span> <span
								style="float: right;">发布时间：${article.publishDate }</span>
						</p>
						<p style="margin: 0px; color: #750000; font-size: 10px;">
							<span>访问次数：<s:property value="article.readCount" /></span>
							<s:if test="article.updateDate!=null">
								<span style="float: right;">最后修改时间：${article.updateDate }</span>
							</s:if>
						</p>
						${article.content }
						<hr style="margin-bottom:0px">
						<hr style="margin-top:0px">
					</div>
					<div class="comment-grid-top">
						<h3>评论</h3>
						<s:iterator value="replyList" id="articleReply" status="status">
							<div class="comments-top-top">
								<div class="top-comment-left">
									<img class="img-responsive" src="<%=basePath%>img/co.png" alt="" />
								</div>
								<div class="top-comment-right">
									<ul>
										<li><span class="left-at">
												${visitorList.get(status.index).getName() }</span></li>
										<li><span class="right-at">${articleReply.publishTime}</span></li>
										<li><a class="reply" href="">REPLY</a></li>
									</ul>
									<p style="color: #4F4F4F;">${articleReply.content }</p>
								</div>
								<div class="clearfix"></div>
							</div>
						</s:iterator>
						<hr style="margin-bottom:0px">
						<hr style="margin-top:0px">
					</div>
				</div>
				<div class="comments-area">
					<h3>添加评论</h3>
					<p>（带*号必须填写，email信息不会公示）</p>
					<form method="post" action="<%=basePath%>article/addArticleReply">
						<input type="hidden" name="articleId" value="${articleId }">
						<p>
							<span>*Name</span> <input type="text" value="${visitor.name }" name="name"
								placeholder="Your Name" required>
						</p>
						<p>
							<span>*Email</span> <input type="text" value="${visitor.email }" name="email"
								placeholder="Your Email" required>
						</p>
						<p>
							<span>*Comment</span>
							<textarea required name="content"></textarea>
						</p>
						<div class="sub-in">
							<input type="submit" value="提交评论">
						</div>
					</form>
				</div>
			</div>
			<%@include file="bottom_tags.jsp" %>
		<script type="text/javascript">
			$(document).ready(function() {
				/*
				var defaults = {
					containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
				};
				 */

				$().UItoTop({
					easingType : 'easeOutQuart'
				});

			});

			window.fbAsyncInit = function() {
				FB.init({
					appId : '1777416245847645',
					xfbml : true,
					version : 'v2.7'
				});
			};

			(function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0];
				if (d.getElementById(id)) {
					return;
				}
				js = d.createElement(s);
				js.id = id;
				js.src = "//connect.facebook.net/en_US/sdk.js";
				fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
		</script>
		<a href="#" id="toTop" style="display: block;"> <span id="toTopHover"
			style="opacity: 1;"> </span></a>
	</div>
</body>
</html>