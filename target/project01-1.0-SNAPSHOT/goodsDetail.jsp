<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商品详情页</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <div class="row" style="display: flex; justify-content: center;">
        <div class="col-xs-6 col-md-6" style="width: 400px">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}image/goodsImgs/${product.pImage}" width="350px" height="440"
                     alt="${product.pName}"/>
            </a>
        </div>
        <div style="margin-left: 30px">
            <h1>${product.pName}</h1>
                <div style="width: 500px; height:50px; background-color: #f3f3f4; display: flex; flex-direction: column; justify-content: center">
                    <div style="margin-left: 15px">
                        <span style="font-size: 16px; color: #3a3a3a">价&nbsp;&nbsp;&nbsp;格:&nbsp;&nbsp;&nbsp;</span><span style="color: darkred">${product.pPrice}</span>
                    </div>
                    <div style="margin-left: 15px">
                        <span style="font-size: 16px; color: #3a3a3a">促&nbsp;&nbsp;&nbsp;销:&nbsp;&nbsp;&nbsp;</span><span style="color: #959292;font-size: 12px">购买即赠送商城积分，积分可抵现~</span>
                    </div>
                </div>

                <hr style="background-color: #a9a9a9;">

                <div style="width: 500px; height:50px; display: flex; flex-direction: column; justify-content: center">
                    <div>
                        <span style="font-size: 13px; color: #3a3a3a">服务说明:&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size: 12px">已满48元包邮,由华为终端提供商品发货开票及售后服务</span></span>
                    </div>
                    <div>
                        <span style="font-size: 13px; color: #3a3a3a">商品编号:&nbsp;&nbsp;&nbsp;&nbsp;</span><span style="color: #959292;font-size: 12px">${product.pId}</span>
                    </div>
                </div>

                <hr style="background-color: #a9a9a9;">
                <p>上市时间:&nbsp;&nbsp;&nbsp;${product.pTime}</p>
                <p>热度:&nbsp;&nbsp;&nbsp;
                    <c:forEach begin="1" end="${product.pState}">
                        <img src="image/star_red.gif" alt="star"/>
                    </c:forEach>
                </p>
                <p>详细介绍:</p>
                <p>&nbsp;&nbsp;${product.pInfo}</p>
                <a href="${pageContext.request.contextPath}/CartServlet?method=create&pid=${product.pId}"
                   class="btn btn-warning" id="click" >加入购物车&nbsp;&nbsp;&nbsp;<span
                        class="glyphicon glyphicon-shopping-cart" ></span></a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 底部 -->
<%@ include file="footer.jsp" %>


</body>
</html>