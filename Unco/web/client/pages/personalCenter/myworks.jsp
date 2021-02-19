<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@include file="/client/pages/common/head.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/iconfont1.css">
    <link type="text/css" rel="stylesheet" href="static/css/common.css">
    <link type="text/css" rel="stylesheet" href="static/css/works.css">
    <link type="text/css" rel="stylesheet" href="static/css/footer.css">
    <link type="text/css" rel="stylesheet" href="static/css/top.css">
    <link type="text/css" rel="stylesheet" href="static/css/modal.css">
    <title>${sessionScope.user.name}的作品</title>
</head>
<body style="background: #f2f3f5">
    <%--引用菜单文件--%>
    <%@include file="/client/pages/common/menu.jsp"%>
    <%--页面主体--%>
    <div class="author-main">
        <iframe class="if_view" src="test/index.html" frameborder="0" scrolling="no" width="60%" height="80%">
        </iframe>
        <div class="author clearfix">
            <div class="author_top">
                <a href="#">
                    <img src="img/por01.jpg" alt="">
                </a>
                <a href="#">${sessionScope.user.username}</a>
                <div class="fans">
                    <span>粉丝:471</span>
                    <span>关注:32</span>
                </div>
                <a href="#" class="iconfont icon-zan"> 1998</a>
                <a href="#comment" class="iconfont icon-pinglun"> 196</a>
                <a class="iconfont icon-lll"> 7000</a>
                <br />
                <a href="#" class="follow">关注</a>
                <a href="#" class="follow">私信</a>
            </div>
        </div>

        <div class="other">
            <h3>评论：</h3>
            <hr></hr>
            <div id="comment">
                <textarea name="comment" id="text-com" class="comment" maxlength="200" placeholder="发表你的评论(请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反动的言论，且字数不得超过200)"></textarea>
                <input type="submit" name="comment" class="subm" value="发表评论" />
            </div>
            <div class="commuts">
                <ul class="commuts-list">
                    <li>
                        <img src="img/por01.jpg" class="com-list-img clearfix" alt="">

                        <div class="con-user clearfix">
                            <a href="#">username</a>

                            <p>这里是评论内容</p>
                            </br>
                            <p>2018年7月3日</p>
                        </div>
                        <span class="hf">
                            <a href="#">回复 </a>
                            <a href="#">举报</a>
                        </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="static/js/commuts.js"></script>

    <%--页脚引用--%>
    <%@include file="/client/pages/common/footer.jsp"%>

</body>

</html>