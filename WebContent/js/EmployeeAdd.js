function addEmployee()
{
	if($("#firstName").val() == "") 
	{
		alert("Please Enter first Name");
	}
	else if($("#middleName").val() == "") 
	{
		alert("Please Enter Middle Name");
	}
	else if($("#lastName").val() == "") 
	{
		alert("Please Enter Last Name");
	}
	else if($("#empNo").val() == "") 
	{
		alert("Please Enter Employee Number");
	}
	else
		{
			var URL = $("#ctxPath").val() + "/employee/add";
			var employee = {};
			employee.firstName =$("#firstName").val();
			employee.middleName =$("#middleName").val();
			employee.lastName =$("#lastName").val();
			employee.empNo = $("#empNo").val();
//			alert("employee ss: "+JSON.stringify(employee));
		 	var data = loadDetailsByAjax(URL, "POST", JSON.stringify(employee));
		 	$("#userForm").hide(); 
		 	document.getElementById("demo").innerHTML =data;
		}
	
 	
}