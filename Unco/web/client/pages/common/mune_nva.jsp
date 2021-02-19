<!--  顶部导航栏  -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="top">
            <nav class="static-nav clear">
                <!--  logo  -->
                <div class="logo">
                    <a href="#">
                        <img src="static/img/logo1.png" alt="">
                    </a>
                </div>
                <!--  首页菜单  -->
                <div class="nav-menu">
                    <ul>
                        <a href="index.jsp"><li>首 页</li></a>
                        <a href="#"><li>发 现</li></a>
                        <a href="#"><li>活 动</li></a>
                        <a href="#"><li>更 多</li></a>
                    </ul>
                </div>
                <!--  搜索框  -->
                <div class="nav-search">
                    <input type="text" name="nav-search">
                    <a href="#">
                        <span class="iconfont icon-sousuo"></span>
                    </a>
                </div>
                <!--  用户注册登陆  -->
                <c:if test="${not empty sessionScope.user}">
                    <div class="login">
                        <img alt="" src="static/img/por12.jpg">
                        <a href="#" class="user">${sessionScope.user.name}</a>
                        <a class="nav-enroll" href="pages/uploadWork/uploadWork.jsp">发布</a>
                        <a class="nav-login" href="pages/personalCenter/myworks.jsp" >个人中心</a>
                        <a class="nav-login" href="userServlet?action=loginOut">退出</a>
                    </div>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <div class="login">
                        <a href="#" class="nav-login" id="nav-login">登录</a>
                        <a href="#" class="nav-enroll" id="nav-enroll" onclick="createCode()">注册</a>
                    </div>
                </c:if>
    </nav>
    <div class="view-top">
        <p>这是一个仅供学习交流的摄影网站·····</p>
        <span>在这里，发现基于共同兴趣的同好；鼓励原创和分享精神；除了美好的摄影和技能，我们更在意影像背后价值观的认同。</span>
    </div>
</div>