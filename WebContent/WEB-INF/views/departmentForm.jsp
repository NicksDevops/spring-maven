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
	src="<c:url value="/js/DepartmentAdd.js"/>"></script>
	
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


			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<div style="color: blue;">
								<center>
									<h1>Department Form</h1>
								</center>
							</div>
							<!-- general form elements -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Department details</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form id="userForm">
									<div class="card-body">

										<div class="form-group">
											<label for="deptName">Department Name<sup
												style="color: red;">*</sup></label> 
											<input type="text" class="form-control" id="deptName"
												placeholder="Enter Department Name">
										</div>

										<div class="form-group">
											<label for="description">Description</label>
											<textarea class="form-control" rows="3" id="deptDesc"
												placeholder="Description ..."></textarea>
										</div>

									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="button" class="btn btn-primary" 
										onclick="addDepartment()" >Add Details</button>
									</div>
								</form>
							</div>
							
						

						</div>
						
						
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
	
	
</body>
</html>
