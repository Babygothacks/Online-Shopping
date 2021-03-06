<div class="container">

	<div class="row">
		<!-- Display side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%></div>

		<!-- Display actual products -->
		<div class="col-md-9">
			<!-- Added bread crum -->
			<div class="row">

				<div class="col-lg-12">
					<c:if test="${AllProductsClick== true}">
						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					<c:if test="${ProductsCategoryClick == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>

				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<table id="tblProductList"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</tfoot>
					</table>


				</div>

			</div>

		</div>
	</div>
</div>