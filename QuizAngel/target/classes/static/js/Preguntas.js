var quiz = {
	idPregunta : 0,
	
	//Al iniciar la página
	load : function (){
		$.getJSON({
			url: '/Admin/Preguntas/Listar',
			success : function(json){
				quiz.mostrarLista(json);
			},
			error : function(err){
				alert("No hay conexion con el servidor")
			}
		});
	},

	//Reutilización para refrescar la lista
	mostrarLista : function(json){
		if (json.error!=null){
			alert(json.error);
		}
		if (json.dataPreguntas!=null){
			$('#tablaPreguntas').bootstrapTable('destroy');
			$('#tablaPreguntas').bootstrapTable({ data : json.dataPreguntas });
		}
    },

	//Abre el formulario en modo nuevo
    abrirFormularioNuevo : function(){
		quiz.idPregunta=0;
		$("#txtPregunta").val('');		
		$("#txtRespuesta").val('');
		$("#divPregunta").modal();
	},

	//Abre el formulario en modo edicion
	abrirFormularioEditar : function(idPregunta){
		quiz.idPregunta=idPregunta;
		
		$.getJSON({
			url: '/Admin/Preguntas/Leer',
			data : {
				idPregunta: idPregunta
			},
			success : function(json){
				if (json.error!=null){
					alert(json.error);
				}
				if (json.dataPregunta!=null){
					quiz.idPregunta=json.dataPregunta.idPregunta;
					$("#txtPregunta").val(json.dataPregunta.pregunta);
					$("#txtRespuesta").val(json.dataPregunta.respuesta);
					$("#divPregunta").modal();
				}
			},
			error : function(err){
				alert("No hay conexion con el servidor");
			}
		});
	},

	//Guarda el elemento del formulario
	guardar : function(){
		$.getJSON({
			url: '/Admin/Preguntas/Guardar',
			data: {
				idPregunta : quiz.idPregunta,
				preguntaConf : $("#txtPregunta").val(),
				respuesta : $("#txtRespuesta").val()
			},
			success : function(json){
				quiz.mostrarLista(json);				
				$("#divPregunta").modal("hide");
			},
			error : function(err){
				alert("No hay conexion con el servidor");
			}
		});
	},


	//Borra el elemento recibido
	borrar : function(idPregunta){
		if (confirm('¿Está seguro que desea borrar esta pregunta?')){
			$.getJSON({
				url: '/Admin/Preguntas/Borrar',
				data: {
					idPregunta : idPregunta
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
		return "<i onclick='quiz.abrirFormularioEditar("+ row.idPregunta +")' " +
					" class='fa fa-edit fa-lg' style='cursor:pointer'>" + 
				"</i> " +
			    "<i onclick='quiz.borrar("+ row.idPregunta +")' " +
			   	    " class='fa fa-trash fa-lg' style='cursor:pointer' >" +
			   	"</i>";
	}
	
}

$(document).ready(function() {
	quiz.load();
	$('#btnNuevo').on('click', function(){ quiz.abrirFormularioNuevo(); });
	$('#btnGuardar').on('click', function(){ quiz.guardar(); });
});



