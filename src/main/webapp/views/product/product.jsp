<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Sản phẩm</title>

<div class="detailproduct" style="margin: 20px 0;">
    <div class="container">
        <div class="detail__header">
            <div class="detail__name">
                <h4 style="font-size: 22px;">${product.getName()}</h4>
                <div class="social">

                </div>
            </div>
        </div>
        <div class="infoprimary">
            <div class="row">
                <div class="col-7">
                    <!-- CAROUSEL -->
                    <div class="infoprimary__img">
                        <!-- <img src="./img/fan1.jpg" alt=""> -->
                        <div class="swiper-container mySwiper">
                            <div class="swiper-wrapper">
                                <c:forEach var="img" items="${productImages}">
                                    <div class="swiper-slide">
                                        <img src="${img.getImage()}" />
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="swiper-button-next"></div>
                            <div class="swiper-button-prev"></div>
                            <div class="swiper-pagination"></div>
                        </div>
                    </div>

                    <!-- BẢO HÀNH -->
                    <div class="guarantee d-flex justify-content-center">
                        <ul>
                            <li class="d-flex">
                            <ion-icon name="settings-outline"></ion-icon>
                            <div>Hư gì đổi nấy <strong>12 tháng</strong>trên toàn quốc</div>
                            </li>
                            <li class="d-flex">
                            <ion-icon name="shield-checkmark-outline"></ion-icon>
                            <div>Bảo hành chính hãng quạt <strong>1 năm</strong></div>
                            </li>
                            <li class="d-flex">
                            <ion-icon name="airplane-outline"></ion-icon>
                            <div>Giao hàng tận nhà nhanh chóng</div>
                            </li>
                        </ul>
                    </div>

                    <div class="tachnical-img">
                        <img src="<c:url value="/template/image/products/technical1.jpg" />" alt="" width="100%">
                    </div>
                </div>
                <!-- LEFT -->
                <div class="col-5">
                    <!-- INFO BASIC -->
                    <div class="infoprimary__content">
                        <div class="product-price infoprimary__content-items">
                            <span>Giá ở <span style="color: #009EE1;">tất cả các cửa hàng</span></span>
                            <p>
                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.getPrice()}" />
                                ₫ 
                            </p>
                        </div>
                        <div class="product-status infoprimary__content-items">
                            <strong style="color: green;">
                                <c:set var = "stock" scope = "session" value = "${product.getStock()}"/>
                                <c:choose>
                                    <c:when test = "${stock < 1}">
                                        HẾT HÀNG
                                    </c:when>
                                    <c:otherwise>
                                        CÒN HÀNG
                                    </c:otherwise>
                                </c:choose>
                            </strong>
                        </div>
                        <div class="prduct-address infoprimary__content-items" style="padding: 10px 0;">
                            <span style="color: #009EE1;">
                                <ion-icon name="location-outline"></ion-icon>
                                Chọn địa chỉ nhận hàng
                            </span>
                            để biết thời gian giao.
                        </div>
                        <div class="product-buy infoprimary__content-items">
                            <button type="button" class="btn btn-buy"
                                    <c:if test = "${stock < 1}">disabled</c:if>>
                                        Mua hàng
                                    </button>
                            </div>
                            <div class="contact-store">
                                Gọi đặt mua 1800.1061 (7:30 - 22:00)
                            </div>

                            <!-- CARD KHUYẾN MÃI -->
                            <div class="card" style="margin-top: 20px;">
                                <div class="card-header">
                                    1 ưu đãi thêm
                                </div>
                                <div class="card-body sale-box d-flex fle-column">
                                    <ion-icon name="gift-outline"></ion-icon>
                                    <ul>
                                        <li>Tặng cho khách lần đầu mua hàng online tại web BachhoaXANH.com</li>
                                        <li>Mã giảm 20% tối đa 100.000đ</li>
                                        <li>5 lần FREEship</li>
                                        <li>Áp dụng tại Tp.HCM và 1 số khu vực, 1 SĐT nhận 1 lần (Xem chi tiết)</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <!-- INFO TECHNICAL -->
                        <div class="infotechnical">
                            <h3>Thông số kỹ thuật ${product.getName()}</h3>
                        <!-- TABLE -->
                        <table class="table table-striped">
                            <tbody>
                                <tr>
                                    <td>Loại quạt:</td>
                                    <td>${productDetail.getType()}</td>
                                </tr>
                                <tr>
                                    <td>Đường kính quạt:</td>
                                    <td>${productDetail.getDiameter()}</td>
                                </tr>
                                <tr>
                                    <td>Chế độ gió:</td>
                                    <td>${productDetail.getWindMode()}</td>
                                </tr>
                                <tr>
                                    <td>Bảng điều khiển:</td>
                                    <td>${productDetail.getDashBoard()}</td>
                                </tr>
                                <tr>
                                    <td>Loại motor:</td>
                                    <td>${productDetail.getMotorType()}</td>
                                </tr>
                                <tr>
                                    <td>Tiện ích:</td>
                                    <td>${productDetail.getUtility()}</td>
                                </tr>
                                <tr>
                                    <td>Kích thước, trọng lượng:</td>
                                    <td>${productDetail.getSizeWight()}</td>
                                </tr>
                                <tr>
                                    <td>Thương hiệu của:</td>
                                    <td>${productDetail.getBrandName()}</td>
                                </tr>
                                <tr>
                                    <td>Sản xuất tại:</td>
                                    <td>${productDetail.getMadeIn()}</td>
                                </tr>
                                <tr>
                                    <td>Năm ra mắt:</td>
                                    <td>${productDetail.getDebutYear()}</td>
                                </tr>
                                <tr>
                                    <td>Hãng</td>
                                    <td>${productDetail.getCompany()}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

