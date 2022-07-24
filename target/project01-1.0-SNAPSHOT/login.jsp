<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>

	<title>登录</title>
	<script type="text/javascript">
        $(function () {
            //1.验证用户名是否存在
            $("#username").change(function () {
                $.get("checkUserName", "username=" + this.value, function (data) {
                    if (data == 0) {
                        $("#nameMsg").html("用户名不存在").css("color", "red");
                    } else {
                        $("#nameMsg").html("");
                    }
                })
            });
            //2.点击验证码 跟新验证码
            $("#pagecode").click(function () {
                $("#pagecode").attr("src", "code?method=createCode&t=" + Math.random());
            });
            //3.验证输入的验证码 是否正确
            $("#vcode").change(function () {
                $.get("checkCode", "code=" + this.value, function (data) {
                    if (data == 0) {
                        $("#checkMsg").html("<font color='green'>OK</font>");
                        $("#btn").removeAttr("disabled");
                    } else {
                        $("#checkMsg").html("<font color='red'>ERROR</font>");
                        $("#pagecode").attr("src", "code?method=createCode&t=" + Math.random());
                        $("#btn").Attr("disabled", true);
                    }
                })
            });
            //4.两周以内自动登录  友好提示
            $("#autoLogin").click(function () {
                if (this.checked) {
                    $("#autoLoginMsg").html("外网注意").css("color", "red");
                } else {
                    $("#autoLoginMsg").html("");
                }
            })
        })
	</script>
</head>
<body style="background-color: #fdfdfd">
<!-- login -->

<div style="width: 100%; background-color: #eff0f0;height: 70px; margin: 0 auto;">
	<img src="image/topLogo.jpg" alt="logo">
</div>

<div style="width: 200px;margin: 50px auto 30px; text-align: center">
	<p style="color: #191919; font-size: 30px">华为账号登录</p>
</div>
<div style="width: 100%; height: 500px">
	<div style="width: 1000px; height: 500px; margin: 0 auto;display: flex; justify-content: space-between" >
        <div style="width: 500px;">
			<div>
				<img src="image/Login_left.jpg" alt="">
			</div>
		</div>
        <div style="width: 1px; height: 500px;"></div>
        <form method="post" action="UserServlet?method=login" class="form center" id="userLogin">
            <div class="login">
                <div class="login_center">
                    <div class="login_top">
                        <div class="left fl"><span style="color: #606060">用户登录</span></div>
                        <div class="clear"></div>
                        <div class="xian center"></div>
                    </div>
                    <div class="login_main center" style="width: 350px;
    margin-left: 40px;">
                        <div class="username">
                            <div class="left fl"><span style="color: #606060">用户名:&nbsp;</span></div>
                            <div class="right fl">
                                <input class="shurukuang" type="text" name="username" id="username" placeholder="请输入你的用户名"/>
                                <label id="nameMsg"></label>
                            </div>
                        </div>
                        <div class="username">
                            <div class="left fl"><span style="color: #606060">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</span></div>
                            <div class="right fl">
                                <input class="shurukuang" type="password" name="password" id="pwd" placeholder="请输入你的密码"/>
                            </div>
                        </div>
                        <div class="username">
                            <div class="left fl"><span style="color: #606060">验证码:&nbsp;</span></div>
                            <div class="right fl"><input style="width: 70px" class="yanzhengma" name="code" id="vcode"
                                                         type="text"
                                                         placeholder="验证码"/>
                                <img id="pagecode" src="code?method=createCode&t=4"><label id="checkMsg"></label>
                            </div>
                        </div>
                        <div class="username">
                            <input id="autoLogin" name="auto" type="checkbox"/><span style="color: #606060">&nbsp;&nbsp;两周以内自动登录</span>
                            <span id="autoLoginMsg"></span>
                        </div>
                        <div class="login_submit">
                            <input class="submit" type="submit" name="submit" value="立即登录" id="btn">
                        </div>
                        <div style="margin: 0 auto">
                            <span style="color: #606060">您还不是我们的用户？</span>
                            <a href="${pageContext.request.contextPath }/register.jsp" target="_self" id="register"><span
                                    style="color: #0f32be">立即注册</span></a></div>
                    </div>

                    <c:if test="${sessionScope.msg != null}">
                        <span style="color:#4058f1; font-size: 14px; ">${msg}</span>
                    </c:if>
                </div>
            </div>

        </form>
	</div>
</div>

<footer>
	<div class="copyright">简体 | 繁体 | English | 常见问题</div>
	<div class="copyright">华为公司版权所有-京ICP备10046444-<img src="./image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号
	</div>
</footer>
</body>
</html>