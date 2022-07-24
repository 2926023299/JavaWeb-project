<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/login2.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<title>头部</title>
	<script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/TypeServlet?method=findAll",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    for (var i in data) {
                        var a = $("<a id='type' href='${pageContext.request.contextPath}/ProductServlet?method=show&tid=" + data[i].tId + "'>" + data[i].tName + "</a>");
                        $("#goodsType").append(a);
                    }
                },
                error: function () {
                    alert("失败");
                }
            })
        })
	</script>
</head>
<body style="background-color: #FDFDFDFF">
<div id="top">
	<div id="topdiv">
            <span>
                <a href="index.jsp" id="a_top" target="_blank">华为商城</a>
            </span>

		<span style="float:right">
           		<c:if test="${empty loginUser}">
					<a href="login.jsp" id="a_top">登录</a>
					<li>|</li>
					<a href="register.jsp" id="a_top">注册</a>
				</c:if>
       			<c:if test="${not empty loginUser}">
					<a href="AddressServlet?method=show" id="a_top">${loginUser.username}</a>
					<li>|</li>
					<a href="UserServlet?method=logOut" id="a_top">注销</a>
					<li>|</li>
					<a href="OrderServlet?method=show" id="a_top">我的订单</a>
					<li>|</li>
					<a href="AddressServlet?method=show" id="a_top">个人中心</a>
				</c:if>
            </span>
	</div>
</div>
<div id="second" style="display: flex; justify-content: space-between; align-self: center; border-radius: 25px">
		<div style="width: 200px; height:66px;" onclick="location.href='index.jsp'"><a href="index.jsp" id="seimg" style=" margin-top:17px;"><img id="gif" src="image/logo.jpg" width="180" height="66"/></a></div>
		<div style="display: flex; justify-content: center; align-self: center">
			<p id="goodsType"></p>
		</div>
		<div id="cart" style="display: flex; justify-content: center; align-self: center; margin-right: 30px"><a href="${pageContext.request.contextPath}/CartServlet?method=show&uid=${loginUser.id}" id="shorpcar">购物车</a></div>
</div>
</body>
</html>