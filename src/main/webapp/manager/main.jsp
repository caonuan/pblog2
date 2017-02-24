<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String manager = (String) session.getAttribute("manager");
	if (manager == null )
		response.sendRedirect(basePath+"/manager/login");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>img/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<title>个人博客管理</title>
</head>
<script type="text/javascript">
	function open1(hrefURL) {
		$("#iframe_1").attr("src", hrefURL);
	}
</script>
<style>
a {
	background-color: transparent
}

a:active {
	outline: 0
}

a:hover {
	outline: 0;
	text-decoration: underline;
}
a, a:visited {
	text-decoration: none;
	color: blue;
}

</style>
<body>
	<div style="margin: 5px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 600px;">
		<div id="p" data-options="region:'west'" title="选项"
			style="width: 30%; padding: 10px">
			<div class="easyui-accordion" style="width: 96%; height: 100%;"
				id="acc">
				<div title="日志管理" style="overflow: auto; padding: 10px;"
					data-options="href:'<%=path%>/manager/manageArticle?page=1',tools:[{
					iconCls:'icon-reload',
					handler:function(){
						var pp = $('#acc').accordion('getSelected'); 
						if (pp){
   						 pp.panel('refresh','<%=path%>/manager/manageArticle?page=1'); 
						}	
					}
				}]">
				</div>
				<div title="相册管理" style="padding: 10px;"
					data-options="href:'<%=path%>/manager/manageAlbum',tools:[{
					iconCls:'icon-reload',
					handler:function(){
						var pp = $('#acc').accordion('getSelected'); 
						if (pp){
   						 pp.panel('refresh','<%=path%>/manager/manageAlbum'); 
						}
					}
				}]"></div>
				<div title="留言管理" style="padding: 10px"
					data-options="href:'<%=path%>/manager/managerNote?page=1',tools:[{
					iconCls:'icon-reload',
					handler:function(){
						var pp = $('#acc').accordion('getSelected'); 
						if (pp){
   						 pp.panel('refresh','<%=path%>/manager/managerNote?page=1'); 
						}
					}
				}]"></div>
			</div>

		</div>
		<div data-options="region:'center'" title="操作">
			<iframe style="width: 97%; height: 100%; margin: 1%" id="iframe_1"></iframe>
		</div>
	</div>
	<script type="text/javascript">
		//panel被选择时刷新panel
		$('#acc').accordion({
			onSelect:function(title,index){
				if(index==0){
					var pp = $('#acc').accordion('getSelected'); 
					pp.panel('refresh','<%=path%>/manager/manageArticle?page=1'); 
				}
				if(index==1){
					var pp = $('#acc').accordion('getSelected'); 
					pp.panel('refresh','<%=path%>/manager/manageAlbum'); 
				}
				if(index==2){
					var pp = $('#acc').accordion('getSelected'); 
					pp.panel('refresh','<%=path%>/manager/managerNote?page=1');
						}
					}
				});
	</script>
</body>
</html>