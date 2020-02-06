<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión de Alumnos</title>
<%@include file="includes/IncHead.jsp" %>
</head>
<body>
	<div class="container">
		<h2>Gestion de alumnos</h2>
		<div class="row mb-1">
			<div class="col-md-1">
				<input id="btnNuevo" type="button" value="Nuevo" class="btn btn-primary btn-sm"/>
			</div> 
		</div>
		<div class="row">
			<div class="col-md-12">
				<table id="tablaAlumnos">
					<thead>
						<tr>
							<th data-field="nombre">Nombre</th>
							<th data-formatter="quiz.botonesFormat" data-width="20" data-align="center">Acciones</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		
		<div id="divAlumno" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="titulo" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
			        <div class="modal-header">
				        <h5 class="modal-title" id="titulo">Datos del alumno</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
    			    </div>
			        <div class="modal-body">
					  <div class="form-group">
					    <label>Nombre</label>
					    <input id="txtNombre" class="form-control" placeholder="Nombre del alumno">
					  </div>
			        </div>			        
			        <div class="modal-footer">
		          		<input type="button" id="btnClose" value="Cerrar" class="btn btn-secondary" data-dismiss="modal"/>
		          		<input type="button" id="btnGuardar" value="Guardar" class="btn btn-success"/>
			        </div>
			    </div>
			</div>
		</div>
		
	</div>
	<%@include file="includes/IncFooter.jsp" %>
	<script src="/js/Alumnos.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>

