<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>

<style>
	.modal-backdrop
	{
		display:none;
	}
</style>

<script type="text/javascript"
	src="<c:url value="/js/AddEmployee.js"/>"></script>

</head>

<body class="hold-transition sidebar-mini" >
	

		<!-- Content Wrapper. Contains page content -->
		<div class="wrapper" >
			

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<div style="color: blue">
								<center>
									<h1>Employee Form</h1>
								</center>
							</div>
							<!-- general form elements -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Employee details</h3>
								</div>
							
								<!-- form start -->
								<form>
									<div class="card-body">

										<div class="form-group">
											<label for="empNumber">Employee Number<sup
												style="color: red;">*</sup></label> 
											<input type="text" class="form-control" id="empNumber"
												placeholder="Enter Employee No">
										</div>
										
										<div class="form-group">
											<label for="firstName">First Name<sup
												style="color: red;">*</sup></label> 
											<input type="text" class="form-control" id="firstName"
												placeholder="Enter First Name">
										</div>

										<div class="form-group">
											<label for="middleName">Middle Name</label> 
											<input type="text" class="form-control" id="middleName"
												placeholder="Enter Middle Name">
										</div>

										<div class="form-group">
											<label for="lastName">Last Name<sup
												style="color: red;">*</sup></label> 
											<input type="text" class="form-control" id="lastName"
												placeholder="Enter Last Name">
										</div>

										<div class="form-group ">
											<label for="gender">Gender<sup style="color: red;">*</sup></label>
											<div class="col-md-8">
												<div class="form-check">
													<input class="form-check-input" type="radio" name="gender"
														id="radio1" value="M"> 
													<label class="form-check-label" for="radio1">Male</label> 
														&ensp; &ensp; &ensp; 
													<input class="form-check-input" type="radio"
														name="gender" id="radio2" value="F"> 
													<label class="form-check-label" for="radio2">Female</label>
													&ensp; &ensp; &ensp; 
													<input class="form-check-input"
														type="radio" name="gender" id="radio3" value="O">
													<label class="form-check-label" for="radio3">Other</label>
													&ensp; &ensp; &ensp;
												</div>
											</div>
										</div>

										<div class="form-group">
											<label for="education">Education<sup
												style="color: red;">*</sup></label> 
											<select class="form-control select2" id ="education">
												<option value="">---- select Education ---</option>
												<option value="B.E.">B.E.</option>
												<option value="BSc">BSc</option>
												<option value="MSc">MSc</option>
												<option value="BCA">BCA</option>
												<option value="MCA">MCA</option>
											</select>
										</div>

										<div class="form-group">
											<label for="deptName">Department Name<sup
												style="color: red;">*</sup></label>
											<select class="form-control" id="departmentName">
											<option value ="">------ select the depeartment ----</option>
												<c:forEach var="deptNames" items="${deptData}">
													<option value="${deptNames.deptId}">${deptNames.deptName}</option>
												</c:forEach>
											</select>
										</div>

										<div class="form-group">
											<label for="married">Married?<sup style="color: red;">*</sup></label>
											<div class="form-check">
												<input class="form-check-input" type="checkbox" name="married" id="option1" value="Y"> 
												<label class="form-check-label" for ="option1">Married</label> 
												&ensp; &ensp; &ensp; 
												<input class="form-check-input" type="checkbox" name="married" id="option2" value="N">
												<label class="form-check-label" for="option2">Unmarried</label>
											</div>
										</div>

										<div class="form-group">
											<label for="adress">Adress<sup style="color: red;">*</sup></label>
											<textarea class="form-control" rows="3"
												placeholder="Adress ..." id="address"></textarea>
										</div>
										
										<div class="form-group">
											<label for="password">Password<sup
												style="color: red;">*</sup></label> 
											<input type="password" class="form-control" id="password"
												placeholder="Enter Password">
											<input type="checkbox" id="showPassword">
											<label for ="Show Password" name = "Show Password"> Show Password</label>
										</div>
										
										<div class="form-group">
											<div class="form-check">
											
											<input class="form-check-input" type="checkbox" name="isAdmin" id="admin" value="Y">
											<label for="married" for ="admin" name="Is Admin ?">Is Admin ?<sup style="color: red;" name="isAdmin">*</sup></label>	
											</div>
										</div>



									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="button" class="btn btn-primary"
										    onclick ="addEmployee()" >Add Details</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$('input[type=checkbox]').click(function() {
			var checkboxes = $('input[name=' + this.name + ']');
			checkboxes.not(this).prop('checked', false);
		});
	});
</script>

<script>

	var passwordField = document.getElementById("password");
	//const showPasswordCheckbox = document.getElementById("showPassword");

	$('input[id=showPassword]').change(function(){
		if (this.checked) {
			passwordField.type = "text";
		} else {
			passwordField.type = "password";
		}
	});
</script>

</html>
