<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home | The Wardrobe</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/index_style.css">
	
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/listeners.js"></script>
  
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active">0</li>
      <li data-target="#myCarousel" data-slide-to="1">1</li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="https://s3.amazonaws.com/wardrobeimages/shoes/woman_heels.jpeg" alt="Image" >      
      </div>

      <div class="item">
        <img src="https://s3.amazonaws.com/wardrobeimages/accessories/necklace-jewelry-silver.jpeg" alt="Image"  height="200px">      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  
<div class="items-container text-center">
<h3>New In</h3><br>
  <div class="row">
  <form id="getProduct" action="${pageContext.request.contextPath}/ProductDetailServlet" method="post">

		<c:forEach items="${Items}" var="current">
		
			<div class=" col-sm-4">
				<img src="${current.imageUrl}" class=" item_img img-responsive" name = "${current.productId}"/>
			    <p>${current.name}</p>
				<p>${current.price}</p>			
				<input type="hidden" value="${current.productId}" id="product_id" name="product_id">
			</div>
		</c:forEach>
	</form>			
 
 </div>
 
</div>

<br>

<jsp:include page="footer.jsp"/>

</body>
</html>