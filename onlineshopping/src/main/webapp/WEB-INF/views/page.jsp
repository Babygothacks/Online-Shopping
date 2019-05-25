<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/resources/css" />
<spring:url var="images" value="/resources/images" />
<spring:url var="js" value="/resources/js" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>
<script>
	window.Menu = '${title}';
</script>
<!-- Bootstrap core CSS -->

<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Add boostrap new theme CSS here -->
<%-- <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"> --%>
<%-- <link href="${css}/bootstrap_new_theme.min.css" rel="stylesheet"> --%>
 <link href="${css}/bootstrap-theme.css" rel="stylesheet">
<%-- <link href="${css}/bootstrap_sandstone.css" rel="stylesheet"> --%>


</head>

<body>
	<div class="wrapper">

		<%@include file="./shared/navbar.jsp"%>

		<!-- page content -->
		<div class="content">
			<c:if test="${HomeClick ==  true}">
				<%@include file="./home.jsp"%>
			</c:if>
			<c:if test="${AboutClick ==  true}">
				<%@include file="./about.jsp"%>
			</c:if>

			<c:if test="${ContactClick ==  true}">
				<%@include file="./contact.jsp"%>
			</c:if>
			<c:if
				test="${ProductsCategoryClick ==  true or AllProductsClick ==  true}">
				<%@include file="./productlist.jsp"%>
			</c:if>
		</div>

		<%@include file="./shared/footer.jsp"%>

		<!-- JavaScript -->

		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>