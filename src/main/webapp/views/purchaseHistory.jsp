<%--
  Created by IntelliJ IDEA.
  User: dtrongphuc
  Date: 6/23/2021
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<title>Lịch sử mua hàng</title>
<style>
    .menu-item.active {
        background-color: #e8f0ff;
        border-radius: 0 20px 20px 0;
        font-weight: 500;
        color: #288ad6;
    }

    .cart-wrapper > a:last-child {
        border-bottom: none !important;
    }
</style>
<main class="main pb-5">
    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-3">
                <ul class="ps-0 list-unstyled mt-3">
                    <li class="menu-item active text-dark d-block p-2">
                        <a href="" class="text-decoration-none fs-6">
                            Danh sách đơn hàng đã mua
                        </a>
                    </li>
                </ul>
            </div>
            <div class="col-12 col-lg-9">
                <c:if test="${empty list}">
                    <div class="border rounded bg-white p-5">
                        <div class="d-flex align-items-center flex-column justify-content-center p-5">
                            <img src="https://www.dienmayxanh.com/lich-su-mua-hang/Content/images/gio-hang-rong-desk.png" alt="">
                            <strong class="text-dark fs-5">Bạn chưa có đơn hàng nào</strong>
                            <button class="btn btn-outline-primary bg-white mt-2">
                                <a href="/" class="text-decoration-none d-block px-3 py-1">Về trang chủ</a>
                            </button>
                            <p class="fs-09 text-dark mt-2">Khi cần hỗ trợ vui lòng gọi <span class="text-primary">1800.1061</span> (7h30 - 22h)</p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty list}">
                    <section class="mt-3">
                        <p class="text-dark fs-6 mb-3">
                            Khách hàng: <strong>${customerName}</strong>
                        </p>
                        <div class="border rounded bg-white cart-wrapper">
                            <c:forEach items="${list}" var="item">
                                <a href="" class="card m-2 border-0 border-bottom rounded-0 p-3 text-decoration-none ">
                                    <div class="row g-0">
                                        <div class="col-md-3">
                                            <img src="${item.getBillDetailProduct().getImage()}" class="img-fluid rounded-start" alt="...">
                                        </div>
                                        <div class="col-md-9">
                                            <div class="card-body">
                                                <h5 class="card-title text-dark">${item.getBillDetailProduct().getName()}</h5>
                                                <p class="card-text mb-1"><small class="text-muted">
                                                    <fmt:formatDate pattern = "dd/MM/yyyy" value = "${item.getDate_Created()}" />
                                                </small></p>
                                                <p class="card-text"><small class="text-muted">x${item.getQuantity()}</small></p>
                                                <p class="card-text mb-1 text-danger">
                                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.getBillDetailProduct().getPrice()}" /> đ
                                                </p>
                                                <hr class="border-bottom"/>
                                                <p class="text-danger fw-bold text-end">
                                                    Tổng tiền: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.getTotal()}" /> đ
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </section>
                </c:if>
            </div>
        </div>
    </div>
</main>

