<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ranking de alumnos</title>
<%@include file="includes/IncHead.jsp" %>

</head>
<body>
	<div class='container'>
		<h2>Ranking de alumnos</h2>
		<div class='row'>
			<div class="col-md-12">
				<table id='tablaRanking'>
					<thead>
						<tr>
							<th data-field='nombre'>Nombre</th>
							<th data-field='aciertos'>Aciertos</th>
							<th data-field='intentos'>Intentos</th>
							<th data-formatter='quiz.porcentaje'>Porcentaje</th>
						</tr>
					</thead>
				</table>	
			</div>
		
		</div>
	
	</div>
	
	<%@include file="includes/IncFooter.jsp" %>
	<script src="/js/Ranking.js" type="text/javascript"></script>
</body>
</html>