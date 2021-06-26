<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<style>
    .cart-count {
        position: absolute;
        top: -6px;
        left: 13px;
        background: #f00;
        border-radius: 50%;
        font-size: 10px;
        color: #fff;
        height: 14px;
        width: 14px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
</style>
<header>
    <div class="header-top">
        <div class="container">
            <a href="<c:url value="/home"/>">
                <img src="<c:url value="/template/image/headertop.png"/>" alt="" >
            </a>
        </div>
    </div>
    <div class="header-body">
        <div class="container d-flex justify-content-between align-items-center">
            <div class="header__logo">
                <a href="<c:url value="/"/>" class="d-block">
                    <img src="<c:url value="/template/image/logo.png"/>" alt="" width="180px" height="40px">
                </a>
            </div>
            <div class="d-flex align-items-center">
                <div class="mx-2">
                    <a href="<c:url value="/"/>purchase/history" class="text-white text-decoration-none">
                        <span>Lịch sử mua hàng</span>
                    </a>
                </div>
                <div class="header__cart" style="padding: 0 20px">
                    <a href="<c:url value="/cart" />" class="d-block position-relative text-decoration-none d-flex align-items-center text-white">
                        <ion-icon name="cart-outline"></ion-icon>
                        <span class="ms-1">Giỏ hàng</span>
                        <c:if test="${not empty cartCount}">
                            <c:if test="${cartCount > 0}">
                                <span class="cart-count">${cartCount}</span>
                            </c:if>
                        </c:if>
                    </a>
                </div>
                <!--USER NAME-->
                <c:choose >
                    <c:when test="${not empty nameUserCurrent}">
                        <nav class="navbar navbar-expand-lg">
                            <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" id="navbarScrollingDropdown" 
                               role="button" data-bs-toggle="dropdown" aria-expanded="false" style="padding: 0;">
                                <img src="${avatarUserCurrent}"
                                     width="30" height="30" class="rounded-circle">
                                <div class="navbar-username" style="color: #fff; margin-left: 10px;"> ${nameUserCurrent}</div>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                                <li><a class="dropdown-item" href="<c:url value="/auth/signout" />">Đăng xuất</a></li>
                                <li><a class="dropdown-item" href="<c:url value="/profile" />">Cá nhân</a></li>
                            </ul>
                        </nav>
                    </c:when>
                    <c:otherwise>
                        <div class="header__auth d-flex align-items-center" style="padding-right: 20px">
                            <a href="<c:url value="/auth/register" />" class="d-block text-decoration-none text-white">
                                <span class="ms-1">Đăng kí</span>
                            </a>
                        </div>
                        <div class="header__auth d-flex align-items-center" >
                            <a href="<c:url value="/auth" />" class="d-block text-decoration-none text-white">
                                <span class="ms-1">Đăng nhập</span>
                            </a>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</header>