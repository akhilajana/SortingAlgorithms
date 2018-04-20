<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login | Register</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel = "stylesheet" href ="css/products_style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body >

<div class="container">
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div>
		<div class="container text-center">
			<h1>empty shit</h1>
			<p></p>
		</div>
	</div>

<div class="modal-body row">
  <div class="col-md-4 col-sm-offset-1 well" >
    <!-- Your first column here -->
    <h3 >Login</h3>
	 <form class=" form-horizontal login-form " action="${pageContext.request.contextPath}/LoginServlet" method = "post">
						  
		<div class="form-group">
	      <label class="control-label col-sm-4" for="uname">Username:</label>
	      <div class="col-sm-5">          
	        <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname">
	      </div>
	    </div>
		  <br>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="pass">Password:</label>
	      <div class="col-sm-5">          
	        <input type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
	      </div>
	    </div>
	    
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-success">Login</button>
	      </div>
	    </div>
	</form>
</div>
  <div class="col-md-4 col-sm-offset-1 well">
    <!-- Your second column here -->
    <h3>Register</h3>
		  <br>
	  <form class="form-horizontal" action="${pageContext.request.contextPath}/SignupServlet" method="post" >
	    <div class="form-group ">
	      <label class="control-label col-sm-4" for="fullName">Full name:</label>
	      <div class="col-sm-5">
	        <input type="text" class="form-control" id="fullName" placeholder="Enter full name" name="fullName">
	      </div>
	    </div>
		  <div class="form-group ">
	      <label class="control-label col-sm-4" for="phoneNo">Phone number:</label>
	      <div class="col-sm-5">
	        <input type="number" class="form-control" id="phoneNo" placeholder="Enter phone number" name="phoneNo">
	      </div>
	    </div>
		  <div class="form-group">
	      <label class="control-label col-sm-4" for="userName">Username:</label>
	      <div class="col-sm-5">
	        <input type="text" class="form-control" id="userName" placeholder="Enter user name" name="userName">
	      </div>
	    </div>
		  
		<div class="form-group">
	      <label class="control-label col-sm-4" for="emailId">Email:</label>
	      <div class="col-sm-5">          
	        <input type="email" class="form-control" id="emailId" placeholder="Enter email" name="emailId">
	      </div>
	    </div>
		  
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Password:</label>
	      <div class="col-sm-5">          
	        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
	      </div>
	    </div>
		  <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd1">Repeat Password:</label>
	      <div class="col-sm-5">        
	        <input type="password" class="form-control" id="pwd1" placeholder="Re-enter password" name="pwd1">
	      </div>
	    </div>
	<!--
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <div class="checkbox">
	          <label><input type="checkbox" name="remember"> Remember me</label>
	        </div>
	      </div>
	    </div>
	-->
	    <div class="form-group">        
	      <div class="col-sm-offset-1 col-sm-10">
	        <button type="submit" class="btn btn-success">Register</button>
	      </div>
	    </div>
	  </form>
  </div>
</div>



</body>
</html>