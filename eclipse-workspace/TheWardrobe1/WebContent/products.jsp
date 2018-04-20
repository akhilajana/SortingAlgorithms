<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home | The Wardrobe</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel = "stylesheet" href="css/products_style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/listeners.js"></script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div >
  <div class="container text-center">
    <h1>empty shit</h1>      
    <p></p>
  </div>
</div>
	
	
<div id="container" style="width:100%;">                                   
  	<%-- <div class="col-sm-2 well" style="float:right; width:20%;"> 
	
		<h4>Filter By</h4>
		<div class="filter-container">
		  <div class="row" >
			<h5>Color</h5>
				<c:forEach var="color" items="${Color}">	
					<button type="button" class="btn btn-lg btn_filter" style = "background-color:${color}; "></button>
				</c:forEach> 
		  </div>
		<br>
		
		  <div class="row" >
			<h5>Size</h5>
			<c:forEach var="size" items="${Size}">	
				<button type="button" class="btn btn-default btn_filter">${size}</button>
			</c:forEach> 
		  </div>
		  <br>
		  <div class="form-group row" >
			<h5>Price</h5>
			  <div class="col-xs-4">
				<label for="ex1">min</label>
				<input class="form-control" id="ex1" type="text">
			  </div>
			  
			  <div class="col-xs-4">
				<label for="ex2">max</label>
				<input class="form-control" id="ex2" type="text">
			  </div>
			  <div class="col-xs-4">
			  
			  <button type="button" class="btn btn-default btn_filter">Go</button>
			  </div>
		  </div>
		  <div class="row" >
		  	 <label for="sort" >Sort By</label>
	            <select id="sort">
	              <option value="HtoL">Price: High to Low</option>
		          <option value="LtoH">Price: Low to High</option> 
		        </select> 

		  </div>
		  
		</div>
		
	</div>  
	
	 <div class="vl"></div> --%> 
	
  	<div class=" col-md-8 " style="float:right; width:100%;"> 
		
		<h2 style="color:#FF6347">${Category}</h2><br>
		 <form id="getProduct" action="${pageContext.request.contextPath}/ProductDetailServlet" method="post">
		
				<div class="container-fluid bg-3 text-center">    
					<div class="row">
					<c:forEach items="${Items}" var="current">
						<div class="well col-sm-5 col-xs-offset-1" style="width: 25rem;">
						<img src="${current.imageUrl}" class=" item_img img-responsive" name = "${current.productId}"/>
						    <p >${current.name}</p>
							<p >${current.price}</p>	
						<input type="hidden" value="${current.productId}" id="product_id" name="product_id">
						</div>
						
						</c:forEach>
					</div>
				</div>
				
			 </form>
	 		<br>
		</div>                   
	</div>

</body>
</html>