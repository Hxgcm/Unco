<%--
  Created by IntelliJ IDEA.
  User: 79367
  Date: 2020/6/17
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="static-nav clear">
<!--  logo  -->
<div class="logo">
    <a href="#">
        <img src="static/img/logo1.png" alt="">
    </a>
</div>
<!--  首页菜单  -->
<div class="nav-menu">
    <ul>
        <a href="indexServlet/action=indexPage"><li>首 页</li></a>
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
</div>