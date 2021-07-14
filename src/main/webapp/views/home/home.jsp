<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<title>Trang chủ</title>

<div class="container" style="margin-top: 30px;">
    <!--CATEGORY-->
    <div class="d-flex align-items-center mb-3">
        <%
            int catId = -1;
            if (request.getParameter("catId") != null) {
                catId = Integer.parseInt(request.getParameter("catId"));
            }
        %>

        <strong class="p-2">Phân loại:</strong>
        <div class="category p-2">
            <ul>

                <li class="<% if (catId == -1) {
                        out.println("category-active");
                    }%>">
                    <a href="<c:url value="/home"/>">Tất cả </a>
                </li>
                <c:forEach var="cat" items="${cats}">
                    <c:set var = "catIdDb" scope = "session" value = "${cat.getId()}"/>
                    <c:set var = "catIdLocal" scope = "session" value = "<%= catId%>"/>
                    <li class=" <c:if test = "${catIdDb == catIdLocal}">category-active</c:if>">
                        <a href=<c:url value="/home?catId=${cat.getId()}"/>>${cat.getName()}</a>
                    </li>

                </c:forEach>
            </ul>
        </div>
        <form class="d-flex ms-auto p-2 " method="GET" 
              action="<c:url value="/home"/>">
            <input class="form-control me-2" type="search" name="name" placeholder="Tên sản phẩm">
            <c:if test = "${catIdLocal > 0}">
                <input class="form-control me-2" name="catId" value="<%= catId%>" style="display: none">
            </c:if>
            <button class="btn btn-outline-primary" type="submit">Tìm</button>
        </form>
    </div>

    <!--PRODUCTS-->
    <ul class="productlist">

        <c:forEach var="pro" items="${products}">
            <li>
                <a href="<c:url value="/product?id=${pro.getId()}" />">
                    <div class="card product__item">
                        <img src="${pro.getImage()}"
                             class="card-img-top" alt="...">
                        <div class="card-body d-flex flex-column justify-content-between">
                            <span class="product-name">${pro.getName()}</span>
                            <span class="product-lable">Online giá rẻ</span>
                            <p class="product-price">
                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${pro.getPrice()}" /> đ
                            </p>
                        </div>
                    </div>
                </a>
            </li>
        </c:forEach>

    </ul>
</div>