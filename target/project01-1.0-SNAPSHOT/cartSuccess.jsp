<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<title>购物车</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
<hr>
	<div class="row" style="width: 30%;margin: 0 auto;padding-top: 20px">
		<div class="panel panel-success">
			<div class="panel-body">
			    <h3 class="text-default"><span class="glyphicon glyphicon-ok-sign"></span>&nbsp;&nbsp;&nbsp;&nbsp;添加购物车成功!!</h3>
				<hr>
				<a href="${pageContext.request.contextPath}/CartServlet?method=show&uid=${loginUser.id}" class="btn btn-primary">查看购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/" class="btn btn-default">继续购物</a>
			</div>
		</div>
		
	</div>
	
</div>

<%@ include file="footer.jsp" %>
</body>
</html>