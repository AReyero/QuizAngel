var quiz = {
		load : function (){
			$.getJSON({
				url: '/Preguntas/Ranking',
				success : function(json){
					if (json.error!=null){
						alert(json.error);
					}
					if (json.dataRanking!=null){
						$('#tablaRanking').bootstrapTable('destroy');
						$('#tablaRanking').bootstrapTable({data : json.dataRanking});
					}
				},
				error :function(err){
					alert("No hay conexion con el servidor")
				}
			});
		},
		porcentaje:function(data, row, index){
			var aci=row.aciertos;
			var inte=row.intentos;
			if(inte>0){
				return Math.round(aci/inte*100) +"%";
			
			}else{
				return "-";
			}
		},
};

$(document).ready(function() {	
	quiz.load();
	$('#btn1').on('click', function(){ });
});