<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Product Detail| The Wardrobe</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/products_style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/listeners.js"></script>

</head>
<body>
	<!-- Start Top Bar -->
	<jsp:include page="header.jsp" />
	<!-- End Top Bar -->
	<br>
	<c:set var="detailItem" value="${DetailItem}" />
	<!-- 	/***************Add breadcrumb******************/ -->
	<!-- <div class="container">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
			<li class="breadcrumb-item"><a href="#">Library</a></li>
			<li class="breadcrumb-item active">Data</li>
		</ol>
	</div> -->

	<div>
		<div class="container text-center">
			<h1>empty shit</h1>
			<p></p>
		</div>
	</div>


	<input type="hidden" class="itemID" value="${detailItem.productId}"
		name="iItemID" />
	<div class="container well col-sm-offset-2">
		<div class="col-sm-5 ">
			<img src="${detailItem.imageUrl}"
				class=" detail_img img-responsive center-block" name="iImgUrl" />
		</div>
		<div class="col-sm-6 ">
			<h3 name="iName" style="color: #4682B4">${detailItem.name}</h3>
			<p>${detailItem.desc}</p>
			<br>
			<div class="detailRow">
				<div class="itemDetailLabel">Size</div>
				<button type="button" class="btn btn-default">${detailItem.size}</button>
			</div>

			<div class="detailRow">
				<div class="itemDetailLabel">Cost</div>
				<p name="iPrice">${detailItem.price}</p>
			</div>

			<div class="detailRow ">
				<div class="itemDetailLabel">Quantity</div>
				<select id="qty">
					<c:forEach var="i" begin="1" end="${detailItem.qty}">
						<option value="${i}">${i}</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<form action="${pageContext.request.contextPath}/CartItemsServlet"
				id="getCart" method="post">
				<input type="hidden" value="${detailItem.productId}" id="productId" />
				<button type="submit" class="btn addtoCart"
					name="${detailItem.productId}">
					<span class="glyphicon glyphicon-shopping-cart"></span> Add to cart
				</button>
			</form>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>