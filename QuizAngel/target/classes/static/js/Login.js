var quiz={
	
	load: function (){
	},
	
	login:function(){
		alert(54);
		$.getJSON({
			url:'/Auth/Login',
			data : {
				username: $('#username').val(),
				password: $('#password').val(),
			},
			success : function(json){
				alert(45);
				if (json.error !=null){
					alert(json.error)
				}
				if (json.redirect !=null){
					document.location=json.redirect;
				}
			},
			error : function(err){
				alert("No hay conexion con el servidor")
			}
		});
	},
		
}
$(document).ready(function() {
	quiz.load();
	$('#btnlogin').on('click', function(){ quiz.login(); });
});