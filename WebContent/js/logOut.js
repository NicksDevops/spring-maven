
function logout()
{
	
	//showWarning("Are you Sure Yoy Want to Logout!");
	/*$("#modal-warning").modal("show");
	delayedFocus('warnBtnClose');
	$("#warnStatus").html("Are you Sure Yoy Want to Logout!");*/
	//window.location.href = "${pageContext.request.contextPath}/" ;
	//window.location.href = contextPath + "/";
	window.location.href = $("#ctxPath").val();
}

