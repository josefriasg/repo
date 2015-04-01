//Initialize function
var init = function () {
    // TODO:: Do your initialization job
    console.log("init() called");
};
$(document).ready(init);

$( document ).on( "click", "#loginButton", function () {
	var email = $("#email").val();
	var password = $("#password").val();
	//onLoading(); 
	$.getJSON("/prueba/Prueba", {action : 'login', email : email, password : password})
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

$( document ).on( "click", "#registerNewUser", function () {
	window.location = "register.html";
});

$( document ).on( "click", "#backToLogin", function () {
	window.location = "index.html";
});

$( document ).on( "click", "#saveUser", function () {
	var name = $("#name").val();
	var email = $("#email").val();
	var password = $("#password").val();
	var confirm = $("#confirmPassword").val();
	$.getJSON("/prueba/Prueba", {action : 'saveUser', name : name, email : email, password : password, confirmPassword : confirm})
	.done(onSaveSuccessfull)
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
	if (data.result=="OK"){
		alert(data.pojo.name);
	}else{
		alert(data.message);
	}
	/*if(data.success){		
		window.location = "main.html";
	} else {
//		$.mobile.showPageLoadingMsg( $.mobile.pageLoadErrorMessageTheme, $.mobile.pageLoadErrorMessage, true );
		onMessage(data)
	}*/
}

function onSaveSuccessfull(data){	
	if (data.result=="OK"){
		alert(data.message);
		window.location = "index.html";
	}else{
		alert(data.message);
	}
	/*if(data.success){		
		window.location = "main.html";
	} else {
//		$.mobile.showPageLoadingMsg( $.mobile.pageLoadErrorMessageTheme, $.mobile.pageLoadErrorMessage, true );
		onMessage(data)
	}*/
}