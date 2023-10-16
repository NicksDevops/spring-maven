<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 
  <%@include file="modalResponse.jsp"%>

<input type="hidden" id="ctxPath" name="ctxPath"
	value="<c:out value="${pageContext.request.contextPath}"/>" />
	
<script type="text/javascript" src="<c:url value="/js/homeheader.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/logOut.js"/>"></script> 

<script>
  var contextPath = "${pageContext.request.contextPath}";
</script>



<script type="text/javascript">
    var menus = [{"roleId":0,"mbMenuName":"Employee","menuId":1,"menuLink":"link","menuLevel":0,"menuOrder":1,"subMenus":[{"roleId":0,"mbMenuName":"Add Employee","imageUrl":"fa fa-user fa-fw","menuId":2,"parentId":1,"menuLink":"/employee/reqEmployee","menuLevel":1,"menuOrder":2,"subMenus":[],"checked":false},{"roleId":0,"mbMenuName":"View Employee","imageUrl":"fa fa-user-edit fa-fw","menuId":3,"parentId":1,"menuLink":"/employee/viewEmployee","menuLevel":1,"menuOrder":3,"subMenus":[],"checked":false}],"checked":false,"imageUrl":"far fa-user"},{"roleId":0,"mbMenuName":"Department","menuId":2,"menuLink":"link","menuLevel":0,"menuOrder":2,"subMenus":[{"roleId":0,"mbMenuName":"Add Department","imageUrl":"fa fa-user fa-fw", "menuId":2,"parentId":1,"menuLink":"/dept/addDepartment","menuLevel":1,"menuOrder":2,"subMenus":[],"checked":false}, {"roleId":0,"mbMenuName":"View Department","imageUrl":"fa fa-user fa-fw", "menuId":2,"parentId":1,"menuLink":"/dept/viewDepartment","menuLevel":1,"menuOrder":2,"subMenus":[],"checked":false}],"checked":false,"imageUrl":"far fa-user"},{"roleId":0,"mbMenuName":"Project","menuId":1,"menuLink":"link","menuLevel":0,"menuOrder":1,"subMenus":[{"roleId":0,"mbMenuName":"Add Project","imageUrl":"fa fa-user fa-fw","menuId":2,"parentId":1,"menuLink":"/project/addProject","menuLevel":1,"menuOrder":2,"subMenus":[],"checked":false},{"roleId":0,"mbMenuName":"View Project","imageUrl":"fa fa-user-edit fa-fw","menuId":3,"parentId":1,"menuLink":"/project/viewProject","menuLevel":1,"menuOrder":3,"subMenus":[],"checked":false}],"checked":false,"imageUrl":"far fa-user"},{"roleId":0,"mbMenuName":"Employee Project ","menuId":5,"menuLink":"link","menuLevel":0,"menuOrder":6,"subMenus":[{"roleId":0,"mbMenuName":"Assign Projects","menuId":6,"parentId":5,"imageUrl":"fa fa-user fa-fw","menuLink":"/empProject/assignProject","menuLevel":1,"menuOrder":7,"subMenus":[],"checked":false},{"roleId":0,"mbMenuName":"View Empployee-Project ","menuId":7,"imageUrl":"fa fa-user-edit fa-fw","parentId":5,"menuLink":"//empProject/viewEmpProject","menuLevel":1,"menuOrder":8,"subMenus":[],"checked":false}],"checked":false,"imageUrl":"far fa-group"}];
$(document).ready(function (e)	
{
	parseMenu(menus)
}
);

function parseMenu(menus)
{
var templateBegin = '';
var menuData = templateBegin;
var menu = null;
	for(var i = 0 ; i < menus.length ; i++)
	{
	menu = menus[i];
	//alert("menu"+JSON.stringify(menu));
	var hasChild = false;
		if(typeof menu.subMenus != 'undefined' && menu.subMenus.length > 0)
		{
		hasChild = true;
		}
		
		menuData += '<li class="nav-item ';
		/* if(hasChild)
		{
		menuData += 'has-treeview';
		}  */
		menuData += '"> <a href="#" class="nav-link">               ';
		menuData += '<p>'+menu.mbMenuName+' <i class="right fas fa-angle-left"></i> </p></a>';
		if(hasChild)
		{
			menuData += getChildMenusContent(menu.subMenus);
		}
		menuData += '</li>';	
		}
$('#menuData').html(menuData);
}

function getChildMenusContent(childMenus)
{
var content = '<ul class="nav nav-treeview">';
var childMenu = null;
for(var i = 0 ; i < childMenus.length ; i++)
{
	childMenu = childMenus[i];
	//Change menu icon here
//	content += '<li class="nav-item"> <a href="#" class="nav-link "> <i class="far fa-circle nav-icon"></i>';
	content += '<li class="nav-item"> <a  href="javascript:loadView(\''+childMenu.menuLink+'\')" class="nav-link "> <i class="'+childMenu.mbImageUrl+'"></i>';
	content += '<p> <i class="far fa-circle nav-icon"></i>'+childMenu.mbMenuName+'</p>';
	content += '</a></li>';
	if(typeof childMenu.childMenus != 'undefined' && childMenu.childMenus.length > 0)
	{
		getChildMenusContent(childMenu.mbMenuName);
	}
}
content += ' </ul>';
return content;
}
</script>


<!-- Admin LTE 3.2.0 -->

<nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="../../index3.html" class="nav-link">Home</a>
      </li>
    </ul>
    
    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
	  <!--<button type="button" class="btn btn-block btn-danger btn-sm">Logout</button>-->
	  <button type="button" class="btn btn-block btn-outline-info"   data-toggle="modal" data-target="#modal-warning">Logout</button>
	</ul>
    
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4"  >
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
      <img  src="<c:url value="dist/img/LOGO.jpeg"/>" alt="Integra Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Integra Micro</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar"  >
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="<c:url value="dist/img/user2-160x160.jpg"/>" class="img-circle elevation-2" alt="User Image">
          
        </div>
        <div class="info">
          <a href="#" class="d-block">${empData.firstName}</a>
        </div>
      </div>

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
      <ul class="nav nav-pills nav-sidebar flex-column" id='menuData'
				data-widget="treeview" role="menu" data-accordion="false">
	  </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
  
  
  <!-- ------- Warning Modal --------- -->
  <div class="modal fade" id="modal-warning">
	<div class="modal-dialog">
		<div class="modal-content bg-warning">
			<div class="modal-header">
				<h4 class="modal-title">Warning Modal</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" >

				<p>Are you Sure You Want to Logout! </p>

			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-outline-dark"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-outline-dark"
				 onclick="logout()" > Yes </button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<!-- Warning modal ends -->
  
  
 
  
  


