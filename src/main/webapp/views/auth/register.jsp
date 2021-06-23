<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Login</title>
<form action="#">
    <img class="avatar" src="<c:url value='/template/image/avatar.svg'/>">
    <h2 class="title">Đăng Ký</h2>
    <div class="input-div one">
        <div class="i">
            <i class="fas fa-user"></i>
        </div>
        <div class="div">
            <h5>Email</h5>
            <input type="email" class="input">
        </div>
    </div>
    <div class="input-div one">
        <div class="i">
            <i class="fas fa-user"></i>
        </div>
        <div class="div">
            <h5>Họ Tên</h5>
            <input type="text" class="input">
        </div>
    </div>
    <div class="input-div pass">
        <div class="i">
            <i class="fas fa-lock"></i>
        </div>
        <div class="div">
            <h5>Mật Khẩu</h5>
            <input type="password" class="input">
        </div>
    </div>
    <a href="./auth?action=login">Đã có tài khoản</a>
    <input type="submit" class="btn" value="Đăng Ký">
</form>