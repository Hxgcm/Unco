<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal">
    <div class="msg-box clearfix">
        <a class="close" href="#">×</a>
        <div class="modal_top">
            <p class="header">登录</p>
            <span>还没有账号？</span>
            <a href="#" class="modal-eroll">马上注册</a>
        </div>

        <div class="modal_login">
            <input type="text" name="username" class="textfiled" placeholder="用户名/邮箱/手机号" />
            <input type="password" name="password" class="textfiled" placeholder="输入密码" />
        </div>
        <input class="dl" type="submit" value="登录" />
        <input type="hidden" name="action" value="Login">
        <div class="qw">
            <p>第三方登陆</p>
            <a href="#" class="iconfont icon-qq"></a>
            <a href="#" class="iconfont icon-weibo"></a>
            <a href="#" class="iconfont icon-weixin"></a>
        </div>
    </div>
</div>