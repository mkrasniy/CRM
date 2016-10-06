<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
	<title>Авторизація</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Bootstrap -->
	<link rel="stylesheet" media="screen" href="./res/bootstrap.min.css">
	<link rel="stylesheet" media="screen" href="./res/bootstrap-theme.min.css">

	<!-- Bootstrap Admin Theme -->
	<link rel="stylesheet" media="screen" href="./res/bootstrap-admin-theme.css">

	<!-- Custom styles -->
	<style type="text/css">
		.alert{
			margin: 0 auto 20px;
		}
	</style>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script type="text/javascript" src="./res/html5shiv.js"></script>
	<script type="text/javascript" src="./res/respond.min.js"></script>
	<![endif]-->
</head>
<body class="bootstrap-admin-without-padding">
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<c:if test="${error != null}">
				<div class="alert alert-danger">
					<a class="close" data-dismiss="alert" href="#">&times;</a>
					<strong>Помилка!</strong>
					Ви ввели невірно логін або пароль.
				</div>
			</c:if>
			<div class="alert alert-info">
				<a class="close" data-dismiss="alert" href="#">&times;</a>
				Натисніть "Enter" або "Підтвердити"
			</div>
			<form method="post" action="<c:url value='/j_spring_security_check' />" class="bootstrap-admin-login-form">
				<h1>Авторизація</h1>
				<div class="form-group">
					<input class="form-control" type="text" name='username' placeholder="Логін">
				</div>
				<div class="form-group">
					<input class="form-control" type="password" name="password" placeholder="Пароль">
				</div>
				<div class="form-group">
					<label>
						<input type="checkbox" name="remember_me">
						Запам'ятати мене
					</label>
				</div>
				<button class="btn btn-lg btn-primary" type="submit">Підтвердити</button>
				<input type="hidden" name="${_csrf.parameterName}"
					   value="${_csrf.token}" />
			</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="./res/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		// Setting focus
		$('input[name="email"]').focus();

		// Setting width of the alert box
		var alert = $('.alert');
		var formWidth = $('.bootstrap-admin-login-form').innerWidth();
		var alertPadding = parseInt($('.alert').css('padding'));

		if (isNaN(alertPadding)) {
			alertPadding = parseInt($(alert).css('padding-left'));
		}

		$('.alert').width(formWidth - 2 * alertPadding);
	});
</script>
</body>
</html>
