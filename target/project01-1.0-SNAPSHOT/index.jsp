<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/login2.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>

	<title>华为首页</title>
</head>
<body style="background-color: #F3F3F4FF">
<%@ include file="header.jsp" %>
<!--网站中间内容开始-->
<div id="thred">
	<img src="image/banner2.jpg" width="1230" height="460"/>
</div>
<div id="forth">
	<img src="image/banner3.jpg" width="1230" height="460"/>
</div>
<div id="fifth" style="margin-top: 300px">
	<span id="fif_text">华为最热单品</span>
</div>
<div id="sixth" style="background-color: #ffffff">
            <span style="margin-left:0px; border-top:#ffa500 1px solid">
            	<a href="" id="siximg"><img src="image/index/index_nova9Pro.jpg" width="234" height="234"/></a>
            	<a href="" id="na">华为 nova9Pro</a>
                <p id="pri">7499元起</p>
            </span>
	<span style=" border-top:#008000 1px solid">
            	<a href="" id="siximg"><img src="image/index/index_nova9SE.jpg" width="234" height="234"/></a>
                <a href="" id="na">华为 nova9SE</a>
                <p id="pri">8499元起</p>
            </span>
	<span style="border-top:#0000ff 1px solid">
            	<a href="" id="siximg"><img src="image/index/index_P50.jpg" width="234" height="234"/></a>
                <a href="" id="na">华为 P50</a>
                <p id="pri">6299元起</p>
            </span>
	<span style="border-top:#ff0000 1px solid">
            	<a href="" id="siximg"><img src="image/index/index_P50E.jpg" width="234" height="234"/></a>
                <a href="" id="na">华为 P50E</a>
                <p id="pri">3999元起</p>
            </span>
	<span style="border-top:#008080 1px solid">
            	<a href="" id="siximg"><img src="image/index/index_P50Pro+.jpg" width="234" height="234"/></a>
                <a href="" id="na">华为P50Pro+</a>
                <p id="pri">8988元起</p>
            </span>
</div>
<!-- 底部 -->
<%@ include file="footer.jsp" %>
</body>
</html>