
// -- Populate Fields -----

function populate()
{
	var emp = $("#emp").val();
	alert("Employee - "+emp);
	
	var employee=JSON.parse($("#emp").val()); // object is in string format parse it to object format
	
//	alert("employee - "+employee.firstName);
//	alert("employee no - "+employee.empNumber);
	
	//alert(employee.deptDTO.deptName);
	
	$("#hiddenSlNo").val(employee.serialNumber);
	$("#empNumber").val(employee.empNumber);
	$("#firstName").val(employee.firstName);
	$("#middleName").val(employee.middleName);
	$("#lastName").val(employee.lastName);
	// 	gender
  	$("input[name='gender'][value='" + employee.gender + "']").prop("checked", true);
	
	$("#education").val(employee.edution);
	
	var deptName = employee.dept_id; 
	$("#deptName").val(deptName);
	
	//	married
	var mar = employee.married;
	$("input[name='married']").each(function() {
		if ($(this).val() === mar) {
			$(this).prop("checked", true);
		} else {
			$(this).prop("checked", false);
		}
	});
		
	$("#address").val(employee.address);
	$("#password").val(employee.password);
	
	//	isAdmin	
	var admin = employee.isAdmin;
	$("input[name='isAdmin']").each(function() {
		if ($(this).val() === admin) {
			$(this).prop("checked", true);
		} else {
			$(this).prop("checked", false);
		}
	}); 
}


// ---------- UPDATE USER ------------

function updateUser()
{
	 var slNo = $("#hiddenSlNo").val();
	 var empNo = $("#empNumber").val();
	 var fName = $("#firstName").val();
	 var mName = $("#middleName").val();
	 var lName = $("#lastName").val();
	 var gender = $("input[name='gender']:checked").val();
	 var education = $("#education").val();
	 var dId = $("#deptName").val();
	 
	 alert("dept - "+dId);
	 
	 var married = $("input[name='married']:checked").val();
	 var address = $("#address").val();
	 var pwd = $("#password").val();
	 var admin = $("input[name='isAdmin']:checked").val();
	 
	 var value = true;
	
	if(empNo.trim() == "" || empNo == null)
	{
		value = false;
		Swal.fire("Please enter Employee Number ");
		//showWarning("Please enter Employee Number ");
		
	}
	else if (onlyNumeric(empNo) == false) 
	{
		value = false;
		Swal.fire("Only Numbers Are Allowed");
		//showWarning("Only Numbers Are Allowed");
	}
	else if(fName.trim() == "" ) 
	{
		value=false;
		Swal.fire("Please enter First Name ");
		//showWarning("Please enter First Name ");	
	}
	else if(fName.length>25)
	{
		value=false;
		Swal.fire("First Name Cannot Exceed 25 Characters");	
	}
	else if(checkOnlyAlfa(fName)==false)
	{
		value = false;
		Swal.fire("Only Alphabets are allowed in First Name");
		//showWarning("Only Alphabets are allowed in First Name");
	}
	else if( mName.trim()!="" && checkOnlyAlfa(mName)==false)
	{
		value = false;
		Swal.fire("Only Alphabets are allowed in Middle Name");
		//showWarning("Only Alphabets are allowed in Middle Name");
	}
	else if(mName.length>25)
	{
		value=false;
		Swal.fire("Middle Name Cannot Exceed 25 Characters");
	}
	else if(lName.trim()=="")
	{
		value=false;
		Swal.fire("Please enter Last Name")
		//showWarning("Please enter Last Name ");
	}
	else if(lName.length>25)
	{
		value=false;
		Swal.fire("Last Name Cannot Exceed 25 Characters");
	}
	else if( checkOnlyAlfa(lName)==false)
	{
		value = false;
		Swal.fire("Only Alphabets are allowed in Last Name");
		//showWarning("Only Alphabets are allowed in Last Name");
	}
	else if(gender == null)
	{
		value= false;
		Swal.fire("Please select Gender");
		//showWarning("Please select Gender");
	}
	else if(education == "")
	{
		value= false;
		Swal.fire("Please select Education")
		//showWarning("Please select Education");
		
	}
	else if(dId == "")
	{
		//alert("Inside did else if loop - ")
		value = false;
		Swal.fire("Please select Department Name")
		//showWarning("Please select Department Name");
	}
	else if(married == null)
	{
		value = false;
		Swal.fire("Please select married?")
		//showWarning("Please select Married?");
	}
	else if(address.trim() == "" || address == null)
	{
		value = false;
		Swal.fire("Please enter Adress");
		//showWarning("Please Enter Address");
	}
	else if(pwd.trim() == "" || pwd == null)
	{
		value = false;;
		Swal.fire("Please enter Password");
		//showWarning("Please Enter Password");
	}
	else if(pwd.length>20)
	{
		value = false;
		Swal.fire("Password Cannot Exceed 20 Characters");
	}
	else if(admin == null)
	{
		admin = "N";
		
	}

	
	 if(value)
	 {
		 var URL = $("#ctxPath").val() + "/userEmp/updateUser" ;
		
		var employee = 
		{
			"serialNumber" : slNo,
			"empNumber" : empNo,
			"firstName" : fName,
			"middleName" : mName,
			"lastName" : lName,
			"gender" : gender,
			"edution" : education,
			"address" : address,
			"married" :married,
			"dept_id" : dId,
			"password": pwd,
			"isAdmin": admin,
			"isDeleted": "N"
				
		} 	
		
		alert(" Employee : "+JSON.stringify(employee));
		
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(employee));
		
		
		if(data.respCode == 00)
		  {
			 //alert("data"+JSON.stringify(data));
			 showSuccess(data.respMessage);
			 //popUpSuccessWithCallBack(data.respMessage, loadView("/userEmp/viewUserEmployee"));
			   loadView("/userEmp/viewUserEmployee/"+slNo);
		  }
		  else
		  {
			// alert("data"+data.status);
			//showError(data.respMessage);
			popUpErrorWithCallBack(data.respMessage, loadView("/userEmp/viewUserEmployee/"+slNo));
		  }	
	}
}

