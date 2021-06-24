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
                <div class="header__search">
                    <form class="d-flex mb-0">
                        <input class="form-control me-2" type="search" placeholder="Tìm kiếm">
                    </form>
                </div>
                <div class="mx-2">
                    <a href="/purchase/history" class="text-white text-decoration-none">
                        <span>Lịch sử mua hàng</span>
                    </a>
                </div>
                <div class="header__cart">
                    <a href="/cart" class="d-block text-decoration-none">
                        <button type="button" class="btn btn-outline-primary btn-outline-fff d-flex align-items-center">
                            <ion-icon name="cart-outline"></ion-icon>
                            <span class="ms-1">Giỏ hàng</span>
                        </button>
                    </a>
                </div>
            </div>

        </div>
    </div>
</header>