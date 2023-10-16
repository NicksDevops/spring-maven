<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title> Integra Micro </title>
   <%@include file="Include.jsp"%>
   
   <script type="text/javascript"
	src="<c:url value="/js/common.js"/>"></script>
   
</head>

   <input type="hidden" id="ctxPath" name="ctxPath"
	value="<c:out value="${pageContext.request.contextPath}"/>" />
	
	<input type="hidden" id="empId" name="empId" value="<c:out value="${empData.serialNumber}"/>" >
	
<body class="hold-transition sidebar-mini">

<div class="wrapper">
<%@include file="userHeader.jsp"%>

	<div class="content-wrapper" id="divWrapper" >
		<br>
 		<!-- <h1>Integra Sample Project</h1> -->
 		<img src="${pageContext.request.contextPath}/dist/img/welcome2.jpg" alt="Welcome Image"
 		   style="max-width: 100%; max-height: 100%; object-fit: contain;">
	
	</div>
 		
</div>


<script>
$(function () {
  bsCustomFileInput.init();
});

$(document).ready(function()
		{
			//alert("Serial NO  - "+${empData.serialNumber});
		});
</script>
</body>
</html>
