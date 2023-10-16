
<!-- ------------- SUCCESS MODAL  ------------------- -->
<div class="modal fade" id="modal-success">
	<div class="modal-dialog">
		<div class="modal-content bg-success">
			<div class="modal-header">
				<h4 class="modal-title">Success </h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body" id="successStatus">
				<p id="successStatus"></p>
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-outline-light"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-outline-light"
				 onclick="closeSuccess()"> OK </button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<!-- ------------- WARNING MODAL  ------------------- -->

<div class="modal fade" id="modal-warn">
	<div class="modal-dialog">
		<div class="modal-content bg-warning">
			<div class="modal-header">
				<h4 class="modal-title">Warning </h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="warnStatus">

				<p id="warnStatus"></p>

			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-outline-dark"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-outline-dark"
				 onclick="closeWarning()" > OK </button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<!-- ------------- ERROR MODAL  ------------------- -->

<div class="modal fade" id="modal-danger">
	<div class="modal-dialog">
		<div class="modal-content bg-danger">
			<div class="modal-header">
				<h4 class="modal-title">Failure</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id = "failureStatus">
				<p id = "failureStatus"></p>
			</div>
			<div class="modal-footer justify-content-between">
				<button type="button" class="btn btn-outline-light"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-outline-light"
				onclick="closeError()" > OK </button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
	


