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
	src="<c:url value="/js/AddProject.js"/>"></script>
	
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
							<div style="color: blue">
								<center>
									<h1>Project Form</h1>
								</center>
							</div>
							<!-- general form elements -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Project details</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form>
									<div class="card-body">

										<div class="form-group">
											<label for="projectName">Project Name<sup
												style="color: red;">*</sup></label> <input type="text"
												class="form-control" id="projectName"
												placeholder="Enter Project Name">
										</div>

										<div class="form-group">
											<label for="projectDescription">Description</label>
											<textarea class="form-control" 
											    id="projectDesc"      rows="3"
												placeholder="Description ..."></textarea>
										</div>

									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<button type="button" class="btn btn-primary"
										 onclick="addProject()" >AddDetails</button>
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
		<!-- /.content-wrapper -->


</body>
</html>
