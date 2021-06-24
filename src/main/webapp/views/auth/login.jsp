<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Login</title>
<form action="./auth" method="post">
	<img class="avatar" src="<c:url value='/template/image/avatar.svg'/>">
	<h2 class="title">Chào Mừng</h2>
	<div class="input-div one">
		<div class="i">
			<i class="fas fa-user"></i>
		</div>
		<div class="div">
			<h5>Email</h5>
			<input type="email" name="email" pattern="^[\w]+@gmail.com$"
				   class="input" required autofocus>
		</div>
	</div>
	<div class="input-div pass">
		<div class="i">
			<i class="fas fa-lock"></i>
		</div>
		<div class="div">
			<h5>Mật Khẩu</h5>
			<input type="password" name="password" pattern="^[\w]{8,}" class="input" required>
		</div>
	</div>
	<c:if test="${not empty message}">
		<div class="alert alert-danger alert-message" role="alert">
				${message}
		</div>
	</c:if>

	<input type="submit" class="btn" value="Đăng Nhập">
	<div class="option">
		<a href="./auth/register">Register</a>
		<a href="<c:url value="/"/>auth/forgetpassword">Quên mật khẩu?</a>
	</div>
</form>
