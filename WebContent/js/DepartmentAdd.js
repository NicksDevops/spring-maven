function addDepartment()
{
	var deptName = $("#deptName").val();
	var deptDesc = $("#deptDesc").val();
	
	var value = true;
	
	if(deptName.trim() == "" ) 
	{
		value=false;
		showWarning("Please enter Dept Name ");
		//alert("Please enter Dept Name ")	
	}
	else if(deptName.length>20)
	{
		value = false;
		showWarning(" Dept Name Cannot exceed 20 Characters ");
	}
	else if(alfaNumeric(deptName)==false)
	{
		value = false;
		showWarning("Enter only AlphaNumeric values in Dept Name");
	}
	else if(deptDesc.length>200)
	{
		value = false;
		showWarning("Dept Desc Cannot exceed 200 Characters ");
	}
	
	
	if(value)
	{
		var URL = $("#ctxPath").val() + "/dept/postAdd" ;
		var department = 
		{
			"deptName" : deptName.trim(),
			"deptDescription" : deptDesc
		} ;
		
		alert(" Department : "+JSON.stringify(department));
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(department));
		
		
		if(data.respCode == "00")
		  {
			 //alert("data"+JSON.stringify(data));
			//showSuccess(data.respMessage);
			popUpSuccessWithCallBack(data.respMessage, loadView("/dept/addDepartment"));
		  }
		  else if(data.respCode == "02")
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


 // ---------- DELETE FUNCTION --------------
 
 function deleteDept(deptId)
 {
	 var departmentId = deptId;
	 
	 alert("Department ID : "+departmentId);
	 
	 // set the value of hidden  field ID
	 $("#hiddenId").val(departmentId);
	 
	 //show modal to confirm delete
	 $("#modal-dange").modal("show");
 }
 
 
 
 //--------------CONFIRM DELETE--------------
 
 function confirmDeleteDept()
{
	//var deptId = deleteLink.match(/deptId=([^&]*)/)[1];
	
	var deptId = $("#hiddenId").val();
	
	if(deptId != null)
	{
		var URL = $("#ctxPath").val() + "/dept/deleteDepartment";
		
		var department = 
						{
							"deptId" : deptId
						}
						
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(department));
		
		if(data.respCode == 00)
		{
			closeError();
			
			//popUpSuccessWithCallBack("Project deleted SuccessFully", loadView("/project/viewProject"));
			popUpSuccess(data.respMessage);
			
			loadView("/dept/viewDepartment");
			
		}
		else
		{
			//closeError();
			$("#modal-dange").modal("hide");
			$("#failureStatus").html('');
			
			popUpError(data.respMessage);
			
			//showError(data.respMessage);
		}
	}
}




//  -------------- POPULATE FIELDS --------------------

function populate(dId,dName,dDesc)
{
	const deptId = dId;
	const deptName = dName;
	const deptDesc = dDesc;
	
	$("#deptId").val(deptId);
	
	$("#deptName").val(deptName);
	
	$("#deptDesc").val(deptDesc);
	
}

//----------- UPDATE DEPARTMENT ---------------

	function updateDepartment()
	{
		var deptId = $("#deptId").val();
		var deptName = $("#deptName").val();
		var deptDesc = $("#deptDesc").val();
		
		var value = true;
	
		if (deptName.trim() == "") {
			value = false;
			Swal.fire("Please enter Dept Name ");
			//alert("Please enter Dept Name ")	
		}
		else if (deptName.length > 20) {
			value = false;
			Swal.fire(" Dept Name Cannot exceed 20 Characters ");
		}
		else if (alfaNumeric(deptName) == false) {
			value = false;
			Swal.fire("Enter only AlphaNumeric values in Dept Name");
		}
		else if (deptDesc.length > 200) {
			value = false;
			Swal.fire("Dept Desc Cannot exceed 200 Characters ");
		}
		
		
		if(value)
		{
			var URL = $("#ctxPath").val() + "/dept/updateDepartment"
			
			var department =
			{
				"deptId" : deptId,
				"deptName": deptName,
				"deptDescription": deptDesc,
				"isDeleted" : "N"
			};
			
			alert("Department : "+ JSON.stringify(department));
			
			var data = loadDetailsByAjax(URL, "POST", JSON.stringify(department));
			
			if(data.respCode == "00")
			{
				popUpSuccessWithCallBack(data.respMessage, loadView("/dept/viewDepartment"));
			}
			else if(data.respCode == "02")
			{
				popUpWarningWithCallBack(data.respMessage, loadView("/dept/viewDepartment"));
			}
			else
			{
				//showError(data.respMessage);
				popUpErrorWithCallBack(data.respMessage, loadView("/dept/viewDepartment"));
			}
			
		}
		
		
	}