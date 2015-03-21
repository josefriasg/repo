//Initialize function
var init = function () {
    // TODO:: Do your initialization job
    console.log("init() called");
};
$(document).ready(init);

$( document ).on( "click", "#loginButton", function () {
	var username = $("#username").val();
	var password = $("#password").val();
	alert(password);
	//onLoading(); 
	$.getJSON("/prueba2/Prueba", {action : 'login', username : username, password : password})
	.done(onLoginSuccessfull)
	.fail(function(data){
		console.log("Error Unexpected. Try again...");	
		alert("Error Unexpected. Try again...");
	})
	.always(function(data){	
		console.log("Finishing proccess on loginForm...");
		offLoading(); 
	}); 
});

function onLoginSuccessfull(data){	
	alert("bien");
	/*if(data.success){		
		window.location = "main.html";
	} else {
//		$.mobile.showPageLoadingMsg( $.mobile.pageLoadErrorMessageTheme, $.mobile.pageLoadErrorMessage, true );
		onMessage(data)
	}*/
}