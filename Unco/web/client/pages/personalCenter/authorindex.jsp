<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@include file="/client/pages/common/head.jsp"%>
    <link rel="stylesheet" href="static/css/author.css">
    <link rel="stylesheet" href="static/css/view-main.css">
    <link rel="stylesheet" href="static/css/common.css">
    <link rel="stylesheet" href="static/css/footer.css">
    <link rel="stylesheet" href="static/css/top.css">
    <title>${sessionScope.user.name}的作品展示</title>
</head>
<body>
    <div class="aut-top clearfix">
        <div class="aut-top-user clearfix">
            <img src="static/img/por11.jpg" class="head-img" alt="">
            <p>${sessionScope.user.name}<a href="#">关注他</a></br>
                <span>关注:888</span>
                <span>粉丝:999</span>
            </p>
        </div>
        <button class="aut-btn clearfix">点击分享</button>
    </div>
    <div class="aut-main">
        <h1>作品展览</h1>
        <hr></hr>
        <ul class="img_content" style="margin-left: 8vw">
                <li class="active">
                    <c:forEach items="${requestScope.worksList}" var="works">
                        <div class="por more_img active">
                            <div class="por_imgs">
                                <a href="#">
                                    <img src="worksServlet?action=showWorks&id=${works.id}" alt="图片丢失">
                                </a>
                            </div>
                            <div class="info_shadow">
                                <a href="#" class="info_author">${requestScope.authorName}</a>
                                <a href="#" class="info_icon">
                                    <span class="iconfont icon-zan"></span>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="por more_img active">
                        <div class="por_imgs">
                            <a href="#">
                                <img src="img/nat16.jpg" alt="">
                            </a>
                        </div>
                        <div class="info_shadow">
                            <a href="#" class="info_author">作者:B-uncle</a>
                            <a href="#" class="info_icon">
                                <span class="iconfont icon-zan"></span>
                            </a>
                        </div>
                    </div>
                </li>
            </ul>

    </div>

    <%--页脚的引用--%>
    <%@include file="/client/pages/common/footer.jsp" %>
</body>

</html>