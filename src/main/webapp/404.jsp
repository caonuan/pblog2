<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
<title>404 not found!</title>
</head>
<body>
	<style>
rect {
	fill: #fff;
	stroke: #000;
}

pre {
	overflow-x: hidden;
}

.col-md-7 {
	top: 5px;
}

svg {
	position: absolute;
	margin-left: -200px;
	margin-top: 50px;
}

.maindiv {
	overflow: hidden;
}
</style>
	<div class="maindiv">
		<div style="margin: 0 auto;" class="col-md-7">
			<pre>

                       444444444       000000000            444444444   
                      4::::::::4     00:::::::::00         4::::::::4  
                     4:::::::::4   00:::::::::::::00      4:::::::::4  
                    4::::44::::4  0:::::::000:::::::0    4::::44::::4  
                   4::::4 4::::4  0::::::0   0::::::0   4::::4 4::::4  
                  4::::4  4::::4  0:::::0     0:::::0  4::::4  4::::4  
                 4::::4   4::::4  0:::::0     0:::::0 4::::4   4::::4  
                4::::444444::::4440:::::0 000 0:::::04::::444444::::444
                4::::::::::::::::40:::::0 000 0:::::04::::::::::::::::4
                4444444444:::::4440:::::0     0:::::04444444444:::::444
                          4::::4  0:::::0     0:::::0          4::::4  
                          4::::4  0::::::0   0::::::0          4::::4  
                          4::::4  0:::::::000:::::::0          4::::4  
                        44::::::44 00:::::::::::::00         44::::::44
                        4::::::::4   00:::::::::00           4::::::::4
                        4444444444     000000000             4444444444

         ,-----.         _   _     _           _                 _     _               _   
       ,'_/_|_\_`.      | |_| |__ (_)___   ___| |__   ___  _   _| | __| |  _ __   ___ | |_ 
      /<<::8[O]::>\     | __| '_ \| / __| / __| '_ \ / _ \| | | | |/ _` | | '_ \ / _ \| __|
     _|-----------|_    | |_| | | | \__ \ \__ \ | | | (_) | |_| | | (_| | | | | | (_) | |_ 
 :::|  | ====-=- |  |::: \__|_| |_|_|___/ |___/_| |_|\___/ \__,_|_|\__,_| |_| |_|\___/ \__|
 :::|  | -=-==== |  |:::                                                                         
 :::\  | ::::|()||  /::: _                                                          
 ::::| | ....|()|| |::::| |__   __ _ _ __  _ __   ___ _ __       _____   _____ _ __ 
     | |_________| |    | '_ \ / _` | '_ \| '_ \ / _ \ '_ \     / _ \ \ / / _ \ '__|
     | |\_______/| |    | | | | (_| | |_) | |_) |  __/ | | |_  |  __/\ V /  __/ |   
    /   \ /   \ /   \   |_| |_|\__,_| .__/| .__/ \___|_| |_( )  \___| \_/ \___|_|   
    `---' `---' `---'                   |_|   |_|              |/                       


    </pre>
		</div>
		<div class="col-md-5">
			<svg width="960" height="500"> <defs> <clipPath id="clip-upper">
			<rect width="960" height="305" x="-480" y="-305"></rect> </clipPath> <clipPath
				id="clip-lower"> <rect width="960" height="195" x="-480" y="0"></rect>
			</clipPath> </defs> <g clip-path="url(#clip-upper)" transform="translate(480,305)"></g> <g
				clip-path="url(#clip-lower)" transform="translate(480,305)"></g> </svg>
			<script src="//d3js.org/d3.v3.min.js"></script>
			<script>
				var width = 960, height = 500, triangleSize = 400, squareCount = 71, squareSize = 90, speed = .08;

				var square = d3.selectAll("g").selectAll("g").data(
						function(d, i) {
							return i ? [ 0, 1, 2 ] : [ 2, 0, 1 ];
						}).enter().append("g").attr(
						"transform",
						function(i) {
							return "rotate(" + (i * 120 + 60) + ")translate(0,"
									+ -triangleSize / Math.sqrt(12) + ")";
						}).selectAll("rect").data(d3.range(squareCount))
						.enter().append("rect").datum(function(i) {
							return i / squareCount;
						}).attr({
							width : squareSize,
							height : squareSize,
							x : -squareSize / 2,
							y : -squareSize / 2
						});

				d3.timer(function(elapsed) {
					square.attr("transform", function(t) {
						return "translate(" + (t - .5) * triangleSize
								+ ",0)rotate(" + (t * 120 + elapsed * speed)
								+ ")";
					});
				});
			</script>
		</div>
	</div>
</body>
</html>