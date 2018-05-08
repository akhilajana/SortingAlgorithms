<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Cart| The Wardrobe</title>
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

	<jsp:include page="header.jsp" />
	<br>
	<div>
		<div class="container text-center">
			<h1>-------</h1>
			<p></p>
		</div>
	</div>

	<div class="row">

		<div class="col-sm-offset-1">
			<p>
			<h2 style="color: #FF6347;">Your Cart (${fn:length(CartItems)})</h2>
			
		</div>

		<!-- /* Content Items */ -->
		<div class="well col-sm-8 col-sm-offset-1">

			<div class="content no-padding ">
				<div class="contentItems">
					<ul class="bordered">
						<c:choose>
							<c:when test="${empty CartItems}">
								<div class="content message">
									<b>There are no items in your cart.</b><br> If you have an
									account with us, please <a>log in</a> to see items you
									previously added.
								</div>
							</c:when>
							<c:otherwise>
								<c:forEach items="${CartItems}" var="cartItem">
									<div class="row">

										<div class='col-md-12 col-xs-12 cartItem'
											style="border-bottom: #000 1px solid; padding: 10px;">
											<div class='cartImg col-md-4 col-xs-12'>
												<img src="${cartItem.item_ImgUrl}" width=200px;
													height=200px;>
											</div>
											<div class='cartItemData col-md-8 col-xs-12'>
												<div>${cartItem.itemName}</div>
												Price
												<div>${cartItem.itemPrice}</div>
												Quantity
												<div>${cartItem.itemQty}</div>

												<a class="remove_item"
													href="${pageContext.request.contextPath}/CartItemActions?itemId=${cartItem.itemid}">Remove
													Item from Cart</a>

											</div>
										</div>
										<hr>
									</div>

								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>

		</div>


		<div class="col-sm-3">
			<div class="summaryContainer well">
				<div id="summaryTitle" class="summaryRowBegin uppercase">SUMMARY</div>

				<!-- Sub Total and personalization display -->
				<div id="summarySubtotal" class="summaryRow uppercase">
					<div class="itemLabel">SUBTOTAL</div>
					<c:set var="total" value="${0}" />
					<c:forEach var="item" items="${CartItems}">
						<c:set var="total" value="${total + item.itemPrice}" />
					</c:forEach>
					<span id="subTotalAmount" class="right"> ${total}</span>
				</div>
				<!-- Shipping Method Selector-->
				<c:choose>
					<c:when test="${total gt 200}">
						<div id="summaryShipping" class="summaryRow">
							<div class="itemLabel">ESTIMATED SHIPPING</div>

							<div class="itemLabelValue">
							<c:choose>
								<c:when test="${total eq 0}">
									<c:set var="shipCost" value="${0.00}" />
								</c:when>
								<c:otherwise>
									<c:set var="shipCost" value="${0.00}" />
								</c:otherwise>
								</c:choose>
								<span id="shippingAmount">${shipCost}</span>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div id="summaryShipping" class="summaryRow">
							<div class="itemLabel">ESTIMATED SHIPPING</div>

							<div class="itemLabelValue">
							<c:choose>
								<c:when test="${total eq 0}">
									<c:set var="shipCost" value="${0.00}" />
								</c:when>
								<c:otherwise>
									<c:set var="shipCost" value="${30.00}" />
								</c:otherwise>
								</c:choose>
								<span id="shippingAmount">${shipCost}</span>

							</div>
						</div>
					</c:otherwise>
				</c:choose>

				<!--  Display VAS options -->
				<c:choose>
					<c:when test="${total gt 200}">
						<!-- For US display tax if it exists other wise display $_._ and for EU display Nothing-->
						<div id="summaryTax" class="summaryRow  uppercase">
							<div class="itemLabel">ESTIMATED TAXES</div>
							<c:choose>
							<c:when test="${total eq 0}">
								<c:set var="taxCost" value="${0.00}" />
							</c:when>
							<c:otherwise>
								<c:set var="taxCost" value="${20.00}" />
							</c:otherwise>
							</c:choose>
							<span class="right">${ taxCost}</span>
						</div>
					</c:when>
					<c:otherwise>
						<div id="summaryTax" class="summaryRow  uppercase">
							<div class="itemLabel">ESTIMATED TAXES</div>
							<c:choose>
							<c:when test="${total eq 0}">
								<c:set var="taxCost" value="${0.00}" />
							</c:when>
							<c:otherwise>
								<c:set var="taxCost" value="${5.00}" />
							</c:otherwise>
</c:choose>
							<span class="right">${taxCost}</span>

						</div>
					</c:otherwise>
				</c:choose>
				<!-- Summary Total -->
				<div id="summaryTotal" class="summaryRow uppercase">
					<div class="itemLabel">TOTAL</div>
					<span id="totalAmt" class="right">${total+shipCost+taxCost}</span>
				</div>
				<div id="summaryButtons">

					<form action="${pageContext.request.contextPath}/CheckoutServlet"
						method="post">
						<input id="cartCheckoutBtn" type="submit" value="Checkout"
							class="btn btn-success btnSummaryCol ">
					</form>

				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<jsp:include page="footer.jsp" />\
	</div>


</body>
</html>