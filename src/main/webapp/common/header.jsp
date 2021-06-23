<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<header>
    <div class="header-top">
      <div class="container">
          <img src="<c:url value='./template/image/headertop.png'/>" alt="" >
      </div>
    </div>
    <div class="header-body">
      <div class="container d-flex justify-content-between">
        <div class="header__logo">
          <img src="<c:url value='./template/image/logo.png'/>" alt="" width="180px" height="40px">
        </div>
        <div class="d-flex">
          <div class="header__search">
            <form class="d-flex">
              <input class="form-control me-2" type="search" placeholder="Tìm kiếm">
            </form>
          </div>
          <div class="header__cart">
            <button type="button" class="btn btn-outline-primary btn-outline-fff d-flex align-items-center">
              <ion-icon name="cart-outline"></ion-icon>
              <span>Giỏ hàng</span>
            </button>
          </div>
        </div>

      </div>
    </div>
  </header>