<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/auth/login.css'/> ">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <title>Login</title>
</head>
<body>
    <img src='<c:url value="/template/auth/avatar.svg" />" class="wave">
    <div class="container">
        <div class="img">
<%--            <img src='<c:url value='/template/auth/wave.png' />'>--%>
        </div>
        <div class="login-container">
            <form>
                <img src='<c:url value="/template/auth/avatar.svg"/>'>
                <h2>Welcome</h2>
                <div class="input-div">
                    <div class="i">
                        <i class="fas fa-user"></i>
                    </div>
                    <div>
                        <h5>Username</h5>
                        <input class="input" type="text">
                    </div>
                </div>
                <div class="input-div">
                    <div class="i">
                        <i class="fas fa-lock"></i>
                    </div>
                    <div>
                        <h5>Password</h5>
                        <input class="input" type="password">
                    </div>
                </div>
                <a href="#">Forget Password?</a>
                <input type="submit" class="btn" value="Login">
            </form>
        </div>
    </div>
<script type="text/javascript" src="<c:url value='/template/auth/login.js'/>"></script>
</body>
</html>