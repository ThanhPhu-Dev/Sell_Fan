<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Forget Password</title>
<form action="<c:url value="/"/>auth/forgetpassword" method="post">
    <img class="avatar" src="<c:url value='/template/image/avatar.svg'/>">
    <h2 class="title">Quên mật khẩu</h2>
    <div class="input-div one">
        <div class="i">
            <i class="fas fa-user"></i>
        </div>
        <div class="div">
            <h5>Email</h5>
            <input type="email" name="email"
                   pattern="^[\w]+@gmail.com$"
                   class="input" required>
        </div>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-${alert} alert-message" role="alert">
                ${message}
        </div>
    </c:if>
    <input type="submit" class="btn" value="Xác Nhận">
    <div class="option">
        <a href="<c:url value="/"/>auth">Đăng nhập</a>
        <a href="<c:url value="/"/>auth/register">Đăng ký</a>
    </div>

</form>
