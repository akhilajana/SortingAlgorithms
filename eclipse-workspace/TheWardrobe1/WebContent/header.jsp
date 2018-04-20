<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Wardrobe</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/index_style.css">
	<script src="js/listeners.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">The Wardrobe</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/ProductsRetrievalServlet?value=Clothes" >Clothing</a></li>
        <li><a href="${pageContext.request.contextPath}/ProductsRetrievalServlet?value=Shoes" >Shoes</a></li>
        <li><a href="${pageContext.request.contextPath}/ProductsRetrievalServlet?value=Accessories">Accessories</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <c:choose>
      	<c:when test="${empty user}">
        <li><a href="loginRegister.jsp"><span class="glyphicon glyphicon-log-in"></span> Login/ Register</a></li>
<!-- 		<li><a href="signup.jsp"><span class="glyphicon glyphicon-user"></span> Register</a></li>
 -->      	</c:when>
      	<c:otherwise>
      	
      	 <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> </a></li>
      	 <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle ="dropdown"> My Profile <span class="glyphicon glyphicon-user"></span></a> 
      	 	<ul class="dropdown-menu">
	      	 	<li><a href="#">Your Orders</a></li>
	      		<li><a href="#">Edit your profile</a></li>
	      		<li><a href="${pageContext.request.contextPath}/LogoutServlet">Log Out</a></li>
      		</ul>
      	</li>
      
      	</c:otherwise>
      </c:choose>	
      </ul>
    </div>
  </div>
</nav>
</body>
</html>