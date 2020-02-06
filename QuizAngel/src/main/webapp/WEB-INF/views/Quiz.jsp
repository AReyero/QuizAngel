<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
<%@include file="includes/IncHead.jsp" %>
</head>
<body>
	<div class=container></div>
		<h2>Quiz</h2>
		<div class="row">
			<div class= "col-md-3">
				<div class="form-group">
					<label for="exampleFormControlInput1">Alumno</label>
					<input id="txtAlumno" class="form-control" readonly="readonly">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class=form-group>
					<label for="exampleFormControlInput1">Pregunta</label>
					<textarea id="txtPregunta" class="form-control" rows="5" readonly="readonly"></textarea>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				<input id="btnVerRespuesta" type="button" class=" btn btn-primary" value="Ver respuesta"/>
			</div>
		</div>
		<hr/>
		<div class="row" id="divRespuesta">
			<div class="col-md-12">
				<h4>Repuesta</h4>
			</div>
				<div class=form-group>
					<textarea id="txtRespuesta" class="form-control" rows="3" readonly="readonly"></textarea>
				</div>
			<div class="col-md-1">
				<input id="btnAcierto" type="button" class=" btn btn-success" value="Acertado"/>
			</div>
			<div class="col-md-1">
				<input id="btnFallo" type="button" class=" btn btn-danger" value="Error"/>
			</div>
			
		</div>
<%@include file="includes/IncFooter.jsp" %>
	<script src="/js/Quiz.js" type="text/javascript"></script>
</body>
</html>