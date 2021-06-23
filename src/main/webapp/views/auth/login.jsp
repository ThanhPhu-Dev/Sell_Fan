<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Login</title>
<form action="#">
	<img class="avatar" src="<c:url value='/template/image/avatar.svg'/>">
	<h2 class="title">Chào Mừng</h2>
	<div class="input-div one">
		<div class="i">
			<i class="fas fa-user"></i>
		</div>
		<div class="div">
			<h5>Email</h5>
			<input type="email" pattern="^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$"
				   class="input" required autofocus>
		</div>
	</div>
	<div class="input-div pass">
		<div class="i">
			<i class="fas fa-lock"></i>
		</div>
		<div class="div">
			<h5>Mật Khẩu</h5>
			<input type="password" pattern="^[\w]{8}" class="input" required>
		</div>
	</div>
	<div class="option">
		<a href="./auth/register">Register</a>
		<a href="#">Quên mật khẩu?</a>
	</div>
	<input type="submit" class="btn" value="Đăng Nhập">
</form>
