<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Integra | Employee Tables</title>

<script type="text/javascript"
	src="<c:url value="/js/userUpdate.js"/>"></script>
	
<style>
	.modal-backdrop
	{
		display:none;
	}
</style>

<script type="text/javascript">

</script>

</head>
<body class="hold-transition sidebar-mini">

		<!-- Content Wrapper. Contains page content -->
		<div class="wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">

					<div style="color: blue;">
						<center>
							<h1>
								<b> Employee Information </b>
							</h1>
						</center>
					</div>

				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">

					<!-- /.row -->
					<div class="row">
						<div class="col-12">
							<div class="card">
									
								<input type="hidden" id="emp" name="emp" value="<c:out value="${employeeDetai1}"/>">
								<!-- /.card-header -->
								<div class="card-body table-responsive p-0">
									<!--<table class="table table-hover table-bordered"  id="example1" > -->
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr style="background-color: skyblue;">
												<th>emp No</th>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Gender</th>
												<th>Education</th>
												<th>Dept Name</th>
												<th>Married</th>
												<th>Update</th>
											
											</tr>
										</thead>
										<tbody>

											<tr>
												<td>${employeeData.empNumber}</td>
												<td>${employeeData.firstName}</td>
												<td>${employeeData.lastName}</td>
												<td>${employeeData.gender}</td>
												<td>${employeeData.edution }</td>
												<td>${employeeData.deptDTO.deptName}</td>
												<td>${employeeData.married }</td>
											
												<td>
													<button class="btn btn-primary" data-item-id="1"
														data-toggle="modal" data-target="#modal-default"
														onclick="populate()">Update
													</button>
												</td>
											</tr>
							
										</tbody>
									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
					</div>


				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
	
	
<!--  UPDATE MODAL START-->

      <div class="modal fade" id="modal-default">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">Employee Form for Update</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <!-- <p>One fine body&hellip;</p> -->
					
								<form>
									<div class="card-body">
										
										<input type = "hidden" id = "hiddenSlNo" value ="">
										
										<div class="form-group">
											<label for="empNumber">Employee Number<sup
												style="color: red;">*</sup></label> 
											<input type="text" class="form-control" id="empNumber"
												placeholder="Enter Employee No" disabled="disabled">
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
											<select class="form-control select2" id ="education" >
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
											<select class="form-control" id="deptName" disabled="disabled">
											<option value ="" >------ select the depeartment ----</option>
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
											<label for ="Show Password" name ="Show Password"> Show Password</label>
										</div>
										
										<div class="form-group">
											<div class="form-check">
											
											<input class="form-check-input" type="checkbox" name="isAdmin" id="admin" value="Y" disabled="disabled">
											<label for="married" for ="admin">Is Admin ?<sup style="color: red;" name="isAdmin">*</sup></label>	
											</div>
										</div>



									</div>
									<!-- /.card-body -->
									<!-- <div class="card-footer">
										<button type="button" class="btn btn-primary"
										    onclick ="addEmployee()" >Add Details</button>
									</div> -->
								</form>
					
				</div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary" onclick="updateUser()">Save changes</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>

<!--  UPDATE MODAL START-->


	<div class="modal fade" id="modal-dange">
        <div class="modal-dialog">
          <div class="modal-content bg-danger">
            <div class="modal-header">
              <h4 class="modal-title">Danger Modal</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
            	<input type="hidden" id="hiddenField" name="hiddenField" value="" >
              <p>Are You Sure You Want To Delete? </p>
              
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-outline-light" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-outline-light"   onclick="confirmDeleteEmployee()">Yes</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
         <!-- /.modal-dialog -->
      </div>
	

		<!-- <script>
			var deleteLink = '${deleteLink}'
		</script> -->
	

	<!-- <script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    
  });
</script> -->

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




</body>
</html>
