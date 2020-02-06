<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validación</title>
<%@include file="includes/IncHead.jsp" %>
</head>
<body>
	<form id='form'>
		<div class="container">
			<div class="row justify-conntent-center">
				<div class="cold-md-4">
					<h2>Validación</h2>
				</div>
			</div>
			<div class="row justify-conntent-center">
				<div class="cold-md-4">
					<div class="form-group">
						<label>Usuario</label>
						<input id="username" name="username" class="form-control"/>
					</div>
				</div>
			</div>
			<div class="row justify-conntent-center">
				<div class="cold-md-4">
					<div class="form-group">
						<label>Password</label>
						<input id="password" name="password" class="form-control"/>
					</div>
				</div>
			</div>
			<div class="row mb-4 justify-conntent-center">
				<div class="cold-md-1">
					<input id="btnlogin" type="button" value="Entrar" class="btn btn-primary"/>
				</div>
			</div>
		</div>
	</form>

<%@include file="includes/IncFooter.jsp" %>
	<script src="/js/Login.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>