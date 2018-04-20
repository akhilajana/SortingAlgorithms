<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			<h1>empty shit</h1>
			<p></p>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-9">
			<div class="col-sm-offset-1">
				<p>
					<h2 style="color:#FF6347; ">Your Cart (0)</h2>
				</p>
			</div>

			<!-- /* Content Items */ -->
			<div class="well col-sm-offset-1">
				
				<div class="content no-padding ">
					<div class="contentItems">
						<ul class="bordered">
							<div class="content message">
								<b>There are no items in your cart.</b><br> If you have an
								account with us, please <a class="js-guestLogIn"
									href="javascript:void(0);">log in</a> to see items you
								previously added.
								
							</div>

						</ul>
					</div>

				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="summaryContainer well">
				<div id="summaryTitle" class="summaryRowBegin uppercase">SUMMARY</div>

				<!-- Sub Total and personalization display -->
				<div id="summarySubtotal" class="summaryRow uppercase">
					<div class="itemLabel">SUBTOTAL</div>
					<span id="subTotalAmount" class="right">$0.00</span>
				</div>
				<!-- Shipping Method Selector-->
				<div id="summaryShipping" class="summaryRow">
					<div class="itemLabel">ESTIMATED SHIPPING</div>
					<div class="itemLabelValue">
						<span id="shippingAmount">$0.00</span>
					</div>
				</div>

				<!--  Display VAS options -->

				<!-- For US display tax if it exists other wise display $_._ and for EU display Nothing-->
				<div id="summaryTax" class="summaryRow  uppercase">
					<div class="itemLabel">ESTIMATED TAXES</div>
					<span class="right">$_._</span>
				</div>

				<!-- Summary Total -->
				<div id="ch4_summaryTotal" class="summaryRow uppercase">
					TOTAL<span id="totalAmt" class="right">$0.00</span>
				</div>
				<div id="summaryButtons">
					<input id="cartCheckoutBtn" type="button" value="CHECKOUT"
						class="btn  btnSummaryCol ">
				</div>
			</div>
		</div>
	</div>






</body>
</html>