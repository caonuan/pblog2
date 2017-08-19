<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
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
<%@include file="../bottom_tags.jsp" %>
</body>
</html>