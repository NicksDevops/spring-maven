function addProject()
{
	var projecttName = $("#projectName").val();
	var projectDesc = $("#projectDesc").val();
	
	var value = true;
	
	if(projecttName.trim() == "" ) 
	{
		value=false;
		showWarning("Please enter Project Name ");
		//alert("Please enter Project Name ");	
	}
	else if(projecttName.length>40)
	{
		value=false;
		showWarning("Project Name should not exceed 40 characters ");
	}
	else if(alfaNumeric(projecttName)==false)
	{
		value=false;
		showWarning("Only AlphaNumerics are Allowed")
	}
	else if(projectDesc.length>200)
	{
		value = false;
		showWarning("Project Desc should not exceed 200 characters ");	
	}
	
	
	if(value)
	{
		var URL = $("#ctxPath").val() + "/project/addProjectPost" ;
		
		var project = 
		{
			"projectName" : projecttName.trim(),
			"projectDesc" : projectDesc
		} ;
		
		alert(" Project : "+JSON.stringify(project));
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(project));
		
		
		if(data.respCode == "00")
		  {
			 //alert("data"+JSON.stringify(data));
			 //showSuccess(data.respMessage);
			 popUpSuccessWithCallBack(data.respMessage, loadView("/project/addProject"));
			
		  }
		  else if(data.respCode== "02")
		  {
			  showWarning(data.respMessage);
		  }
		  else
		  {
			// alert("data"+data.status);
			showError(data.respMessage);
		  }	
	}
}


//  -------------- DELETE PROJECT -----------------

function deleteProject(projectId)
{
	var projId = projectId;
	
	alert("Project ID : "+projId);
	
	$("#hiddenId").val(projId);   //set the value of hidden field with projectId
	
	$("#modal-dange").modal("show");    // show modal to confirm delete
	
}


// --------CONFIRM DELETE---------
function confirmDeleteProject()
{
	
	var projectId = $("#hiddenId").val();
	
	
	if(projectId != null)
	{
		var URL = $("#ctxPath").val() + "/project/deleteProject";
		
		var project = 
						{
							"projectId" : projectId
						}
						
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(project));
		
		if(data.respCode == 00)
		{
			closeError();
			
			//popUpSuccessWithCallBack("Project deleted SuccessFully", loadView("/project/viewProject"));
			//popUpSuccess("Project Deleted Successfully");
			showSuccess("Project Deleted SuccessFully");
			
			loadView("/project/viewProject");
		}
		else
		{
			showError(data.respMessage);
		}
	}
}

// -------- POPULATE FIELDS -----------

function populate(pId, pName, pDesc)
{
	$("#hiddenId").val(pId);
	$("#projectName").val(pName);
	$("#projectDesc").val(pDesc);	
}

// -----------  UPDATE PROJECT -------

function updateProject()
{
	var id = $("#hiddenId").val();
	var name = $("#projectName").val();
	var desc = $("#projectDesc").val();
	
	var value = true;
	
	if(name.trim() == "" ) 
	{
		value=false;
		Swal.fire("Please enter Project Name ")
		
	}
	else if(name.length>40)
	{
		value=false;
		Swal.fire("Project Name should not exceed 40 characters ");
	}
	else if(alfaNumeric(name)==false)
	{
		value=false;
		Swal.fire("Only Alphabets are Allowed")
	}
	else if(desc.length>200)
	{
		value=false;
		Swal.fire("Project Desc should not exceed 200 characters ");
	}
	
	
	if(value)
	{
		var URL = $("#ctxPath").val() + "/project/updateProject" ;
		
		var project = 
		{
			"projectId": id,
			"projectName" : name,
			"projectDesc" : desc,
			"isDeleted" : "N"
		} ;
		
		alert(" Project : "+JSON.stringify(project));
		
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(project));
		
		if(data.respCode == "00")
		  {
			 //alert("data"+JSON.stringify(data));
			 //showSuccess(data.respMessage);
			 popUpSuccessWithCallBack(data.respMessage, loadView("/project/viewProject"));
			
		  }
		  else if(data.respCode == "02")
		  {
			  popUpWarningWithCallBack(data.respMessage, loadView("/project/viewProject"));
		  }
		  else
		  {
			// alert("data"+data.status);
			//popUpError(data.respMessage);
			popUpErrorWithCallBack(data.respMessage, loadView("/project/viewProject"));
		  }	
		
	}
}