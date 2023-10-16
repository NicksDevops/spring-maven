<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">

<body class="hold-transition sidebar-mini">
	<%@include file="Include.jsp"%>
	<div class="wrapper">

		<%@include file="navAndSide.jsp"%>
		<!-- 
		Navbar
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			Left navbar links
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
					class="nav-link">Home</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
					class="nav-link">Contact</a></li>
			</ul>

			Right navbar links
			<ul class="navbar-nav ml-auto">
				<button type="button" class="btn btn-block btn-outline-info">Logout</button>
			</ul>
		</nav> -->
		<!-- /.navbar -->
		<%-- 
		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="#" class="brand-link"> <img
				src="<c:url value="/dist/img/LOGO.jpeg"/>" alt="Integra Logo"
				class="brand-image img-circle elevation-3" style="opacity: .8">
				<span class="brand-text font-weight-light">Integra Micro</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img src="<c:url value="/dist/img/user2-160x160.jpg"/>"
							class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<a href="#" class="d-block">Sachin </a>
					</div>
				</div>

				<!-- SidebarSearch Form -->
				<div class="form-inline">
					<div class="input-group" data-widget="sidebar-search">
						<input class="form-control form-control-sidebar" type="search"
							placeholder="Search" aria-label="Search">
						<div class="input-group-append">
							<button class="btn btn-sidebar">
								<i class="fas fa-search fa-fw"></i>
							</button>
						</div>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item"><a href="#" class="nav-link">

								<p>
									Employee <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="<c:url value="/WEB-INF/views/employeeForm.jsp"/>"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Add Employee</p>
								</a></li>
								<li class="nav-item"><a
									href="../../pages/tables/employeeTable.html" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>view Employee</p>
								</a></li>

							</ul></li>

						<li class="nav-item"><a href="#" class="nav-link">

								<p>
									Project <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="../../pages/forms/projectForm.html" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Add Project</p>
								</a></li>
								<li class="nav-item"><a
									href="../../pages/tables/projectTable.html" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>view Project</p>
								</a></li>

							</ul></li>

						<li class="nav-item"><a href="#" class="nav-link">

								<p>
									Department <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="../../pages/forms/departmentForm.html" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Add Department</p>
								</a></li>
								<li class="nav-item"><a
									href="../../pages/tables/departmentTable.html" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>view Department</p>
								</a></li>

							</ul></li>

						<li class="nav-item"><a href="#" class="nav-link">

								<p>
									Employee-Project <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="../../pages/forms/employeeAssignForm.html"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Assign Project</p>
								</a></li>
								<li class="nav-item"><a
									href="../../pages/tables/employee-project.html"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Employee-Project data</p>
								</a></li>

							</ul></li>

					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>
 --%>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->


			<!-- Main content -->

			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->


		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->



</body>
</html>
