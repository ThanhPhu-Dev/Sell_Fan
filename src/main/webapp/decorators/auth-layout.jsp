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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/css/login.css'/>">
    <title><dec:title /></title>
</head>
<body>
<img class="wave" src="<c:url value='/template/image/wave.png'/>">
<div class="container">
    <div class="img">
        <img src="<c:url value='/template/image/bg.svg'/>">
    </div>
    <div class="login-content">
        <dec:body />
    </div>
</div>
<script>
(function () {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  var form = document.querySelector('#auth-form')

	      form.addEventListener('submit', function (event) {
	        if (!form.checkValidity()) {
	          event.preventDefault()
	          event.stopPropagation()
	        }

	        form.classList.add('was-validated')
	      }, false)
	})()
</script>

<script type="text/javascript" src="<c:url value='/template/js/login.js'/>"></script>
</body>
</html>