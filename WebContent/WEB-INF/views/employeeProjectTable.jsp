<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Integra Micro | employeeProjectTable </title>

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

					<div style="color: blue;">
						<center>
							<h1>
								<b> Employee-Project Table </b>
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

								<!-- /.card-header -->
								<div class="card-body table-responsive p-0">
									<table class="table table-bordered table-striped" id="example1">
										<thead>
											<tr style="background-color: skyblue;">
												<th>Employee Name</th>
												<th>Employee Number</th>
												<th>Project Name</th>

											</tr>
										</thead>
										<tbody>
										<c:forEach var = "emp" items="${empList}">
											<c:forEach var="project" items="${emp.projectDTOList}">
											<tr>
												<td>${emp.firstName}</td>
												<td>${emp.empNumber}</td>
												<td>${project.projectName}</td>
											</tr>
											</c:forEach>
										</c:forEach>
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
		<!-- /.content-wrapper -->
		
	<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
   
  });
</script>
</body>
</html>
