<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/client/pages/common/head.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/css/iconfont1.css">
    <link rel="stylesheet" href="static/css/common.css">
    <link rel="stylesheet" href="static/css/works.css">
    <link rel="stylesheet" href="static/css/footer.css">
    <link rel="stylesheet" href="static/css/upload.css">
    <link rel="stylesheet" href="static/css/modal.css">
    <link rel="stylesheet" href="static/css/top.css">
    <link href="static/img/logo1.png" rel="shortcut icon" />
    <title>${requestScope.author.name}的作品</title>
</head>

<body style="background: #f2f3f5">
    <%--菜单栏页面引用--%>
    <%@include file="/client/pages/common/menu.jsp" %>
   
    <div class="author-main">
        <iframe class="if_view" src="worksServlet?action=showPersonalWorks&author=${requestScope.author.name}" frameborder="0" scrolling="no" width="60%" height="80%"></iframe>
        <div class="author clearfix">
            <div class="author_top">
                <a href="#">
                    <img src="userServlet?action=showHeadImg&id=${sessionScope.user.id}}" alt="">
                </a>
                <a href="worksServlet?action=showPersonalPage&author=${requestScope.author.name}">${requestScope.author.name}</a>
                <div class="fans">
                    <span>粉丝:471</span>
                    <span>关注:32</span>
                </div>
                <a href="#" class="iconfont icon-zan"> 1998</a>
                <a href="#comment" class="iconfont icon-pinglun"> 196</a>
                <a class="iconfont icon-lll"> 7000</a>
                </br>
                <a href="#" class="follow">关注</a>
                <a href="#" class="follow">私信</a>
            </div>
        </div>

        <div class="other">
            <h3>评论：</h3>
            <hr></hr>
            <div id="comment">
                <textarea name="comment" id="text-com" class="comment" maxlength="200" placeholder="发表你的评论(请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反动的言论，且字数不得超过200)"></textarea>
                <c:if test="${empty user}"> 
                <input type="hidden" id="UN" value="null"/>
                 </c:if>
                <input type="submit" name="comment" class="subm" value="发表评论" />
            </div>

            <div class="commuts">
                <ul class="commuts-list">
                    <li>
                        <img src="static/img/por01.jpg" class="com-list-img clearfix" alt="">

                        <div class="con-user clearfix">
                            <a href="#">username</a>

                            <p>这里是评论内容</p>
                            </br>
                            <p>2018年7月3日</p>
                        </div>
                        <span class="hf">
                            <a href="#">回复 </a>
                            <a href="#"> 举报</a>
                        </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <script src="static/js/modal.js"></script>
    <%--页脚引用--%>
    <%@include file="/client/pages/common/footer.jsp"%>
    <script type="text/javascript" src="static/js/commuts.js"></script>
</body>

</html>