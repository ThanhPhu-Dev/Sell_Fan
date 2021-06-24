<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>Change Password</title>
<form action="<c:url value="/"/>auth/changepassword" method="post">
    <input type="hidden" name="id" value="${id}">
    <img class="avatar" src="<c:url value='/template/image/avatar.svg'/>">
    <h2 class="title">Thay đổi mật khẩu</h2>
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
        <div class="alert alert-success alert-message" role="alert">
                ${message}
        </div>
    </c:if>
    <input type="submit" class="btn" value="Xác Nhận">
</form>
