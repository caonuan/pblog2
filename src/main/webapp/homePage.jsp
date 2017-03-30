<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Panacea技术博客</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>img/favicon.ico" />
<!-- load stylesheets 
<link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:300,400">-->
<!-- Google web font "Open Sans" -->
<link rel="stylesheet" href="font-awesome-4.6.3/css/font-awesome.min.css">
<!-- Font awesome -->
<link rel="stylesheet" href="css/home-bootstrap.min.css">
<!-- Bootstrap style -->
<link rel="stylesheet" href="css/hero-slider-style.css">
<!-- Hero slider style (https://codyhouse.co/gem/hero-slider/) -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- Magnific popup style (http://dimsemenov.com/plugins/magnific-popup/) -->
<link rel="stylesheet" href="css/templatemo-style.css">
<!-- Templatemo style -->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- Content -->
	<div class="cd-hero">

		<!-- Navigation -->
		<div class="cd-slider-nav">
			<nav class="navbar">

			<button class="navbar-toggler hidden-md-up" type="button" data-toggle="collapse"
				data-target="#tmNavbar">&#9776;</button>
			<div class="collapse navbar-toggleable-sm text-xs-center text-uppercase tm-navbar"
				id="tmNavbar">
				<ul class="nav navbar-nav">
					<li class="nav-item active selected"><a class="nav-link" href="#0"
						data-no="1"><i class="fa fa-home"></i>主页<span class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="#0" data-no="2"><i
							class="fa fa-book"></i>博文</a></li>
					<li class="nav-item"><a class="nav-link" href="#0" data-no="3"><i
							class="fa fa-camera"></i>相册</a></li>
					<!-- <li class="nav-item"><a class="nav-link" href="#0" data-no="4">留言</a></li> -->
					<li class="nav-item"><a class="nav-link" href="#0" data-no="4"><i
							class="fa fa-comment"></i>留言</a></li>
				</ul>
			</div>
			</nav>
		</div>


		<ul class="cd-hero-slider">
			<!-- autoplay -->
			<li class="selected">
				<div class="cd-full-width">
					<div class="container-fluid js-tm-page-content tm-page-1" data-page-no="1"
						style="margin-top:120px;">
						<div class="row">
							<div class="col-xs-12">
								<h2 class="tm-site-name">Panacea技术博客</h2>
								<div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-1-col">
									<p class="tm-text">
										&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
										<!-- 欢迎来到Panacea的技术博客！博客主要内容为平时工作、学习中遇到的编程部分问题的记录。 当然既然设计出了相册功能，自然也有一点点照片。
										阅读本博客源码请移步至<a rel="nofollow" href="https://github.com/caonuan"
											target="_blank">Github:caonuan</a> 。 -->
										欢迎来到Panacea技术博客测试版v1.0。目前功能尚未开发完全，后期将持续补充。对此博客有任何意见均可在留言页面进行留言或者直接与我本人联系。留言界面无需注册，使用一次后自动绑定ip地址。
										源码暂时不公布。想查看管理界面请访问<a rel="nofollow"
											href="http://caonuan.science/manage/managerLogin">这里</a>，账号ustb，密码admin。请勿肆意修改。
									</p>
									<p class="tm-text" style="text-align: right;">16/8/24</p>
									<p class="tm-text" style="text-align: right;">曹怒安</p>
								</div>
							</div>
						</div>
					</div>
					<div class="container-fluid"
						style="background-color: rgba(0, 0, 0, 0.75); margin-top: 20px; padding: 20px;margin-bottom: 40px">
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
								<div class="tm-footer-content-box">
									<div class="tm-gray-bg"></div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
								<div class="tm-footer-content-box tm-footer-links-container"></div>
							</div>
							<div class="clearfix hidden-lg-up"></div>
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
								<div class="tm-footer-content-box">
									<h3 style="color: #cc9900">GitHub项目入口</h3>
									<a href="https://github.com/caonuan/pblog2">caonuan/pblog2</a>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
								<div class="tm-footer-content-box">
									<h3 style="color: #cc9900">管理界面入口</h3>
									<a href="http://caonuan.science/manage/login">管理</a>
								</div>
							</div>
						</div>
					</div>
				</div> <!-- .cd-full-width -->
			</li>

			<li>
				<div class="cd-full-width">
					<div class="container-fluid js-tm-page-content" data-page-no="2">
						<div class="row">
							<div class="col-xs-12" style="text-align: left;">
								<s:iterator value="articleList" id="article" status="st">
									<s:if test="#st.even">
										<div class="tm-2-col-container">
											<a href="<%=basePath%>article/showArticle?articleId=${article.articleId}">
												<div class="tm-bg-white-translucent tm-textbox tm-2-col-textbox"
													style="max-width: 100% ! important; width: 860px; word-break: break-all;">
													<h2 class="tm-text-title">${article.title }</h2>
													<p style="margin: 0px">
														<span>类型：<s:property
																value="(blogClassMap.get(#article.blogClassId)).className" /></span> <span
															style="float: right;">发布时间：${article.publishDate }</span>
													</p>
													<s:if test="#article.updateDate!=null">
														<p style="text-align: right; margin: 0px">最后修改时间：${article.updateDate }</p>
													</s:if>
													<hr>
													${article.content }
												</div>
											</a>
										</div>
									</s:if>
									<s:else>
										<div class="tm-2-col-container">
											<a href="<%=basePath%>article/showArticle?articleId=${article.articleId}">
												<div class="tm-bg-white-translucent tm-textbox tm-2-col-textbox "
													style="max-width: 100% ! important; background-color: #D3D3D3; width: 860px;word-break: break-all;">
													<h2 class="tm-text-title">${article.title }</h2>
													<p style="margin: 0px">
														<span>类型：<s:property
																value="blogClassMap.get(#article.blogClassId).className" /></span> <span
															style="float: right;">发布时间：${article.publishDate }</span>
													</p>
													<s:if test="#article.updateDate!=null">
														<p style="text-align: right; margin: 0px">最后修改时间：${article.updateDate }</p>
													</s:if>
													<hr>
													${article.content }
												</div>
											</a>
										</div>
									</s:else>
								</s:iterator>
							</div>
						</div>
					</div>
				</div> <!-- .cd-full-width -->
			</li>
			<%--  原本设置的滚轮展示博文，后来发现确实不太合适
			<div id="myCarousel" class="carousel slide" style="width: 100%"><ol class="carousel-indicators"><s:iterator value="articleList" status="st"><s:if test="#st.index==0"><li data-target="#myCarousel" data-slide-to="${st.index}" class="active"></li>
</s:if><s:else><li data-target="#myCarousel" data-slide-to="${st.index}"></li></s:else></s:iterator></ol><div class="carousel-inner">
<s:iterator value="articleList" id="article" status="st"><s:if test="#st.index==0"><div class="carousel-item active">
<a href="<%=basePath%>article/showArticle?articleId=${article.articleId}"><div class="tm-bg-white-translucent text-xs-left tm-textbox tm-1-col-textbox">
<h2 class="tm-text-title">${article.title }</h2><p class="tm-text" escapeHtml="false">${article.content }</p></div></a>
<div class="carousel-caption">${article.title }</div></div></s:if><s:else><div class="carousel-item "><div class="tm-bg-white-translucent text-xs-left tm-textbox tm-2-col-textbox">
<h2 class="tm-text-title">${article.title }</h2><p class="tm-text" escapeHtml="false">${article.content }</p></div><div class="carousel-caption">${article.title }</div>
</div></s:else></s:iterator></div><a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a><a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
--%>
			<li>

				<div class="cd-full-width">
					<div class="container-fluid js-tm-page-content" data-page-no="3">
						<div id="myCarousel" class="carousel slide"
							style="max-width: 70%; max-height: 522px; margin: auto;">
							<ol class="carousel-indicators">
								<s:iterator value="photoList" status="st">
									<s:if test="#st.index==0">
										<li data-target="#myCarousel" data-slide-to="${st.index}" class="active"></li>
									</s:if>
									<s:else>
										<li data-target="#myCarousel" data-slide-to="${st.index}"></li>
									</s:else>
								</s:iterator>
							</ol>
							<div class="carousel-inner" style="max-height: 522px">
								<s:iterator value="photoList" id="photo" status="st">
									<s:if test="#st.index==0">
										<div class="carousel-item active" style="max-width: 100%; max-height: 100%">
											<img alt="${photo.photoName }" src="<%=basePath %>../${photo.url }"
												style="max-width: 100%; max-height: 100%">
											<div class="carousel-caption">${photo.photoName }</div>
										</div>
									</s:if>
									<s:else>
										<div class="carousel-item " style="max-width: 100%; max-height: 100%">
											<img alt="${photo.photoName }" src="<%=basePath %>../${photo.url }">
											<div class="carousel-caption">${photo.photoName }</div>
										</div>
									</s:else>
								</s:iterator>
							</div>
							<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a><a
								class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
						</div>

						<s:iterator value="albumlist" id="album">
							<div class="row tm-img-gallery">
								<p class="tm-text tm-font-w-400 m-b-3">
									<input type="button" class="btn-link" value="${album.albumName }"
										style="color: white">
								</p>
								<s:iterator value="photoMap.get(#album.albumId)" id="photo">
									<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">
										<a href="<%=basePath %>../${photo.url }"> <img
											src="<%=basePath %>../${photo.url }" alt="Image" class="img-fluid tm-img">
										</a>
									</div>
								</s:iterator>
							</div>
						</s:iterator>
					</div>
				</div>
			</li>

			<%-- <li>
				class="cd-bg-video"
				<div class="js-tm-page-content" data-page-no="4">

					<div class="cd-bg-video-wrapper" data-video="video/sunset-loop">
						video element will be loaded using jQuery
					</div>
					.cd-bg-video-wrapper

				</div>

			</li> --%>

			<li style="background-size: cover">
				<div class="cd-full-width">

					<div class="container-fluid js-tm-page-content" data-page-no="4">

						<div class="tm-contact-page">

							<div class="row">

								<div class="col-xs-12">

									<h2 class="tm-section-title"
										style="color: #000000; text-shadow: 0px 2px 1px rgb(247, 247, 247)">留言</h2>
									<p class="tm-text tm-font-w-400 m-b-3" style="color: #000000">有任何对此博客系统或者对我本人的建议都可以在此处留言！</p>
									<p class="tm-text tm-font-w-400 m-b-3" style="color: #484141">*email信息不会被公开*</p>

								</div>

							</div>

							<!-- contact form -->
							<div class="row">
								<form action="<%=basePath%>note/addNote" method="post"
									class="tm-contact-form">
									<input type="hidden" name="mac" value="${visitor.mac }"> <input
										type="hidden" name="visitorId" value="${visitor.visitorId }">
									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 col-xl-6">
										<div class="form-group">
											<input type="text" id="contact_name" name="name" class="form-control"
												placeholder="Your Name*" required value="${visitor.name }" />
										</div>
										<div class="form-group">
											<input type="email" id="contact_email" name="email" class="form-control"
												placeholder="Your Email*" required value="${visitor.email }" />
										</div>
									</div>

									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 col-xl-6">
										<div class="form-group">
											<textarea id="contact_message" name="content" class="form-control"
												rows="3" placeholder="Your message" required></textarea>
										</div>
									</div>

									<div class="col-xs-12">
										<button type="submit" class="pull-xs-right tm-submit-btn">Submit</button>
									</div>
								</form>
							</div>
							<s:iterator value="noteList" id="note" status="st">
								<s:if test="#st.even">
									<div
										class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-1-col"
										style="width: 100%">
										<h2 class="tm-text-title">留言人：${visitorMap.get(note.visitorId).name }</h2>
										<p class="tm-text" style="word-wrap: break-word">${note.content }</p>
										<p class="tm-text" style="text-align: right;">${note.publishDate }</p>
									</div>
								</s:if>
								<s:else>
									<div
										class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-1-col"
										style="width: 100%; background-color: #D3D3D3">
										<h2 class="tm-text-title">留言人：${visitorMap.get(note.visitorId).name }</h2>
										<p class="tm-text" style="word-wrap: break-word">${note.content }</p>
										<p class="tm-text" style="text-align: right;">${note.publishDate }</p>
									</div>
								</s:else>
							</s:iterator>
						</div>
					</div>

				</div> <!-- .cd-full-width -->
			</li>
		</ul>
		<!-- .cd-hero-slider -->

		<footer class="tm-footer"> <%-- <div class="tm-social-icons-container">
		<a href="#" class="tm-social-link"><i class="fa fa-facebook"></i></a> <a href="#"
			class="tm-social-link"><i class="fa fa-google-plus"></i></a> <a href="#"
			class="tm-social-link"><i class="fa fa-twitter"></i></a> <a href="#"
			class="tm-social-link"><i class="fa fa-behance"></i></a> <a href="#"
			class="tm-social-link"><i class="fa fa-linkedin"></i></a>
	</div>
--%>
		<p class="tm-copyright-text">Copyright &copy; 2016 Caonuan - Panacea</p>
		</footer>
	</div>
	<!-- .cd-hero -->


	<!-- Preloader, https://ihatetomatoes.net/create-custom-preloading-screen/ -->
	<div id="loader-wrapper">

		<div id="loader"></div>
		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>

	</div>

	<!-- load JS files -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- jQuery (https://jquery.com/download/) -->
	<script src="ja/tether.min.js"></script>
	<!-- Tether for Bootstrap (http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h) -->
	<script src="js/home-bootstrap.min.js"></script>
	<!-- Bootstrap js (v4-alpha.getbootstrap.com/) -->
	<script src="js/hero-slider-main.js"></script>
	<!-- Hero slider (https://codyhouse.co/gem/hero-slider/) -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- Magnific popup (http://dimsemenov.com/plugins/magnific-popup/) -->

	<script>
		function adjustHeightOfPage(pageNo) {

			// Get the page height
			var totalPageHeight = 15
					+ $('.cd-slider-nav').height()
					+ $(
							".cd-hero-slider li:nth-of-type(" + pageNo
									+ ") .js-tm-page-content").height() + 160
					+ $('.tm-footer').height();

			// Adjust layout based on page height and window height
			if (totalPageHeight > $(window).height()) {
				$('.cd-hero-slider').addClass('small-screen');
				$('.cd-hero-slider>li:nth-of-type(' + pageNo + ')').css(
						"min-height", totalPageHeight + "px");
			} else {
				$('.cd-hero-slider').removeClass('small-screen');
				$('.cd-hero-slider>li:nth-of-type(' + pageNo + ')').css(
						"min-height", "100%");
			}

		}

		/*
		    Everything is loaded including images.
		 */
		$(window)
				.load(
						function() {

							adjustHeightOfPage(1); // Adjust page height

							/* Gallery pop up
							-----------------------------------------*/
							$('.tm-img-gallery').magnificPopup({
								delegate : 'a', // child items selector, by clicking on it popup will open
								type : 'image',
								gallery : {
									enabled : true
								}
							});

							/* Collapse menu after click 
							-----------------------------------------*/
							$('#tmNavbar a').click(function() {
								$('#tmNavbar').collapse('hide');

								adjustHeightOfPage($(this).data("no")); // Adjust page height       
							});

							/* Browser resized 
							-----------------------------------------*/
							$(window)
									.resize(
											function() {
												var currentPageNo = $(
														".cd-hero-slider li.selected .js-tm-page-content")
														.data("page-no");
												adjustHeightOfPage(currentPageNo);
											});

							// Remove preloader
							// https://ihatetomatoes.net/create-custom-preloading-screen/
							$('body').addClass('loaded');

						});
	</script>

</body>
</html>