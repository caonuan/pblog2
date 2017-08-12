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
	
	function reply(receiveNoteId,receiveNoteOwnerName,receiveId,receiverName) {
        $("#receiverName").val(receiverName);
        $("#receiveId").val(receiveId);
        $("#receiveNoteId").val(receiveNoteId);
        $("#receiveNoteOwnerName").val(receiveNoteOwnerName);
        location.href = "#note_place";
    }

    function clear_form() {
        $("#receiverName").val("我曹怒安本人");
        $("#receiveId").val("1");
        $("#receiveNoteId").val("");
        $("#receiveNoteOwnerName").val("留言页");
        $("#name").val("${visitor.name}");
        $("#email").val("${visitor.email}");
    }
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
						<li><a href="<%=basePath%>${home_page}" data-hover="主页">主页</a></li>
						<li><a href="<%=basePath%>${article_page}" data-hover="博客">博客</a></li>
						<li><a href="<%=basePath%>${album_page}"  data-hover='相册'> 相册 </a></li>
						<li class="active"><a href="<%=basePath%>${note_page}"> 留言</a></li>
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
			<div class="comment-grid-top">
				<h3>评论</h3>
				<s:iterator value="noteList" id="note" status="status">
					<div class="comments-top-top">
						<div class="top-comment-left">
							<img class="img-responsive" src="<%=basePath%>img/co.png" alt="" />
						</div>
						<div class="top-comment-right">
							<ul>
								<li><span class="left-at">
										${note.visitor.name }</span></li>
								<li><span class="right-at">${note.publishDate}</span></li>
                                <li><a class="reply" onclick="reply(${note.noteId},'${note.visitor.name}',${note.visitor.visitorId},'${note.visitor.name}')"
                                       href="javascript:void(0)">REPLY</a>
							</ul>
							<p style="color: #4F4F4F;">${note.content }</p>
                            <s:iterator value="#note.receiveNoteList" id="receiveNote" status="status">
                                <div class="comments-area ">
                                    <div class="top-comment-right">
                                        <ul>
                                            <li><span class="left-at"> ${receiveNote.visitor.name} 回复 ${receiveNote.receiver.name}</span></li>
                                            <li><span class="right-at">${receiveNote.publishDate}</span></li>
                                            <li><a class="reply" onclick="reply(${note.noteId},'${note.visitor.name}',${receiveNote.visitor.visitorId},'${receiveNote.visitor.name}')"
                                                   href="javascript:void(0)">REPLY</a>
                                            </li>
                                        </ul>
                                        <p>${receiveNote.content}</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </s:iterator>
						</div>
						<div class="clearfix"></div>
					</div>
				</s:iterator>
				<hr style="margin-bottom:0px">
				<hr style="margin-top:0px">
			</div>
			<div class="col-md-7 contact-para" id="note_place">
				<p class="class-para">请填写相关信息</p>
				<h5>留言</h5>
				<form action="<%=basePath%>note/addNote" method="post">
					<div class="grid-contact">
						<div class="col-md-6 contact-grid">
							<p>NAME</p>
							<input id="name" name="name" type="text" value="${visitor.name }" onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='${visitor.name }';}">
						</div>
                        <div class="col-md-6 contact-grid">
                            <p>在谁的评论下回复：</p>
                            <input id="receiveNoteOwnerName" type="text" value="留言页" readonly style="color: #BDBDBD;">
                            <input id="receiveNoteId" type ="hidden" name="receiveNoteId" value="">
                        </div>
						<div class="clearfix"></div>
					</div>
					<div class="grid-contact">
						<div class="col-md-6 contact-grid">
							<p>E-MAIL ADDRESS</p>
							<input id="email" name="email" type="text" value="${visitor.email }" onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='${visitor.email }';}">
						</div>
                        <div class="col-md-6 contact-grid">
                            <p>回复给谁：</p>
                            <input id="receiverName" name="receiverName" type="text" value="我曹怒安本人" readonly style="color: #BDBDBD;">
                            <input id="receiveId" type="hidden" name="receiveId" value="1">
                        </div>
						<div class="clearfix"></div>
					</div>
					<p class="your-para">MESSAGE</p>
					<textarea name="content" cols="77" rows="6" value=" " onfocus="this.value='';"
						onblur="if (this.value == '') {this.value = '';}"></textarea>
					<div class="send">
						<input type="submit" value="提交留言">
                        <button type="button" onclick="javascript:clear_form()">清除</button>
					</div>
				</form>
			</div>
		<!--	<div class="col-md-5 contact-map">
				<h5>GOOGLE-MAP</h5>
				<div class="map">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d37494223.23909492!2d103!3d55!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x453c569a896724fb%3A0x1409fdf86611f613!2sRussia!5e0!3m2!1sen!2sin!4v1415776049771"></iframe>

				</div>
			</div>
		-->
			<div class="clearfix"></div>
		</div>
	</div>
	<!---->
	<%@include file="../bottom_tags.jsp" %>
</body>
</html>