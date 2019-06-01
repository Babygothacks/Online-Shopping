<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">

	<div class="row">
		<!-- Breadcrumb -->
		<div class="col-lg-12">
			<script>
				window.product = $
				{
					product
				};
			</script>
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li><a href="${contextRoot}/show/all/products">Products</a></li>
					<li class="active">${product.name}</li>
				</ol>
			</div>

		</div>

	</div>
	<div class="row">
		<!-- Image -->
		<div class="col-xs-12 col-md-4">
			<div class="thumbnail">
				<img src="${contextRoot}/resources/images/${product.code}.jpg"
					class="img img-responsive" />
			</div>
		</div>
		<!-- Description -->
		<div class="col-xs-12 col-md-8">

			<h3>${product.name}</h3>
			<hr>

			<p>${product.description}</p>
			<hr>
			<h4>
				Price : <strong>&#8377; ${product.unitPrice} /-</strong>
			</h4>
			<hr>


			<c:choose>
				<c:when test="${product.quantity == 0 or product.quantity == '0'}">
					<h6>
						Quantity : <span style="color: red">Out of stock!</span>
					</h6>
					<hr />

					<a href="javascript:void(0);"
						class="btn btn-success disabled"> <span
						class="glyphicon glyphicon-shopping-cart" style="text-decoration: line-through"> Add to Cart</span>
					</a>
				</c:when>
				<c:otherwise>
					<h6>Quantity : ${product.quantity}</h6>
					<hr />
					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"> Add to Cart</span>
					</a>
				</c:otherwise>
			</c:choose>
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">
				Back </a>

		</div>
	</div>

</div>