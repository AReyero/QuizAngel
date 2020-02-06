var quiz = {
	idAlumno : 0,

	//Al iniciar la página
	load : function (){
		$.getJSON({
			url: '/Admin/Alumnos/Listar',
			success : function(json){
				quiz.mostrarLista(json);
			},
			error : function(err){
				alert("No hay conexion con el servidor ")
			}
		});
	},

	//Reutilización para refrescar la lista
	mostrarLista : function(json){
		if (json.error!=null){
			alert(json.error);
		}
		if (json.dataAlumnos!=null){
			$('#tablaAlumnos').bootstrapTable('destroy');
			$('#tablaAlumnos').bootstrapTable({ data : json.dataAlumnos });
		}
    },

	//Abre el formulario en modo nuevo
    abrirFormularioNuevo : function(){
		quiz.idAlumno=0;
		$("#txtNombre").val('');		
		$("#divAlumno").modal();
	},

	//Abre el formulario en modo edicion
	abrirFormularioEditar : function(idAlumno){
		quiz.idAlumno=idAlumno;
		$.getJSON({
			url: '/Admin/Alumnos/Leer',
			data : {
				idAlumno: idAlumno
			},
			success : function(json){
				if (json.error!=null){
					alert(json.error);
				}
				if (json.dataAlumno!=null){
					quiz.idAlumno=json.dataAlumno.idAlumno;
					$("#txtNombre").val(json.dataAlumno.nombre);
					$("#divAlumno").modal();
				}
			},
			error : function(err){
				alert("No hay conexion con el servidor")
			}
		});
	},

	//Guarda el elemento del formulario
	guardar : function(){
		$.getJSON({
			url: '/Admin/Alumnos/Guardar',
			data: {
				idAlumno : quiz.idAlumno,
				nombre : $("#txtNombre").val()
			},
			success : function(json){
				quiz.mostrarLista(json);				
				$("#divAlumno").modal("hide");
			},
			error : function(err){
				alert("No hay conexion con el servidor")
			}
		});
	},


	//Borra el elemento recibido
	borrar : function(idAlumno){
		if (confirm('¿Está seguro que desea borrar este alumno?')){
			$.getJSON({
				url: '/Admin/Alumnos/Borrar',
				data: {
					idAlumno : idAlumno
				},
				success : function(json){
					quiz.mostrarLista(json);				
				},
				error : function(err){
					alert("No hay conexion con el servidor")
				}
			});
		}
	},

	//Columna de botones en la tabla (formateo)
	botonesFormat : function(value, row, index){
		return "<i onclick='quiz.abrirFormularioEditar("+ row.idAlumno +")' " +
					" class='fa fa-edit fa-lg' style='cursor:pointer'>" + 
				"</i> " +
			    "<i onclick='quiz.borrar("+ row.idAlumno +")' " +
			   	    " class='fa fa-trash-o fa-lg' style='cursor:pointer' >" +
			   	"</i>";
	}
	
}

$(document).ready(function() {
	quiz.load();
	$('#btnNuevo').on('click', function(){ quiz.abrirFormularioNuevo(); });
	$('#btnGuardar').on('click', function(){ quiz.guardar(); });
});



