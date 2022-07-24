<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>订单详情页</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
        function pay(orderId, money) {
            location.href = "pay.jsp?oid=" + orderId + "&money=" + money;
        }

        function payWeiXin(orderId, money) {
            location.href = "payWeixin.jsp?oid=" + orderId + "&money=" + money;
        }
	</script>
	<style>
        th, td {
            text-align: left;
            padding: 8px;
        }
        tr:hover {background-color: #f0f0f1;}

	</style>
</head>
<%@ include file="header.jsp" %>
<body>
<p align="center" style="font-size: 20px; color: #919191">订&nbsp;&nbsp;单&nbsp;&nbsp;详&nbsp;&nbsp;情</p>
<div class="panel panel-default" style="margin: 0 auto;width: 95%; padding: 15px; background-color: #f7f7f8;">
	<table cellpadding="0" cellspacing="0" align="center" width="100%"
		   class="table table-striped table-bordered table-hover">
		<tr>
			<td>订单编号:</td>
			<td>${orders.oId}</td>
			<td>订单时间:</td>
			<td>${orders.oTime}</td>
		</tr>
		<tr>
			<td>收件人:</td>
			<td>${orders.address.aName}</td>
			<td>联系电话:</td>
			<td>${orders.address.aPhone}</td>
		</tr>
		<tr>
			<td>送货地址:</td>
			<td>${orders.address.aDetail}</td>
			<td>总价:</td>
			<td>${orders.oCount}</td>
		</tr>
		<tr>
			<td align="center">商品列表:</td>
			<td colspan="3">
				<table style="border-collapse: collapse; width: 100%;">
					<tr style="height: 50px; color: #666666; ">
						<th>序号</th>
						<th>商品封面</th>
						<th>商品名称</th>
						<th>商品评分</th>
						<th>商品日期</th>
						<th>商品单价</th>
						<th>购买数量</th>
						<th>小计</th>
					</tr>
					<c:forEach items="${orders.items}" var="item" varStatus="i">
						<tr align="center" style="height: 70px;">
							<th>${i.count}</th>
							<th>
								<img src="${pageContext.request.contextPath}/image/goodsImgs/${item.product.pImage}"
									 width="50px" height="50px">
							</th>
							<th>${item.product.pName}</th>
							<th>${item.product.pState}</th>
							<th>${item.product.pTime}</th>
							<th>${item.product.pPrice}</th>
							<th>${item.iNum}</th>
							<th>${item.iCount}</th>
						</tr>
					</c:forEach>
				</table>

				<%--<table align="center" cellpadding="0" cellspacing="0" width="100%"
					   class="table table-striped table-bordered table-hover">
					<tr align="center" class="info">
						<th>序号</th>
						<th>商品封面</th>
						<th>商品名称</th>
						<th>商品评分</th>
						<th>商品日期</th>
						<th>商品单价</th>
						<th>购买数量</th>
						<th>小计</th>
					</tr>
					<c:forEach items="${orders.items}" var="item" varStatus="i">
						<tr align="center">
							<th>${i.count}</th>
							<th>
								<img src="${pageContext.request.contextPath}/image/goodsImgs/${item.product.pImage}"
									 width="50px" height="50px">
							</th>
							<th>${item.product.pName}</th>
							<th>${item.product.pState}</th>
							<th>${item.product.pTime}</th>
							<th>${item.product.pPrice}</th>
							<th>${item.iNum}</th>
							<th>${item.iCount}</th>
						</tr>
					</c:forEach>
				</table>--%>
			</td>
		</tr>
		<tr></tr>
		<%--<tr>
			<td align="right" colspan="4" style="margin-right: 40px;">
				<a href="${pageContext.request.contextPath }/OrderServlet?method=show"
				   class="btn btn-danger btn-sm">返回订单列表</a>
				&nbsp;&nbsp;
				<c:if test="${orders.oState eq 1 }">
					<button type="button" onclick="pay('${orders.oId}','${orders.oCount}')"
							class="btn btn-warning btn-sm">易付宝支付
					</button>
					&nbsp;&nbsp;
					<button type="button" onclick="payWeiXin('${orders.oId}','${orders.oCount}')"
							class="btn btn-success btn-sm">微信支付
					</button>
				</c:if>
			</td>
		</tr>--%>
	</table>
	<div style="width: 400px; margin: 20px auto 0;" >
		<a href="${pageContext.request.contextPath }/OrderServlet?method=show"
		   class="btn btn-info btn-sm">返回订单列表</a>
		&nbsp;&nbsp;
		<c:if test="${orders.oState eq 1 }">
			<button type="button" onclick="pay('${orders.oId}','${orders.oCount}')"
					class="btn btn-sm btn-primary">银行卡支付
			</button>
			&nbsp;&nbsp;
			<button type="button" onclick="payWeiXin('${orders.oId}','${orders.oCount}')"
					class="btn btn-success btn-sm">微信支付
			</button>
		</c:if>
	</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>