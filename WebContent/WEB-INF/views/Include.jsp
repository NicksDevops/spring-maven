<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/adminlte.min.css">                             
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- flag-icon-css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/flag-icon-css/css/flag-icon.min.css">
  <!-- pace-progress -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/pace-progress/themes/black/pace-theme-flat-top.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/daterangepicker/daterangepicker.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/select2/css/select2.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
  <!-- Bootstrap4 Duallistbox -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
  <!-- BS Stepper -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/bs-stepper/css/bs-stepper.min.css">
  <!-- dropzonejs -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/dropzone/min/dropzone.min.css">
  <!-- summernote -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/summernote/summernote-bs4.min.css">
  <!-- CodeMirror -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/codemirror/codemirror.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/codemirror/theme/monokai.css">
  <!-- SimpleMDE -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/simplemde/simplemde.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/datatables-bs4/css/dataTables.bootstrap4.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  <!-- jsGrid -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/jsgrid/jsgrid.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/jsgrid/jsgrid-theme.min.css">
  <!-- SweetAlert2 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
  <!-- Toastr -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/toastr/toastr.min.css">
  <!-- fullCalendar -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/fullcalendar/main.css">
  <!-- Ekko Lightbox -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/ekko-lightbox/ekko-lightbox.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  
  
  
  
  <!-- jQuery -->
<script src="<%=request.getContextPath()%>/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="<%=request.getContextPath()%>/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="<%=request.getContextPath()%>/plugins/chart.js/Chart.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/dist/js/adminlte.min.js"></script>
<%-- <!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/dist/js/demo.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/dist/js/demo.js"></script> --%>

<!-- FLOT CHARTS -->
<script src="<%=request.getContextPath()%>/plugins/flot/jquery.flot.js"></script>
<!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
<script src="<%=request.getContextPath()%>/plugins/flot/plugins/jquery.flot.resize.js"></script>
<!-- FLOT PIE PLUGIN - also used to draw donut charts -->
<script src="<%=request.getContextPath()%>/plugins/flot/plugins/jquery.flot.pie.js"></script>
<!-- jQuery Knob -->
<script src="<%=request.getContextPath()%>/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/plugins/sparklines/sparkline.js"></script>

 <!-- pace-progress -->
<script src="<%=request.getContextPath()%>/plugins/pace-progress/pace.min.js"></script>
<!-- bs-custom-file-input -->
<script src="<%=request.getContextPath()%>/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
<!-- Select2 -->
<script src="<%=request.getContextPath()%>/plugins/select2/js/select2.full.min.js"></script>
<!-- Bootstrap4 Duallistbox -->
<script src="<%=request.getContextPath()%>/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
<!-- InputMask -->
<script src="<%=request.getContextPath()%>/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/inputmask/jquery.inputmask.min.js"></script>
<!-- date-range-picker -->
<script src="<%=request.getContextPath()%>/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Bootstrap Switch -->
<script src="<%=request.getContextPath()%>/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- BS-Stepper -->
<script src="<%=request.getContextPath()%>/plugins/bs-stepper/js/bs-stepper.min.js"></script>
<!-- dropzonejs -->
<script src="<%=request.getContextPath()%>/plugins/dropzone/min/dropzone.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/plugins/summernote/summernote-bs4.min.js"></script>

<!-- CodeMirror -->
<script src="<%=request.getContextPath()%>/plugins/codemirror/codemirror.js"></script>
<script src="<%=request.getContextPath()%>/plugins/codemirror/mode/css/css.js"></script>
<script src="<%=request.getContextPath()%>/plugins/codemirror/mode/xml/xml.js"></script>
<script src="<%=request.getContextPath()%>/plugins/codemirror/mode/htmlmixed/htmlmixed.js"></script>

<!-- jquery-validation -->
<script src="<%=request.getContextPath()%>/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/jquery-validation/additional-methods.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>




<!-- DataTables  & Plugins -->
<script src="<%=request.getContextPath()%>/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/jszip/jszip.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/pdfmake/pdfmake.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/pdfmake/vfs_fonts.js"></script>
<script src="<%=request.getContextPath()%>/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>



<!-- jsGrid -->
<script src="<%=request.getContextPath()%>/plugins/jsgrid/demos/db.js"></script>
<script src="<%=request.getContextPath()%>/plugins/jsgrid/jsgrid.min.js"></script>
<!-- SweetAlert2 -->
<script src="<%=request.getContextPath()%>/plugins/sweetalert2/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="<%=request.getContextPath()%>/plugins/toastr/toastr.min.js"></script>
<!-- Ion Slider -->
<script src="<%=request.getContextPath()%>/plugins/ion-rangeslider/js/ion.rangeSlider.min.js"></script>
<!-- Bootstrap slider -->
<script src="<%=request.getContextPath()%>/plugins/bootstrap-slider/bootstrap-slider.min.js"></script>
<!-- jQuery UI -->
<script src="<%=request.getContextPath()%>/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- fullCalendar 2.2.5 -->
<script src="<%=request.getContextPath()%>/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/fullcalendar/main.js"></script>
<!-- Ekko Lightbox -->
<script src="<%=request.getContextPath()%>/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>
<!-- Filterizr-->
<script src="<%=request.getContextPath()%>/plugins/filterizr/jquery.filterizr.min.js"></script>

