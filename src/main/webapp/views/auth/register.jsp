<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Register</title>
<form id="auth-form" action="./register" method="post" novalidate>
    <img class="avatar" src="<c:url value='/template/image/avatar.svg'/>">
    <h2 class="title">Đăng Ký</h2>
    <div class="input-div one">
        <div class="i">
            <i class="fas fa-user"></i>
        </div>
        <div class="div">
            <h5>Email</h5>
            <input type="email" name="email"
                   pattern="^[\w]+@gmail.com$"
                   class="input" required>
            <div class="invalid-feedback message-regex">email: XX@gmail.com</div>
        </div>
    </div>
    <div class="input-div one">
        <div class="i">
            <i class="fas fa-user"></i>
        </div>
        <div class="div">
            <h5>Họ Tên</h5>
            <input type="text" name="username" class="input" required>
        </div>
    </div>
    <div class="input-div pass">
        <div class="i">
            <i class="fas fa-lock"></i>
        </div>
        <div class="div">
            <h5>Mật Khẩu</h5>
            <input type="password" pattern="^[\w]{8,}" title="ít nhất 8 ký tự" name="password" class="input" required>
            <div class="invalid-feedback message-regex">Mật khẩu ít nhất 8 ký tự</div>
        </div>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-${alert} alert-message" role="alert">
                ${message}
        </div>
    </c:if>
    <input type="submit"  style="margin-top: 26px;" class="btn" value="Đăng Ký">
    <a href="<c:url value="/"/>auth">Đã có tài khoản</a>
</form>
