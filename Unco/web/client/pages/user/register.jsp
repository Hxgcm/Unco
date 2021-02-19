<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal2">
    <div class="msg-box2 clearfix">
        <a class="close2" href="#">×</a>
        <div class="modal_top">
            <p class="header">注册</p>
            <span>已有账号？</span>
            <a href="#" class="modal-log">马上登陆</a>
        </div>
        <div class="modal_login">
            <input type="text" name="username" class="textfiled" placeholder="用户名/邮箱" />
            <input type="text" name="name" class="textfiled" placeholder="昵称" />
            <input type="password" name="password" class="textfiled" placeholder="输入密码" />
            <input type="password" name="password" class="textfiled" placeholder="确认密码" />
            <input type="text" name="code" id="input" class="enroll-code" placeholder="验证码"/>
            <img src="vCode.jpg" class="code" id="code" style="width: 100px; height: 50px">
<%--            <input type="text" id="code" class="code" style="width: 55px" readonly="readonly" />--%>
<%--            <a href="#" onclick="createCode()">刷新验证码</a>--%>
        </div>
        <input class="dl" type="submit" onclick="validate();" value="点击注册" />
        <input type="hidden" name="action" value="addUser">
    </div>
</div>
<%--引用Js处理界面--%>
<script src="static/js/index.js"></script>
<script src="static/js/modal.js"></script>