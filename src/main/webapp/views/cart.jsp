<%--
  Created by IntelliJ IDEA.
  User: dtrongphuc
  Date: 6/23/2021
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Title</title>
<main class="main bg-light">
    <div class="container">
        <div class="row">
            <div class="col-0 col-md-3"></div>
            <div class="col-12 col-md-6">
                <div class="cart-wrapper mt-2">
                    <div class="d-flex align-items-center justify-content-between mb-2">
                        <a href="/" class="text-primary text-decoration-none fs-09 px-2">&#8249; Mua thêm sản phẩm khác</a>
                        <p class="text-dark mb-0 fs-09 px-2">Giỏ hàng của anh chị</p>
                    </div>
                    <div class="bg-white rounded shadow py-2 pb-4">
                            <ul class="cart-list list-unstyled border-bottom px-md-4 px-2">
                            <li class="cart-item d-flex align-items-start justify-content-center py-3">
                                <div class="cart-item__left me-3">
                                    <a href="" class="d-block">
                                        <img src="https://cdn.tgdd.vn/Products/Images/1992/236847/dung-asia-dtb1601-xv0-1-1-200x200.jpg"
                                             alt="" class="cart-item__img" />
                                    </a>
                                    <a href="" class="
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
                                    <strong class="fs-09">Quạt đứng Asia Turbo DTB1601-XV0</strong>
                                </div>
                                <div class="cart-item__right text-end">
                                    <p class="text-dark fs-09">900.000đ</p>
                                    <div class="d-flex align-items-center w-100 bg-white cart-item__quantity">
                                        <button class="bg-white border mx-0" disabled>
                                            <ion-icon name="remove-outline"></ion-icon>
                                        </button>
                                        <div class="quantity border fs-09 position-relative">1</div>
                                        <button class="bg-white border text-primary">
                                            <ion-icon name="add-outline"></ion-icon>
                                        </button>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <div class="d-flex align-items-center justify-content-between mb-2 px-md-4 px-2">
                            <p class="mb-0 text-dark fs-09">Tạm tính (1 sản phẩm):</p>
                            <p class="mb-0 fs-09 text-dark">900.000đ</p>
                        </div>
                        <div class="d-flex align-items-center justify-content-between border-bottom pb-3 px-md-4 px-2">
                            <p class="mb-0 text-dark fw-bold">Tổng tiền:</p>
                            <p class="mb-0 fs-09 text-danger fw-bold">900.000đ</p>
                        </div>
                        <form action="#" method="POST" class="mt-2">
                            <div class="px-md-4 px-2">
                                <p class="mb-0 text-dark text-uppercase fs-6 mt-2">
                                    thông tin khách hàng:
                                </p>
                                <div class="d-flex align-items-center mt-2">
                                    <div class="form-check me-3">
                                        <input type="radio" class="form-check-input" name="gender" id="male" checked>
                                        <label for="male" class="form-check-label fs-09">Anh</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="radio" class="form-check-input" name="gender" id="female">
                                        <label for="female" class="form-check-label fs-09">Chị</label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12 col-md-6">
                                        <input type="text" name="fullname" class="form-control" placeholder="Họ và Tên">
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <input type="text" name="phone" class="form-control" placeholder="Số điện thoại">
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <p class="mb-0 text-dark text-uppercase fs-6 mt-3">
                                        địa chỉ giao hàng:
                                    </p>
                                    <div class="col-12 mt-2">
                                        <input type="text" name="address" class="form-control" placeholder="Địa chỉ">
                                    </div>
                                    <div class="col-12 mt-2">
                                        <input type="text" name="requirement" class="form-control" placeholder="Yêu cầu khác (không bắt buộc)">
                                    </div>
                                </div>
                            </div>
                            <div class="border-bottom mt-3"></div>
                            <div class="px-md-4 px-2 mt-3 d-flex align-items-center justify-content-between">
                                <p class="fs-09 fw-bold text-dark">Tổng tiền:</p>
                                <p class="fs-09 fw-bold text-danger">900.000đ</p>
                            </div>
                            <div class="px-md-4 px-2">
                                <button type="submit" class="btn btn-primary text-uppercase w-100">Đặt hàng</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-0 col-md-3"></div>
        </div>
    </div>
</main>
