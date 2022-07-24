<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>商品列表页</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body style="background-color: #f3f3f4">
<%@ include file="header.jsp" %>

    <div class="panel-body" style="background-color: #f3f3f4">
        <!--列表开始-->
        <div class="row" style="width: 85%; margin: 20px auto 0;">
            <c:forEach items="${pageBean.list}" var="g" varStatus="i">
                <div class="col-sm-3" onclick="location.href='${pageContext.request.contextPath}/ProductServlet?method=detail&pid=${g.pId}'">
                    <div class="thumbnail" id="list_item" style="border-radius: 15px;" >
                        <img src="${pageContext.request.contextPath}/image/goodsImgs/${g.pImage}" alt="${g.pName}" width="260" height="340"/>
                        <div class="caption" style="background-color: #f1f1f3; border-radius: 15px; margin-top: 5px">
                            <div><a href="${pageContext.request.contextPath}/ProductServlet?method=detail&pid=${g.pId}" style="color: #919191;">${g.pName}</a></div>
                            <p>指数
                                <c:forEach begin="1" end="${g.pState}">
                                    <img src="image/star_red.gif" alt="star"/>
                                </c:forEach>
                            </p>
                            <p>上架日期:${g.pTime}</p>
                            <p style="color:orange">价格:${g.pPrice}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!--列表结束-->
        <!--分页开始-->
        <center>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li class="${pageBean.currentPage == 1 ? 'disabled' : ''}">
                        <c:if test="${pageBean.currentPage != 1}">
                            <a href="<c:url value="/ProductServlet?method=show&tid=${param.tid}&currentPage=${pageBean.currentPage - 1}"/>"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </c:if>

                    </li>

                    <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="index">
                        <c:if test="${pageBean.currentPage == index}">
                            <li class="active">
                                <a href="<c:url value="/ProductServlet?method=show&tid=${param.tid}&currentPage=${index}"/>">${index}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageBean.currentPage != index}">
                            <li>
                                <a href="<c:url value="/ProductServlet?method=show&tid=${param.tid}&currentPage=${index}"/>">${index}</a>
                            </li>
                        </c:if>

                    </c:forEach>

                    <li class="${pageBean.currentPage == pageBean.totalPage ? 'disabled' : ''}">
                        <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                            <a href="<c:url value="/ProductServlet?method=show&tid=${param.tid}&currentPage=${pageBean.currentPage + 1}"/>"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>

                    </li>
                </ul>
            </nav>
        </center>
    </div>
<!-- 底部 -->
<%@ include file="footer.jsp" %>
</body>
</html>