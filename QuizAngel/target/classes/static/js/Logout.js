var quiz={
	
	load: function (){
	},
	
	logout:function(){
		$.getJSON({
			url:'/Auth/Logout',
			data : {
				username: $('#username').val(),
				password: $('#password').val(),
			},
			success : function(json){
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
	$('#btnLogout').on('click', function(){ quiz.logout(); });
});