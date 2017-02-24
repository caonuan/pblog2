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
<title>博文列表</title>
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
						<li><a href="<%=basePath%>/home" data-hover="主页">主页</a></li>
						<li class="active"><a href="<%=basePath%>article/viewArticle?pageNow=1">博客</a></li>
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
				<s:iterator value="articleList" id="article">
					<div class="text-in"
						style="border-bottom: 1px dashed #ddd; margin: 0 10px; padding: 20px 0 15px 0;">
						<a class="view-article-a"
							href="<%=basePath%>article/showArticle?articleId=${article.articleId}"
							onmouseover="this.style.cssText='text-decoration:none;'">
							<div class="single-men">
								<s:if test="#article.topPost==1">
									<h5 ><span style="color: red">【置顶】</span><span>${article.title }</span></h5>
								</s:if>
								<s:else>
									<h5>${article.title }</h5>
								</s:else>
								<p style="margin: 0px; color: #750000; font-size: 10px;">
									<span>类型：<s:property
											value="blogClassList.get(#article.blogClassId-1).className" /></span> <span
										style="float: right;">发布时间：${article.publishDate }</span>
								</p>
								<p style="margin: 0px; color: #750000; font-size: 10px;">
									<span>访问次数：<s:property value="#article.readCount" /></span>
									<s:if test="#article.updateDate!=null">
										<span style="float: right;">最后修改时间：${article.updateDate }</span>
									</s:if>
								</p>
								${article.content }
							</div>
						</a>
					</div>
				</s:iterator>
				<div>
					<ul class="pager">
						<s:if test="pageNow<=1">
							<li class="previous disabled"><a onclick="return false"
								href="<%=basePath %>article/viewArticle?pageNow=${pageNow}">&larr; 上一页</a></li>
						</s:if>
						<s:else>
							<li class="previous"><a
								href="<%=basePath %>article/viewArticle?pageNow=${pageNow-1}">&larr; 上一页</a></li>
						</s:else>
						<ul class="pagination  pagination-sm" style="margin: 0">
							<c:forEach begin="1" end="${pageCount }" varStatus="status">
								<c:if test="${ status.index==pageNow}">
									<li class="disabled"><a onclick="return false"
										href="<%=basePath %>article/viewArticle?pageNow=${status.index}">${status.index}</a></li>
								</c:if>
								<c:if test="${ status.index!=pageNow}">
									<li><a href="<%=basePath %>article/viewArticle?pageNow=${status.index}">${status.index}</a></li>
								</c:if>
							</c:forEach>
						</ul>
						<s:if test="pageNow>=pageCount">
							<li class="next disabled"><a onclick="return false"
								href="<%=basePath %>article/viewArticle?pageNow=${pageNow}">下一页 &rarr;</a></li>
						</s:if>
						<s:else>
							<li class="next"><a
								href="<%=basePath %>article/viewArticle?pageNow=${pageNow+1}">下一页 &rarr;</a></li>
						</s:else>
					</ul>
				</div>
			</div>
		</div>
		<%@include  file="bottom_tags.jsp"%>
		<script type="text/javascript">
			$(document).ready(function() {
				$().UItoTop({
					easingType : 'easeOutQuart'
				});
			});
		</script>
		<a href="#" id="toTop" style="display: block;"> <span id="toTopHover"
			style="opacity: 1;"> </span></a>
	</div>
</body>
</html>