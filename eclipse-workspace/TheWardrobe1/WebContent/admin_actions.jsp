<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/admin_home_style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/listeners.js"></script>

</head>
<body>

	<div class="container-fluid">
		<jsp:include page="admin_header.jsp"></jsp:include>

	</div>

	<div>
		<div class="container text-center">
			<h1>empty shit</h1>
			<p></p>
		</div>
	</div>
	<br>

	<div class="row">
		<div class="col-sm-3 col-xs-offset-1">

			<div class="row well" onclick="openTab('b1');">Add New Items</div>
			<div class="row well" onclick="openTab('b2');">Delete Existing
				Items</div>
				<div class="row well" onclick="openTab('b3');">Update Existing
				Items</div>
		</div>
		<div class="col-sm-7 col-xs-offset-1">
			<div id="b1" class="containerTab" style="display: none;">
				<span onclick="this.parentElement.style.display='none'"
					class="closebtn">&times;</span>

				<div class="col-md-7 col-sm-offset-1 well">
					<!-- Your second column here -->
					<h3>Item to be Added</h3>
					<br>
					<form class="form-horizontal"
						action="${pageContext.request.contextPath}/ProductActionsServlet"
						method="post">
						<div class="form-group ">
							<label class="control-label col-sm-4" for="prdId">Product
								Id:</label>
							<div class="col-sm-5">
								<input type="number" class="form-control" id="prdId"
									placeholder="Enter unique product Id" name="prdId">
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-4" for="prdName">Product
								name:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="prdName"
									placeholder="Enter product name" name="prdName">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="prdDesc">Product
								description:</label>
							<div class="col-sm-5">
								<textarea class="form-control" rows="2" id="prdDesc"
									name="prdDesc" placeholder="Enter product description"></textarea>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="size">Size:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="size"
									placeholder="Enter size" name="size">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="price">Price:</label>
							<div class="col-sm-5">
								<input type="number" class="form-control" id="price"
									placeholder="Enter price" name="price">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="color">Color:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="color"
									placeholder="Enter color" name="color">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="cat">Category:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="cat"
									placeholder="Enter category" name="cat">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="imgUrl">Image
								Url:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="imgUrl"
									placeholder="Enter image url" name="imgUrl">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="qty">Quantity:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="qty"
									placeholder="Enter quantity" name="qty">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-10">
								<input type="submit" name="insert_item"
									class="btn btn-success"
									value="Add
									Item">
							</div>
						</div>
					</form>
				</div>
			</div>

			<div id="b2" class="containerTab" style="display: none;">
				<span onclick="this.parentElement.style.display='none'"
					class="closebtn">&times;</span>
				<div class="col-md-7 col-sm-offset-1 well">
					<!-- Your first column here -->
					<h3>Item to be deleted</h3>
					<form class=" form-horizontal login-form "
						action="${pageContext.request.contextPath}/ProductActionsServlet"
						method="post">

						<div class="form-group">
							<label class="control-label col-sm-4" for="prdId">Product
								Id:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="prdId"
									placeholder="Enter product Id" name="prdId">
							</div>
						</div>
						<br>


						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" name="delete_item"
									class="btn btn-danger"
									value="Delete
									Item">

							</div>
						</div>
					</form>
				</div>
			</div>
			<div id="b3" class="containerTab" style="display: none;">
				<span onclick="this.parentElement.style.display='none'"
					class="closebtn">&times;</span>
				<div class="col-md-7 col-sm-offset-1 well">
					<!-- Your first column here -->
					<h3>Item to be updated</h3>
					<form class=" form-horizontal login-form "
						action="${pageContext.request.contextPath}/ProductActionsServlet"
						method="post">

						<div class="form-group">
							<label class="control-label col-sm-4" for="prdId">Product
								Id:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="prdId"
									placeholder="Enter product Id" name="prdId">
							</div>
							<label class="control-label col-sm-4" for="prdSize">Product
								Size:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="prdSize"
									placeholder="Enter product size" name="prdSize">
							</div>
							<label class="control-label col-sm-4" for="prdQty">Product
								Quantity:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="prdQty"
									placeholder="Enter product Quantity" name="prdQty">
							</div>
							<label class="control-label col-sm-4" for="prdPrice">Product
								Price:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="prdPrice"
									placeholder="Enter product Price" name="prdPrice">
							</div>
						</div>
						
						<br>


						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" name="update_item"
									class="btn btn-success"
									value="Update
									Item">

							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>

	<!-- Three rows -->
	<div class="col-3"></div>

	<!-- Full-width rows: (hidden by default) -->


	<script>
		function openTab(tabName) {
			var i, x;
			x = document.getElementsByClassName("containerTab");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			document.getElementById(tabName).style.display = "block";
		}
	</script>

	<%-- 	<div class="container centered">
		<form id="getProduct" class="form-horizontal"
			action="${pageContext.request.contextPath}/ProductDetailServlet"
			method="post">
			<div class="row">
				<div class="col-sm-6">
					<div class="well">
						<h4>ADD NEW CLOTHES</h4>
						<img src="images/if_Plus__Orange.png">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="well">
						<h4>DELETE EXISTING CLOTHES</h4>
						<img src="images/if_trash_yellow.png">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="well">
						<h4>UPDATE SIZE</h4>
						<br> <img src="images/if_house_hangers.png"
							data-toggle="collapse" data-target="#demo">
							
						<div id="demo" class="collapse form-group">
							<label for="pId" >Product ID:</label> <input
								type="text" name="pId" id="pId" value="pId" >
							<br>
							<label for="qty" >Size:</label> <input
								type="text" name="qty" id="qty" value="qty" >
							<br>
							<button type="button" class="btn btn-success" >Update</button>
						</div>
						
					</div>
				</div>
				<div class="col-sm-4">
					<div class="well">
						<h4>UPDATE PRICE</h4>
						<br> <img src="images/if_price.png" data-toggle="collapse"
							data-target="#demo">
							<div id="demo" class="collapse form-group">
							<label for="pId" >Product ID:</label> <input
								type="text" name="pId" id="pId" value="pId" >
							<br>
							<label for="qty" >Price:</label> <input
								type="text" name="qty" id="qty" value="qty" >
							<br>
							<button type="button" class="btn btn-success" >Update</button>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="well">
						<h4>UPDATE QUANTITY</h4>
						<br> <img src="images/if_cart.png" data-toggle="collapse"
							data-target="#demo">
							<div id="demo" class="collapse form-group">
							<label for="pId" >Product ID:</label> <input
								type="text" name="pId" id="pId" value="pId" >
							<br>
							<label for="qty" >Quantity:</label> <input
								type="text" name="qty" id="qty" value="qty" >
							<br>
							<button type="button" class="btn btn-success" >Update</button>
						</div>
					</div>
				</div>
			</div>

			<input type="hidden" id="action_id" name="action_id">
		</form>
	</div>
 --%>
</body>
</html>

