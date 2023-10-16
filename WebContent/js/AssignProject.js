
function assignProject()
{
	var slNo = $("#employees").val();
	var proId = $("#projects").val();
	
	var value = true;
	
	if(slNo == "") 
	{
		value=false;
		alert("Please Select Employee ");
	}
	else if(proId == "")
	{
		value = false;
		alert("Please Select Project ");
	}
	
	//alert("---"+slNo +" And "+proId);
	
	if(value)
	{
		var URL = $("#ctxPath").val() + "/empProject/assignEmpProjectPost" ;
		
		var empProject = 
		{
			"serialNumber" : slNo,
			"projectId": proId
		} ;
		
		alert(" Project : "+JSON.stringify(empProject));
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(empProject));
		
		
		if(data.respCode == 00)
		  {
			 //alert("data"+JSON.stringify(data));
			 showSuccess(data.respMessage);
			 loadView("/empProject/viewEmpProject")
			 //popUpSuccessWithCallBack(data.respMessage, loadView("/empProject/viewEmpProject"));
			
		  }
		  else if(data.respCode == 02)
		  {
			   popUpWarningWithCallBack(data.respMessage, loadView("/empProject/viewEmpProject"));
		  }
		  else
		  {
			// alert("data"+data.status);
			showError(data.respMessage);
		  }	
	}
}


