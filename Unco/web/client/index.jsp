<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@include file="/client/pages/common/head.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/common.css">
    <link type="text/css" rel="stylesheet" href="static/css/view-main.css">
    <link type="text/css" rel="stylesheet" href="static/css/footer.css">
    <link type="text/css" rel="stylesheet" href="static/css/modal.css">
    <link type="text/css" rel="stylesheet" href="static/css/top.css">
    <link type="text/css" rel="stylesheet" href="static/css/iconfont1.css">
    <link href="static/img/logo1.png" rel="shortcut icon" />
    <title>Unco摄影社区</title>
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">

    </script>
</head>

<body>
    <!--  顶部导航栏  -->
    <%@include file="pages/common/mune_nva.jsp"%>
    <!--  主要内容  -->
    <h1 class="img-title">
        <span class="iconfont icon-zan"></span> 每 日 推 荐
        <span class="iconfont icon-zan"></span>
    </h1>
    <div class="exhibition clearfix">
        <!--  作品分栏展示  -->
        <div class="img-tab clearfix" id="mao">
            <ul class="img_column clearfix">
                <c:forEach items="${sessionScope.categoryList}" var="cate" varStatus="status">
                    <li><a class="active" href="#div1">${cate.name}</a></li>
                </c:forEach>
            </ul>
            <ul class="img_content">
                <c:forEach items="${sessionScope.categoryList}" var="category">
                    <li class="active">
                        <c:forEach items="${sessionScope.proImgList}" var="works" varStatus="status">
                            <c:if test="${works.category.equals(category.name) }">
                                <div class="por more_img active" id="div1">
                                    <div class="por_imgs">
                                        <a href="worksServlet?action=autlist&author=${works.author}">
                                            <img src="worksServlet?action=showWorks&id=${works.id}" alt="aaaa"/>
                                        </a>
                                    </div>
                                    <div class="info_shadow">
                                        <a href="worksServlet?action=autlist&author=${works.author}" name="author" class="info_author">作者:${works.author}</a><a href="worksServlet?action=autlist" class="info_icon"><span class="iconfont icon-zan"></span></a>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </li>
                </c:forEach>
            </ul>

        </div>
    </div>
    <!--    技巧分享    -->
    <iframe src="${pageScope.basePath}pages/indexpage/photo_skills.jsp" class="iframe1" frameborder="0" scrolling="no"></iframe>

    <div class="photo_act">
        <h1>最 新 活 动</h1>
        <h2>每月的举办活动和大赛，好照片不再寂寞....</h2>
        <ul class="act_all">
            <li>
                <a href="#">
                    <img src="static/img/act01.jpg" alt="图片找不到了" />
                    <div class="bottom_shadow">
                        <p>趣味话题：雨后初晴</p>
                        <p>4396件作品</p>
                    </div>
                    <div class="reward">
                        <span class="iconfont icon-jiangb"></span>
                        <p> 随 机 现 金 红 包</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="static/img/act01.jpg" alt="" />
                    <div class="bottom_shadow">
                        <p>趣味话题：雨后初晴</p>
                        <p>4396件作品</p>
                    </div>
                    <div class="reward">
                        <span class="iconfont icon-jiangb"></span>
                        <p> 随 机 现 金 红 包</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="static/img/act01.jpg" alt="" />
                    <div class="bottom_shadow">
                        <p>趣味话题：雨后初晴</p>
                        <p>4396件作品</p>
                    </div>
                    <div class="reward">
                        <span class="iconfont icon-jiangb"></span>
                        <p> 随 机 现 金 红 包</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="static/img/act01.jpg" alt="" />
                    <div class="bottom_shadow">
                        <p>趣味话题：雨后初晴</p>
                        <p>4396件作品</p>
                    </div>
                    <div class="reward">
                        <span class="iconfont icon-jiangb"></span>
                        <p> 随 机 现 金 红 包</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="static/img/act01.jpg" alt="" />
                    <div class="bottom_shadow">
                        <p>趣味话题：雨后初晴</p>
                        <p>4396件作品</p>
                    </div>
                    <div class="reward">
                        <span class="iconfont icon-jiangb"></span>
                        <p> 随 机 现 金 红 包</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="static/img/act01.jpg" alt="" />
                    <div class="bottom_shadow">
                        <p>趣味话题：雨后初晴</p>
                        <p>4396件作品</p>
                    </div>
                    <div class="reward">
                        <span class="iconfont icon-jiangb"></span>
                        <p> 随 机 现 金 红 包</p>
                    </div>
                </a>
            </li>
        </ul>
    </div>
    <%--引用页脚--%>
    <%@include file="pages/common/footer.jsp"%>
    <%--用户登录界面--%>
    <form method="post" action="userServlet?action=login" target="_parent" name='theForm' onsubmit="return validate()">
        <%@include file="pages/user/login.jsp" %>
    </form>

    <%--用户注册界面--%>
    <form method="post" action="userServlet?action=register" target="_parent" name='theForm' onsubmit="return validate()">
        <%@include file="pages/user/register.jsp"%>
    </form>
</body>
</html>