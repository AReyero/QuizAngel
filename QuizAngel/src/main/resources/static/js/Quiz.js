var quiz= {
		idAlumno : 0,
		idPregunta :0,
		load : function (){
			$.getJSON({
				url:'/Preguntas/SacarPregunta',
				success: function(json){
					quiz.cambiarPregunta(json);
				},
				error : function(err){
					alert("No hay conexion con el servidor")
				}		
			});
		},
		cambiarPregunta:function(json){
			if (json.error!=null){
				alert(json.error);
			
			}
			if(json.dataAlumno!=null){
				this.idAlumno = json.dataAlumno.idAlumno;
				$("#txtAlumno").val(json.dataAlumno.nombre);
			}
			if(json.dataPregunta!=null){
				this.idPregunta = json.dataPregunta.idPregunta;
				$("#txtPregunta").val(json.dataPregunta.pregunta);
				$("#divRespuesta").hide();
				$("#txtRespuesta").val(json.dataPregunta.respuesta);
			}
		},
		verRespuesta : function(){
			$("#divRespuesta").show();
		},
		enviarRespuesta : function(acierto){
			$.getJSON({
				url:'/Preguntas/ResponderPregunta',
				data:{
					idAlumno :this.idAlumno,
					idPregunta: this.idPregunta,
					acierto : acierto
				},
				success : function(json){
					quiz.cambiarPregunta(json);
				},
				error : function(err){
					alert("No hay conexion con el servidor")
				}
			});
		}
}
$(document).ready(function(){
	quiz.load();
	$('#btnVerRespuesta').on('click',function(){ quiz.verRespuesta()});
	$('#btnAcierto').on('click',function(){ quiz.enviarRespuesta(1)});
	$('#btnFallo').on('click',function(){ quiz.enviarRespuesta(0)});
});