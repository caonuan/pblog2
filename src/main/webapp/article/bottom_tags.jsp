<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-3 single-bottom">
			<div class="store-right">
				<h6>博客类型</h6>
				<ul class="store-men">
					<s:iterator value="blogClassList" id="blogClass2" status="st">
						<s:if test="#st.last">
							<li class="last"><a
								href="<%=basePath%>article/viewArticleByBlogClass?blogClassId=${blogClass2.blogClassId}&pageNow=1"><span>
								</span>${blogClass2.className }</a></li>
						</s:if>
						<s:else>
							<li><a
								href="<%=basePath%>article/viewArticleByBlogClass?blogClassId=${blogClass2.blogClassId}&pageNow=1"><span>
								</span>${blogClass2.className }</a></li>
						</s:else>
					</s:iterator>
				</ul>
			</div>
			<div class="store-right">
				<h6>时间检索：</h6>
				<ul class="store-men">
					<s:iterator value="timeList" id="objects" status="status">
						<s:if test="#status.last">
							<li class="last"><a
								href="<%=basePath %>article/viewArticleByTime?time=${objects[0]}"><span>
								</span>${objects[0] }(${objects[1] }篇)</a></li>
						</s:if>
						<s:else>
							<li><a href="<%=basePath %>article/viewArticleByTime?time=${objects[0]}"><span>
								</span>${objects[0] }(${objects[1] }篇)</a></li>
						</s:else>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="container">
		<div class="footer">
			<div class="footer-top">
				<div class="col-md-3 amet-sed">
					<h4>导航</h4>
					<i class="line"> </i>
					<ul class="nav-bottom">
						<li><a href="<%=basePath%>/home">主页</a></li>
						<li><a href="<%=basePath%>article/viewArticle?pageNow=1">博客</a></li>
						<li><a href="#">相册 </a></li>
						<li><a href="#">留言</a></li>
						<li><a href="http://www.caonuan.science/pblog2/manager/login">管理</a></li>
					</ul>
				</div>
				<div class="col-md-3 amet-sed ">
					<h4>联系我</h4>
					<i class="line"> </i>
					<ul class="nav-bottom">
						<li><a href="mailto:caonuan@hotmail.com">CONTACT Me</a></li>
					</ul>
					<p>
						Email: <a href="mailto:caonuan@hotmail.com">caonuan@hotmail.com</a>
					</p>
				</div>
				<div class="col-md-3 amet-sed ">
					<h4>分享这篇文章：</h4>
					<i class="line"> </i>
					<ul class="social-in msg-social">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="tin"> </i></a></li>
						<li><a href="#"><i class="message"> </i></a></li>
						<li><a href="#"><i class="youtube"> </i></a></li>
					</ul>
					<p>
						关注我的微博:<a href="http://weibo.com/p/1005053956186163/home" target="_Blank">@Panaceaea</a>
					</p>
				</div>
				<div class="col-md-3 amet-sed ">
					<h4>友情链接：</h4>
					<i class="line"> </i>
					<ul class="nav-bottom">
						<li><a href="https://zrstea.com/" target="_blank">ZRStea</a></li>
						<li><a href="https://akinoheya.com/" target="_blank">Akiの部屋</a></li>
						<li><a href="http://lisasuosuo.cn/" target="_blank">suosuo</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<p class="footer-class">Copyright &copy; caonuan.science</p>
		</div>
</body>
</html>