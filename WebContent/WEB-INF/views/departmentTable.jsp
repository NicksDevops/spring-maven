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
			<section class="content-header">
				<div class="container-fluid">

					<div style="color: blue;">
						<center>
							<h1>
								<b> Department Table </b>
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
									<!--<table class="table table-hover table-bordered">-->
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr style="background-color: skyblue;">
												<th>Dept ID</th>
												<th>Dept Name</th>
												<th>Description</th>
												<th>Update</th>
												<th>Delete</th>

											</tr>
										</thead>
										<tbody>
										<c:forEach var="department" items = "${departmentList}">
											<tr> 
												<td>${department.deptId}</td>
												<td>${department.deptName}</td>
												<td>${department.deptDescription}</td>
												<td>
												<button class="btn btn-primary" data-item-id="1" data-toggle="modal" data-target="#modal-default"
													onclick="populate(${department.deptId},'${department.deptName}','${department.deptDescription}')">Update
												</button>
												</td>
												<td>
												<button class="btn btn-danger delete-item" data-item-id="1"
												onclick="deleteDept(${department.deptId})"	>Delete</button>
												</td>
											</tr>
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
		

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		
		
		
		<!------------- Modal Starts----------------->
		<div class="modal fade" id="modal-default">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">Department Form For Update</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <!-- <p>One fine body&hellip;</p> -->
              
              				<form id="userForm">
									<div class="card-body">
										
										<input type = "hidden" id="deptId" value="">
										
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

									<!-- <div class="card-footer">
										<button type="button" class="btn btn-primary" 
										onclick="addDepartment()" >Add Details</button>
									</div> -->
								</form>
              
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary" onclick="updateDepartment()">Save changes</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
		
		
		<!------------- Modal Ended----------------->
		
		<div class="modal fade" id="modal-dange">
        <div class="modal-dialog">
          <div class="modal-content bg-warning">
            <div class="modal-header">
              <h4 class="modal-title">WARNING</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            	
            	<input type="hidden" id="hiddenId" name="hiddenId" value="">
            	
               <p>Are you sure U want to delete!</p>
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-outline-dark" onclick="confirmDeleteDept()">Yes</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      
      <!-- <script >
      	var deleteLink = '${deleteLink}'
      </script> -->
		
	
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
