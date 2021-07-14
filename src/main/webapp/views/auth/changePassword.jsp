<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Change Password</title>
<form id="auth-form" action="<c:url value="/"/>auth/changepassword" method="post" novalidate>
    <input type="hidden" name="id" value="${id}">
    <a href="<c:url value="/"/>" style="text-align: center">
        <img class="avatar" src="<c:url value='https://res.cloudinary.com/nguyenhieunghia/image/upload/v1626239734/avatar/1-logo-the-gioi-di-song-dien-may-xanh_lhjsao.jpg'/>">
    </a>
    <h2 class="title">Thay đổi mật khẩu</h2>
    <div class="input-div pass">
        <div class="i">
            <i class="fas fa-lock"></i>
        </div>
        <div class="div">
            <h5>Mật Khẩu</h5>
            <input type="password" name="password" pattern="^[\w]{8,}" class="input" required>
            <div class="invalid-feedback message-regex">Phải có ít nhất 8 ký tự</div>
        </div>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-success alert-message" role="alert">
                ${message}
        </div>
    </c:if>
    <input type="submit" class="btn" value="Xác Nhận">
    <a href="<c:url value="/auth"/>">Đăng Nhập</a>
</form>
