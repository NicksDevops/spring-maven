<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<title>Users</title>
<script type="text/javascript"
	src="<c:url value="/js/EmployeeAdd.js"/>"></script>
	<script type="text/javascript"
	src="<c:url value="/js/common.js"/>"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.7.1.min.js"></script>
<input type="hidden" id="ctxPath" name="ctxPath"
	value="<c:out value="${pageContext.request.contextPath}"/>" />
<input type="hidden" id="operation" value="<c:out value="${optn}"/>" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<!-- Horizontal Form -->
				<div class="box box-info" id="add_update_view">
					<div class="box-header with-border">
						<h3 id="page_header" class="box-title">Employee Creation</h3>
						<button id="back_btn" type="button"
							onclick="goToPrevPage('add_update_view')" style="display: none;"
							class="btn btn-default pull-right glyphicon glyphicon-arrow-left"></button>
					</div>
					<!-- form start -->
					<form class="form-horizontal" id="userForm">
						<div class="box-body">
						<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label">Employee No<b><span style="color: red;">*</span></b></label>
									
								<div class="col-sm-5">
									<input type="text" class="form-control" id="empNo" style="text-transform: lowercase"
										required="required" tabindex="1" required="required" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label">First
									Name<b><span style="color: red;">*</span></b></label>
									
								<div class="col-sm-5">
									<input type="text" class="form-control" id="firstName" style="text-transform: uppercase"
										required="required" tabindex="1" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label">Middle
									Name<b><span style="color: red;">*</span></b></label>
									
								<div class="col-sm-5">
									<input type="text" class="form-control" id="middleName" style="text-transform: uppercase"
										required="required" tabindex="1" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label">Last
									Name<b><span style="color: red;">*</span></b></label>
									
								<div class="col-sm-5">
									<input type="text" class="form-control" id="lastName" style="text-transform: uppercase"
										required="required" tabindex="1" required="required" />
								</div>
							</div>
							
						</div>
						
						<div id="form_footer" class="box-footer">
								<button id="btn_type" onclick="addEmployee()" type="button"
									class="btn btn-info" tabindex="6">Add</button>
							</div>
					</form>
					
					<p id="demo"></p>
				</div>

				
			</div>
		</div>
		
	</section>
</div>