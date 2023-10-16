
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<title>Login Page</title>
<body class="hold-transition login-page"  >
	<%@include file="Include.jsp"%>
	
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	<input type="hidden" id="ctxPath" name="ctxPath"
		value="<c:out value="${pageContext.request.contextPath}"/>" />
	<form id="forgotPassword" action="" name="forgotPassword" method="post">
		<input type="hidden" name="method" id="method" />
	</form>
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>Sample</b></a>
			<div>Powered By Integra</div>
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body">

				<div>
					<h5 style="color: darkblue;" class="login-box-msg">
						<b> User Login </b>
					</h5>
				</div>

				<form  action="<%=request.getContextPath()%>/home" modelAttribute="login" method="POST" 
						id="loginForm"  onclick="return validateUserLogin()">
					<div class="form-group has-feedback">
						<input autocomplete="off" id="user_id" type="text"
							class="form-control" placeholder="Login ID"
							style="text-transform: uppercase;" maxlength="20" name="empNo"> <span
							class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input autocomplete="off" id="pwd" type="password"
							class="form-control" placeholder="Password" maxlength="16" name="pwd">
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div id="errorMsg" style="color: red"></div>
					<div class="row">

						<a href="#" onclick="redirectToForgotPassword()">I forgot my
							password</a><br>

						<div class="col-md-8"></div>

						<div class="col-md-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat" >
							Sign In  </button>

						</div>
						
						<div id="errorMessage" style="color: red;">${errorMessage}</div>

						<!-- /.col -->

					</div>
				</form>

			</div>
		</div>
		<!-- /.login-box-body -->
	</div>


	<script type="text/javascript">
		
	function validateUserLogin() 
		{
			$(document).on("submit", "form", function(e)
			{
				var val = true;
				var username = $("#user_id").val().trim();
			    var password = $("#pwd").val().trim();

				  if (username == "") 
				  {
				    //document.getElementById("userName").innerHTML = "Employee Number is required";
				    Swal.fire("Please enter Employe Number");
				    val =  false;
				  } 
				  else if(onlyNumeric(username)==false)
					  {
					  	Swal.fire("Only Numbers are Allowed Login ID");
					  	val = false;
					  }
				  else if (password == "") 
				  {
				    //document.getElementById("pass").innerHTML = "Password is required";
				    Swal.fire("Please enter Password");
				    val =  false;
				  }

				  if(!val)
				 {
					  e.preventDefault();
					  return false;
				 }
			});
		}
		 

	</script>
	
	<!-- <script type="text/javascript">
		window.history.forward();
	</script> -->

	<script type="text/javascript">
		if (window.history && window.history.pushState) {
			window.history.pushState(null, null, window.location.href);
			window.onpopstate = function() {
				window.history.pushState(null, null, window.location.href);
			};
		}
	</script>





</body>


