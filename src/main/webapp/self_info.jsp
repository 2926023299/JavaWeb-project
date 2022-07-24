<%--suppress XmlDuplicatedId --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/login2.css">
	<link rel="stylesheet" href="js/bootstrap.min.css"/>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<title>个人中心-收货地址页面</title>
	<script type="text/javascript">
        function deleteAddr(aId) {
            let res = confirm("是否删除");
            if (res === true) {
                location.href = "AddressServlet?method=delete&aid=" + aId;
            }
        }

        function defaultAddr(aId) {
            var res = confirm("是否设为默认");
            if (res == true) {
                window.location.href = "AddressServlet?method=setDefault&aid=" + aId;
            }
        }
	</script>
</head>
<body>
<%@ include file="header.jsp" %>
<!--网站中间内容开始-->
<div id="dingdanxiangqing_body">
	<div id="dingdanxiangqing_body_big">
		<div id="big_left">
			<p style="font-size:18px;margin-top: 15px">订单中心</p>
			<a id="big_left_a" href="OrderServlet?method=show">我的订单</a><br/>
			<a id="big_left_a" href="${pageContext.request.contextPath}/CartServlet?method=show&uid=${loginUser.id}">我的购物车</a><br/>
			<p style="font-size:18px">个人中心</p>
			<a id="big_left_a" href="">收货地址</a><br/>
		</div>
		<div id="big_right" style="height: 500px;overflow: scroll;">

			<div style="margin:0 20px;">
				<h3>收货地址</h3>
				<hr>
				<table class="table table-striped table-hover table-bordered">
					<tr>
						<th>序号</th>
						<th>收件人</th>
						<th>手机号</th>
						<th>地址</th>
						<th>操作</th>
					</tr>
					<c:forEach var="address" items="${list}" varStatus="i">
						<tr>
							<Td>${i.count}</Td>
							<td>${address.aName}</td>
							<td>${address.aPhone}</td>
							<td>${address.aDetail}</td>
							<td>
								<button onclick="deleteAddr(${address.aId})" class="btn btn-danger btn-sm">删除</button>&nbsp;&nbsp;
								<button class="btn btn-default btn-sm" data-toggle="modal"
										data-target="#myModal${address.aId}">修改
								</button>&nbsp;&nbsp;
								<!-- 弹出模态框 -->
								<div class="modal fade" tabindex="-1" role="dialog" id="myModal${address.aId}">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
													<span>&times;</span>
												</button>
												<h4 class="modal-title">修改地址</h4>
											</div>
											<form action="AddressServlet?method=update" method="post"
												  class="form-horizontal">
												<div class="motal-body">
													<div class="form-group">
														<label class="col-sm-2 control-label">收件人</label>
														<div class="col-sm-10">
															<input type="hidden" name="aId" value="${address.aId}">
															<input type="hidden" name="aState" value="${address.aState}">
															<input type="text" name="aName" class="form-control"
																   value="${address.aName}">
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">电话</label>
														<div class="col-sm-10">
															<input type="text" name="aPhone" class="form-control"
																   value="${address.aPhone}">
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">收件人</label>
														<div class="col-sm-10">
															<input type="text" name="aDetail" class="form-control"
																   value="${address.aDetail}">
														</div>
													</div>

												</div>
												<div class="motal-footer">
													<button type="submit" class="btn btn-primary">修改</button>
												</div>
											</form>
										</div>
									</div>
								</div>

								<c:if test="${address.aState==0}">
								<button onclick="defaultAddr(${address.aId})" class="btn btn-primary btn-sm">设为默认
								</button>
								</c:if>
								<c:if test="${address.aState==1}">
									<span class="badge" style="background-color:red;">默认</span>
								</c:if>
								<c:if test="${address.aState==0}">
									<span class="badge">普通</span>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br>
			<div class="container" style="width:960px;">

				<form action="AddressServlet?method=addAddress" method="post" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 form-label">收件人</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="aName"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 form-label">手机号</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="aPhone"/>
						</div>
					</div>
					<div class="form-group">
						<label class="form-label">详细地址</label>
						<textarea rows="3" class="form-control" name="aDetail"></textarea>
					</div>
					<div class="form-group col-md-12">
						<input type="submit" class="btn btn-primary" value="添加地址">
					</div>
					<input type="hidden" value="${loginUser.id}" name="uId">
				</form>
			</div>
		</div>
	</div>
</div>

<!-- 底部 -->
<%@ include file="footer.jsp" %>

</body>
</html>