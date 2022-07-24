<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>购物车</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        function pNum(pid, p, no) {
            let nums = $("#num_count" + no).val();
            $.ajax({
                url: "updateCartNum?pid=" + pid + "&num=1&price=" + p,
                method: "get",
                success: function () {
                    location.href = "getCart";
                },
                error: function () {
                    alert("服务器异常");
                }
            })
        }

        function mNum(pid, p, no) {
            let num = -1; //数量
            let nums = $("#num_count" + no).val();
            if (Number(nums) <= 1) {
                if (confirm("确认要删除吗?")) {
                    num = 0;
                } else {
                    return;
                }
            }
            $.ajax({
                url: "updateCartNum?pid=" + pid + "&num=" + num + "&price=" + p,
                method: "get",
                success: function () {
                    location.href = "getCart";
                },
                error: function () {
                    alert("服务器异常");
                }
            })
        }

        function clearCart() {
            if (confirm("确认要删除吗")) {
                location.href = "CartServlet?method=clearCart";
            }
        }

        function delCart(cid) {
            if (confirm("是否要删除该商品?")) {
                location.href = "CartServlet?method=delete&cid=" + cid;
            }
        }

        function sub(cid, cNum, cPrice) {
            if (cNum <= 1) {
                alert("数量不能小于1");
            } else {
                cNum--;
                location.href = "CartServlet?method=update&cid=" + cid + "&cNum=" + cNum + "&cPrice=" + cPrice;
            }
        }

        function add(cid, cNum, cPrice) {
            cNum++;
            location.href = "CartServlet?method=update&cid=" + cid + "&cNum=" + cNum + "&cPrice=" + cPrice;
        }
    </script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp" %>
<div class="container" style="background-color: white;">

    <c:if test="${empty list}">
        <h3 align="center">购物车空空如也返回主页购物吧<a href="${pageContext.request.contextPath}/index.jsp">跳转主页</a></h3>
    </c:if>
    <c:if test="${!empty list}">
        <div class="row" style="margin-left: 40px">
            <h3>我的购物车<small>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</small></h3>
        </div>
        <div class="row" style="margin-top: 40px;">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>序号</th>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>
                    <c:set value="0" var="sum"/>
                    <c:forEach items="${list}" var="c" varStatus="i">
                        <tr>
                            <th>${i.count}</th>
                            <th>${c.product.pName}</th>
                            <th>${c.product.pPrice}</th>
                            <th width="100px">
                                <div class="input-group">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button"
                                            onclick="sub(${c.cId}, ${c.cNum},${c.product.pPrice})">-</button>
		 						</span>
                                    <input type="text" class="form-control" id="num_count${i.count}" value="${c.cNum}"
                                           readonly="readonly" style="width:40px">
                                    <span class="input-group-btn">
		 							<button class="btn btn-default" type="button"
                                            onclick="add(${c.cId}, ${c.cNum}, ${c.product.pPrice})">+</button>
		 						</span>
                                </div>
                            </th>
                            <th>¥&nbsp;${c.cCount }</th>
                            <th>
                                <button type="button" class="btn btn-default" onclick="delCart(${c.cId})">删除
                                </button>
                            </th>
                        </tr>
                        <c:set var="sum" value="${sum + c.cCount}"/>
                    </c:forEach>
                </table>
            </div>
        </div>
    </c:if>
    <hr>
    <div class="row">
        <div class="pull-right" style="margin-right: 40px;">
            <div>
                <c:if test="${!empty list}">
                    <a id="removeAllProduct" href="javascript:clearCart()" class="btn btn-default btn-lg" >清空购物车</a>
                </c:if>

                &nbsp;&nbsp;
                <c:if test="${!empty list}">
                    <a href="${pageContext.request.contextPath}/OrderServlet?method=preView&uid=${loginUser.id}" class="btn  btn-danger btn-lg">订单预览</a>
                </c:if>
            </div>
            <br><br>
            <div style="margin-bottom: 20px;">
                商品金额总计：<span id="total" class="text-danger"><b>￥&nbsp;&nbsp;${sum}</b></span>
            </div>
        </div>
    </div>
</div>


<!-- 底部 -->
<%@ include file="footer.jsp" %>

</body>
</html>