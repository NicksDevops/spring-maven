<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
	
	<script type="text/javascript"
	src="<c:url value="/js/AssignProject.js"/>"></script>
	
	<style>
	.modal-backdrop
	{
		display:none;
	}
</style>

</head>

<body class="hold-transition sidebar-mini">
	


		<!-- Content Wrapper. Contains page content -->
		<div class="wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2"></div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<div style="color: blue;">
								<center>
									<h1>Employee-Project Form</h1>
								</center>
							</div>
							<!-- general form elements -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Employee Project details</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form>
									<div class="card-body">

										<div class="form-group">
											<label for="education">Employee Name<sup
												style="color: red;">*</sup></label> 
											<select class="form-control" id = "employees">
												<option value ="">----- Select Employee -----</option>
												<c:forEach var="employee" items="${employeeList}">
												<option value="${employee.serialNumber}">${employee.firstName} - ${employee.empNumber}</option>
												</c:forEach>
									
											</select>
										</div>

										<div class="form-group">
											<label for="education">Project Name<sup
												style="color: red;">*</sup></label> 
											<select class="form-control" id="projects">
												<option value = "">------- Select Project ----------</option>
												<c:forEach var="project" items="${projectList}">
												<option value = "${project.projectId}">${project.projectName}</option>
												</c:forEach>
											</select>
										</div>

									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="button" class="btn btn-primary" onclick="assignProject()">
										Assign</button>
									</div>
								</form>
							</div>
							<!-- /.card -->

							<!-- general form elements -->

							<!-- /.card -->

							<!-- Input addon -->
							<div class="card card-info">

								<!-- /.card-body -->
							</div>
							<!-- /.card -->
							<!-- Horizontal Form -->

							<!-- /.card -->

						</div>
						<!--/.col (left) -->
						<!-- right column -->
						<div class="col-md-6">
							<!-- Form Element sizes -->
							<div class="card card-success">

								<!-- /.card-body -->
							</div>
							<!-- /.card -->


							<!-- /.card -->

							<!-- general form elements disabled -->


						</div>
						<!--/.col (right) -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
			</div>
	
		
</body>
</html>
