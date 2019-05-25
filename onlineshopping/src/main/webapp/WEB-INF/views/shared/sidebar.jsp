<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p class="lead">Shop Name</p>
<div class="list-group">

	<c:forEach items="${categoryList}" var="category">
		<a id="a_${category.name}" href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a>
	</c:forEach>
	<!-- <a href="#" class="list-group-item">Printable</a> <a href="#"
						class="list-group-item">Cupcake Wrappers</a> <a href="#"
						class="list-group-item">Authentic Dragon Bones</a> -->
</div>