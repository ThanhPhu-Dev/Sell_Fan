<%--
  Created by IntelliJ IDEA.
  User: dtrongphuc
  Date: 6/23/2021
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Giỏ hàng</title>
<main class="main bg-light">
    <div class="container">
        <div class="row">
            <c:if test="${empty carts}">
                <div class="col-12 my-5 py-5">
                    <div class="d-flex align-items-center flex-column justify-content-center py-5">
                        <img src="https://www.dienmayxanh.com/lich-su-mua-hang/Content/images/gio-hang-rong-desk.png"
                             alt="">
                        <strong class="text-dark fs-5">Bạn chưa có đơn hàng nào</strong>
                        <button class="btn btn-outline-primary bg-white mt-2">
                            <a href="/" class="text-decoration-none d-block px-3 py-1">Về trang chủ</a>
                        </button>
                        <p class="fs-09 text-dark mt-2">Khi cần hỗ trợ vui lòng gọi <span
                                class="text-primary">1800.1061</span> (7h30 - 22h)</p>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty carts}">

                <div class="col-0 col-md-3"></div>
                <div class="col-12 col-md-6">
                    <div class="cart-wrapper mt-2">
                        <div class="d-flex align-items-center justify-content-between mb-2">
                            <a href="/" class="text-primary text-decoration-none fs-09 px-2">&#8249; Mua thêm sản phẩm
                                khác</a>
                            <p class="text-dark mb-0 fs-09 px-2">Giỏ hàng của anh chị</p>
                        </div>
                        <div class="bg-white rounded shadow py-2 pb-4">
                            <ul class="cart-list list-unstyled border-bottom px-md-4 px-2">
                                <c:forEach var="cart" items="${carts}">
                                    <li class="cart-item d-flex align-items-start justify-content-center py-3">
                                        <div class="cart-item__left me-3">
                                            <a href="" class="d-block">
                                                <img src="${cart.getCartProduct().getImage()}"
                                                     alt="" class="cart-item__img"/>
                                            </a>
                                            <a href="<c:url value="/"/>cart/delete?id=${cart.getId()}" class="
												text-secondary text-decoration-none
												d-flex
												align-items-center
												justify-content-center
												cart-item__remove
												mt-3
											">
                                                <ion-icon name="close-circle-outline"></ion-icon>
                                                <span class="ms-1">Xoá</span>
                                            </a>
                                        </div>
                                        <div class="cart-item__center flex-grow-1 me-2">
                                            <strong class="fs-09">${cart.getCartProduct().getName()}</strong>
                                        </div>
                                        <div class="cart-item__right text-end">
                                            <p class="text-dark fs-09">${cart.getCartProduct().getPrice()}</p>
                                                <%--QUANTITY--%>
                                            <div class="d-flex align-items-center w-100 bg-white cart-item__quantity">
                                                <a href="<c:url value="/"/>cart/reduce?id=${cart.getId()}"
                                                   class="btn-quantity text-decoration-none bg-white border border-end-0 mx-0 p-0 d-flex align-items-center justify-content-center
                                                   ${cart.getQuantity() == 1 ? 'disabled' : ''}">
                                                    <ion-icon name="remove-outline"></ion-icon>
                                                </a>
                                                <div product=""
                                                     class="quantity border fs-09 position-relative">${cart.getQuantity()}</div>
                                                <a href="<c:url value="/"/>cart/add?id=${cart.getId()}"
                                                   class="btn-quantity bg-white border border-start-0 text-primary
                                                   d-flex align-items-center justify-content-center ${cart.getQuantity() >= cart.getCartProduct().getStock() ? 'disabled' : ''}">
                                                    <ion-icon name="add-outline"></ion-icon>
                                                </a>
                                            </div>
                                                <%--END QUANTITY--%>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="d-flex align-items-center justify-content-between mb-2 px-md-4 px-2">
                                <p class="mb-0 text-dark fs-09">Tạm tính (${carts.size()} sản phẩm):</p>
                                <p class="mb-0 fs-09 text-dark">${provisionalPrice}</p>
                            </div>
                            <div class="d-flex align-items-center justify-content-between border-bottom pb-3 px-md-4 px-2">
                                <p class="mb-0 text-dark fw-bold">Tổng tiền:</p>
                                <p class="mb-0 fs-09 text-danger fw-bold">${provisionalPrice}</p>
                            </div>
                            <form id="checkout-form" action="<c:url value="/"/>checkout" method="POST" class="mt-2" novalidate>
                                <div class="px-md-4 px-2">
                                    <p class="mb-0 text-dark text-uppercase fs-6 mt-2">
                                        thông tin khách hàng:
                                    </p>
                                    <div class="d-flex align-items-center mt-2">
                                        <div class="form-check me-3">
                                            <input type="radio" class="form-check-input" name="gender" id="male"
                                                   checked value="Anh">
                                            <label for="male" class="form-check-label fs-09">Anh</label>
                                        </div>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" name="gender" id="female" value="Chị">
                                            <label for="female" class="form-check-label fs-09">Chị</label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12 col-md-6">
                                            <input type="text" name="fullname" class="form-control"
                                                   placeholder="Họ và Tên" value="${customerName}" required>
                                            <div class="invalid-feedback">Vui lòng điền họ tên!</div>
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <input type="text" name="phone" class="form-control"
                                                   placeholder="Số điện thoại" required>
                                            <div class="invalid-feedback">Vui lòng điền số điện thoại!</div>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <p class="mb-0 text-dark text-uppercase fs-6 mt-3">
                                            địa chỉ giao hàng:
                                        </p>
                                        <div class="col-12 mt-2">
                                            <input type="text" name="address" class="form-control"
                                                   placeholder="Địa chỉ" required>
                                            <div class="invalid-feedback">Vui lòng điền địa chỉ!</div>
                                        </div>
                                        <div class="col-12 mt-2">
                                            <input type="text" name="requirement" class="form-control"
                                                   placeholder="Yêu cầu khác (không bắt buộc)">
                                        </div>
                                    </div>
                                </div>
                                <div class="border-bottom mt-3"></div>
                                <div class="px-md-4 px-2 mt-3 d-flex align-items-center justify-content-between">
                                    <p class="fs-09 fw-bold text-dark">Tổng tiền:</p>
                                    <p class="fs-09 fw-bold text-danger">${provisionalPrice}</p>
                                </div>
                                <div class="px-md-4 px-2">
                                    <button type="submit" class="btn btn-primary text-uppercase w-100">Đặt hàng</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-0 col-md-3"></div>
            </c:if>
        </div>
    </div>
</main>
<script src="<c:url value='/template/js/cart.js'/>"></script>
