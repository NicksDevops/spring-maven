function loadView(url)
{
	url = $("#ctxPath").val() + url;
	var response = loadDetailsByAjax(url, "GET", null);
	$("#divWrapper").html(response.respBuffer);
//	fixLayout();
}

function doLogout()
{
	url = $("#ctxPath").val() + "/logout";
	var response = loadDetailsByAjax(url, "GET", null);
	if(response.respCode == '0')
	{
		popUpSuccess("Logging out");
		window.location = $("#ctxPath").val();
	}
	else
	{
		window.location = $("#ctxPath").val();
	}
	
}

function logout(url)
{
	var URL = $("#ctxPath").val() + url;
	var data = loadDetailsByAjax(URL, "GET", null);
	window.location = data.contextPath + "/";
}

function showError(message)
{
	$("#modal-danger").modal("show");
	$("#failureStatus").html(message);
}

function closeError()
{
	$("#modal-danger").modal("hide");
	$("#failureStatus").html('');
}

function showSuccess(message)
{
	$("#modal-success").modal("show");
	$("#successStatus").html(message);
}

function closeSuccess()
{
	$("#modal-success").modal("hide");
	$("#successStatus").html('');
}

function popUpSuccess(message)
{
	showSuccess(message);
	delayedFocus('successBtnClose');
	setTimeout( function(e) {closeSuccess();},3000);
}

function popUpError(message)
{
	showError(message);
	delayedFocus('errorBtnClose');
	setTimeout( function(e) {closeError();},3000);
}


function showWarning(message)
{
	$("#modal-warn").modal("show");
	delayedFocus('warnBtnClose');
	$("#warnStatus").html(message);
}



function closeWarning()
{
	$("#modal-warn").modal("hide");
	$("#warnStatus").html('');
}

function popUpWarning(message)
{
	showWarning(message);
	setTimeout( function(e) {closeWarning();},3000);
}

function popUpWarningWithCallBack(message,callback)
{
	popUpWarning(message);
	setTimeout( callback,3500);

}

function popUpSuccessWithCallBack(message,callback)
{
	popUpSuccess(message);
	setTimeout( callback,3500);

}

function popUpErrorWithCallBack(message,callback)
{
	popUpError(message);
	setTimeout( callback,3500);

}






   

