<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salir</title>
<%@include file="includes/IncHead.jsp" %>
</head>
<body>
	<div class="container">
		<div class="row justify-conntent-center">
			<div class="cold-md-4">
				<h2>Cierre de sesión</h2>
			</div>
		</div>
		<div class="row justify-conntent-center">
			<div class="cold-md-4">
				<input id="btnlogout" type="button" value="Salir" class="btn btn-primary"/>
			</div>
		</div>
	</div>

<%@include file="includes/IncFooter.jsp" %>
	<script src="/js/Logout.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>