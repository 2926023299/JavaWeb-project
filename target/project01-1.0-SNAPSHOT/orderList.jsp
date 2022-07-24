<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>订单列表</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>

	<style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;

        }

        tr:hover {
            background-color: #f0f0f1;
        }

        /*tr:nth-child(even) {
            background-color: #f2f2f2;
        }*/

        th {
            color: #666666;
        }
	</style>
	<script type="text/javascript">
        function showOrder(orderId) {
            location.href = "${pageContext.request.contextPath}/OrderServlet?method=getOrderDetail&oid=" + orderId;
        }

        function changeStatus(orderId, status) {
            location.href = "${pageContext.request.contextPath}/OrderServlet?method=changeStatus&oid=" + orderId + "&status=" + status;
        }

        function delOrder(orderId) {
            if (confirm("确定要删除该订单吗？")) {
                location.href = "${pageContext.request.contextPath}/OrderServlet?method=delOrder&oid=" + orderId;
			}
		}
	</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp" %>
<div class="container" style="background-color: white; margin-top: 10px;
    border-radius: 25px;">
	<div class="row" style="margin-left: 40px">
		<h3>我的订单列表&nbsp;&nbsp;
			<small>温馨提示：<em>${loginUser.username}</em>有<font color="red">${ordersList.size()}</font>个订单</small></h3>
	</div>
	<div class="row" style="margin-top: 40px; margin-bottom: 30px">
		<div class="col-md-12">
			<table>
				<tr style="height: 50px;">
					<th>序号</th>
					<th>订单编号</th>
					<th>总金额</th>
					<th>订单状态</th>
					<th>订单时间</th>
					<th>收货地址</th>
					<th>操作</th>
				</tr>
				</tr>
				<c:if test=" ${empty ordersList}">
					<h3>您还没有订单，请先去购物></h3>
				</c:if>
				<c:forEach items="${ordersList}" var="order" varStatus="i">
					<tr style="height: 70px;">
						<td>${i.count}</td>
						<td>${order.oId}</td>
						<td>${order.oCount}</td>
						<td>
							<font color="red">
								<c:if test="${order.oState eq 1 }">
									未支付
								</c:if>
								<c:if test="${order.oState eq 2 }">
									已支付,代发货
								</c:if>
								<c:if test="${order.oState eq 3 }">
									已发货,待收货
								</c:if>
								<c:if test="${order.oState eq 4 }">
									订单完成
								</c:if>
							</font>
						</td>
						<td>${order.oTime}</td>
						<td>${order.address.aDetail}</td>
						<td>
							<button type="button" class="btn btn-sm" onclick="showOrder('${order.oId}')">
								订单详情
							</button>
							<c:if test="${order.oState eq 3 }">
								<button type="button" class="btn btn-warning btn-sm"
										onclick="changeStatus('${order.oId}', '4')">确认收货
								</button>
							</c:if>
							<c:if test="${order.oState eq 1}">
								<button type="button" class="btn btn-danger btn-sm"
										onclick="delOrder('${order.oId}')">删除
								</button>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>

			<%--<table id="tb_list" class="table table-striped table-hover table-bordered table-condensed">
			<tr>
				<th>序号</th>
				<th>订单编号</th>
				<th>总金额</th>
				<th>订单状态</th>
				<th>订单时间</th>
				<th>收货地址</th>
				<th>操作</th>
			</tr>
				<c:if test=" ${empty ordersList}">
					<h3>您还没有订单，请先去购物></h3>
				</c:if>
			<c:forEach items="${ordersList}" var="order" varStatus="i">
				<tr>
					<th>${i.count}</th>
					<th>${order.oId}</th>
					<th>${order.oCount}</th>
					<th>
						<font color="red">
							<c:if test="${order.oState eq 1 }">
								未支付
							</c:if>
							<c:if test="${order.oState eq 2 }">
								已支付,代发货
							</c:if>
							<c:if test="${order.oState eq 3 }">
								已发货,待收货
							</c:if>
							<c:if test="${order.oState eq 4 }">
								订单完成
							</c:if>
						</font>
					</th>
					<th>${order.oTime}</th>
					<th>${order.address.aDetail}</th>
					<th>
						<button type="button" class="btn btn-danger btn-sm" onclick="showOrder('${order.oId}')">订单详情</button>
						<c:if test="${order.oState eq 3 }">
							<button type="button" class="btn btn-warning btn-sm" onclick="changeStatus('${order.oId}')">确认收货</button>
						</c:if>
					</th>
				</tr>
			</c:forEach>
		</table>--%>
		</div>
	</div>

</div>


<!-- 底部 -->
<%@ include file="footer.jsp" %>

</body>
</html>