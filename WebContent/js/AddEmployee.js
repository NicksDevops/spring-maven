// -------------- Add Function ------------------

function addEmployee()
{
	var empNumber = $("#empNumber").val();
	var firstName = $("#firstName").val();
	var middleName = $("#middleName").val();
	var lastName = $("#lastName").val();
	var gender = $("input[name='gender']:checked").val();
	var education = $("#education").val();
	var deptId = $("#departmentName").val();      // select dept name  will save dept_id  in db.
	var married =  $("input[name='married']:checked").val();
	var address = $("#address").val();
	var password = $("#password").val();
	var isAdmin = $("input[name='isAdmin']:checked").val();
	
	var value = true;
	
	if(empNumber.trim() == "" || empNumber == null)
	{
		value = false;
		showWarning("Please Enter Employee Number ");
	}
	else if(empNumber.length>10)
	{
		value = false;
		showWarning("Employee Number Cannot Exceed 10 Digitd");
	}
	else if (onlyNumeric(empNumber) == false) 
	{
		value = false;
		showWarning("Only Numbers Are Allowed In Employee Number");
	}
	else if(firstName.trim() == "" ) 
	{
		value=false;
		//alert("Please enter First Name ")
		showWarning("Please enter First Name ");	
	}
	else if(firstName.length>25)
	{
		value = false;
		showWarning("First Name Cannot Exceed 25 Digits");
	}
	else if(checkOnlyAlfa(firstName)==false)
	{
		value = false;
		showWarning("Only Alphabets are allowed in First Name");
	}
	else if(middleName.length>25)
	{
		value = false;
		showWarning("Middle Name Cannot Exceed 25 Characters");
	}
	else if( middleName.trim()!="" && checkOnlyAlfa(middleName)==false)
	{
		value = false;
		showWarning("Only Alphabets are allowed in Middle Name");
	}
	else if(lastName.trim()=="")
	{
		value=false;
		//alert("Please enter Last Name")
		showWarning("Please enter Last Name ");
	}
	else if(lastName.length>25)
	{
		value = false;
		showWarning("Last Name Cannot Exceed 25 Characters");
	}
	else if( checkOnlyAlfa(lastName)==false)
	{
		value = false;
		showWarning("Only Alphabets are allowed in Last Name");
	}
	else if(gender == null)
	{
		value= false;
		//alert("Please select Gender");
		showWarning("Please select Gender");
	}
	else if(education == "")
	{
		value= false;
		//alert("Please select Education")
		showWarning("Please select Education");
		
	}
	else if(deptId == "")
	{
		value = false;
		//alert("Please select Department Name")
		showWarning("Please select Department Name");
	}
	else if(married == null)
	{
		value = false;
		//alert("Please select married?")
		showWarning("Please select Married?");
	}
	else if(address.trim() == "" || address == null)
	{
		value = false;;
		//alert("Please enter Adress");
		showWarning("Please Enter Address");
	}
	else if(address.length>200)
	{
		value = false;
		showWarning("Adress cannot exceed 200 characters");
	}
	else if(password.trim() == "" || password == null)
	{
		value = false;;
		//alert("Please enter Password");
		showWarning("Please Enter Password");
	}
	else if(password.length>20)
	{
		value = false;
		showWarning("Password Cannot Exceed 20 Characters");
	}
	else if(validatePassword(password) == false)
	{
		value = false;
		showWarning("PassWord Must Contan 8 haracters, 1 UpperCase, 1 lowerCase, 1 Number, 1 Special Character")
	}
	else if(isAdmin == null)
	{
		isAdmin = "N";
		
	}
		
	
	if(value)
	{
		var URL = $("#ctxPath").val() + "/employee/showEmployeePost" ;
		
		var employee = 
		{
			"empNumber" : empNumber,
			"firstName" : firstName,
			"middleName" : middleName,
			"lastName" : lastName,
			"gender" : gender,
			"edution" : education,
			"address" : address,
			"married" :married,
			"dept_id" : deptId,
			"password": password,
			"isAdmin": isAdmin
				
		} 
		
		alert(" Employee : "+JSON.stringify(employee));
		
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(employee));
		
		
		if(data.respCode == "00")
		  {
			 //alert("data"+JSON.stringify(data));
			 //showSuccess(data.respMessage);
			 popUpSuccessWithCallBack(data.respMessage, loadView("/employee/reqEmployee"));
			
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

//   --------Delete Function ---------------

function deleteEmployee(empNo)
{
		var employeeNumber = empNo;
		
		//alert("Employee number : "+ employeeNumber);
		
		// set the hidden field value
		$("#hiddenField").val(employeeNumber);
		
		//show modal to confirm delete
		$("#modal-dange").modal("show");
		
		
}


// ---------- CONFIRM DELETE -----------

function confirmDeleteEmployee()
{
	//showWarning("Are you sure You Want to delete! ");
	
	var empNo = $("#hiddenField").val();
	
	
	
	if(empNo != null)
	{
		var URL = $("#ctxPath").val() + "/employee/deleteEmployee";
		
		var employee = 
						{
							"empNumber" :empNo
						}
						
		var data = loadDetailsByAjax(URL, "POST", JSON.stringify(employee));
		
		if(data.respCode == 00)
		{
			closeError();
			
			showSuccess(data.respMessage);
			
			loadView("/employee/viewEmployee");
			//popUpSuccessWithCallBack("Employee deleted SuccessFully", loadView("/employee/viewEmployee"));
		}
		else
		{
			//showError(data.respMessage);
			popUpErrorWithCallBack(data.respMessage, loadView("/employee/viewEmployee"));
		}
	}	
//	showSuccess("Employee Details Deleted Successfully..");
}



// ---------- POPULATE FIELDS -----------
function populate(slNo, empNo, fName, mName, lName, gender, education, dName, married, address, pwd, admin)
{
	$("#hiddenSlNo").val(slNo);
	$("#empNumber").val(empNo);
	$("#firstName").val(fName);
	$("#middleName").val(mName);
	$("#lastName").val(lName);
	
// 	gender
  	$("input[name='gender'][value='" + gender + "']").prop("checked", true);
	
	$("#education").val(education);
	$("#departmentName").val(dName);
	
//	married
	var mar = married;
	$("input[name='married']").each(function() {
		if ($(this).val() === mar) {
			$(this).prop("checked", true);
		} else {
			$(this).prop("checked", false);
		}
	});
		
	$("#address").val(address);
	$("#password").val(pwd);
	$("#isAdmin").val(admin);

//	isAdmin	
	/*$("input[name='isAdmin']").each(function() {
		if ($(this).val() === admin) {
			$(this).prop("checked", true);
		} else {
			$(this).prop("checked", false);
		}
	}); */
}

//----------------- UPDATE FIELDS -------------

function updateEmployee()
{
	 var slNo = $("#hiddenSlNo").val();
	 var empNo = $("#empNumber").val();
	 var fName = $("#firstName").val();
	 var mName = $("#middleName").val();
	 var lName = $("#lastName").val();
	 var gender = $("input[name='gender']:checked").val();
	 var education = $("#education").val();
	 var dId = $("#departmentName").val();
	 var married = $("input[name='married']:checked").val();
	 var address = $("#address").val();
	 var pwd = $("#password").val();
	 var admin = $("input[name='isAdmin']:checked").val();
	 
	 var value = true;
	
	if(empNo.trim() == "" || empNo == null)
	{
		value = false;
		alert("Please enter Employee Number ");
		//showWarning("Please enter Employee Number ");
		
	}
	if (onlyNumeric(empNo) == false) 
	{
		value = false;
		Swal.fire("Only Numbers Are Allowed");
		//showWarning("Only Numbers Are Allowed");
	}
	else if(fName.trim() == "" ) 
	{
		value=false;
		//alert("Please enter First Name ");
		Swal.fire("Enter First Name");
		//showWarning("Please enter First Name ");	
	}
	else if(fName.length>25)
	{
		value = false;
		Swal.fire("First Name Cannot Exceed 25 Digits");
	}
	else if(checkOnlyAlfa(fName)==false)
	{
		value = false;
		Swal.fire("Only Alphabets are allowed in First Name");
	}
	else if( mName.trim()!="" && checkOnlyAlfa(mName)==false)
	{
		value = false;
		alert("Only Alphabets are allowed in Middle Name");
		//showWarning("Only Alphabets are allowed in Middle Name");
	}
	else if(lName.trim()=="")
	{
		value=false;
		Swal.fire("Please enter Last Name")
		//showWarning("Please enter Last Name ");
	}
	else if(lName.length>25)
	{
		value = false;
		Swal.fire("Last Name Cannot Exceed 25 Digits");
	}
	else if(checkOnlyAlfa(lName)==false)
	{
		value = false;
		Swal.fire("Only Alphabets are allowed in Last Name");
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
		//alert("Please select Education")
		Swal.fire("Please select Education");
		
	}
	else if(dId == "")
	{
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
		value = false;;
		Swal.fire("Please enter Adress");
		//showWarning("Please Enter Address");
	}
	else if(address.length>200)
	{
		value = false;
		Swal.fire("Adress cannot exceed 200 characters");
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
		Swal.fire("Password cannot exceed 20 characters");
	}
	/*else if(validatePassword(pwd) == false)
	{
		value = false;
		Swal.fire("PassWord Must Contan 8 haracters, 1 UpperCase, 1 lowerCase, 1 Number, 1 Special Character")
	}*/
	else if(admin == null)
	{
		admin = "N";
		
	}
	
	 
	 
	 if(value)
	 {
		 var URL = $("#ctxPath").val() + "/employee/updateEmployee" ;
		
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
		
		
		if(data.respCode == "00")
		  {
			 //alert("data"+JSON.stringify(data));
			 //showSuccess(data.respMessage);
			 popUpSuccessWithCallBack(data.respMessage, loadView("/employee/viewEmployee"));	
		  }
		  else if(data.respCode == "02")
		  {
			  popUpWarningWithCallBack(data.respMessage, loadView("/employee/viewEmployee"));
		  }
		  else
		  {
			// alert("data"+data.status);
			//showError(data.respMessage);
			popUpErrorWithCallBack(data.respMessage, loadView("/employee/viewEmployee"));
		  }	
	 }
}