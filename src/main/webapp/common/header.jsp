<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<header>
    <div class="header-top">
        <div class="container">
            <img src="<c:url value="/template/image/headertop.png"/>" alt="" >
        </div>
    </div>
    <div class="header-body">
        <div class="container d-flex justify-content-between">
            <div class="header__logo">
                <img src="<c:url value="/template/image/logo.png"/>" alt="" width="180px" height="40px">
            </div>
            <div class="d-flex align-items-center">
                <div class="mx-2">
                    <a href="<c:url value="/"/>purchase/history" class="text-white text-decoration-none">
                        <span>Lịch sử mua hàng</span>
                    </a>
                </div>
                <div class="header__cart">
                    <a href="<c:url value="/"/>cart" class="d-block text-decoration-none">
                        <button type="button" class="btn btn-outline-primary btn-outline-fff d-flex align-items-center">
                            <ion-icon name="cart-outline"></ion-icon>
                            <span class="ms-1">Giỏ hàng</span>
                        </button>
                    </a>
                </div>
                <!--USER NAME-->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <nav class="navbar navbar-expand-lg">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"
                       style="padding: 0;">
                        <img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg" width="40" height="40" class="rounded-circle">
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                        <li><a class="dropdown-item" href="">Đăng xuất</a></li>
                    </ul>
                </nav>
            </div>

        </div>
    </div>
</header>