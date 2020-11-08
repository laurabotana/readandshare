<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
	<head>
		<title>Form Login</title>
	</head>
  <body>
	<div class="container">
		<form name="formulario" id="formulario" action="addUsuario.html" method="POST">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Login</label>
		    <input type="text" name="login" class="form-control" id="login" aria-describedby="emailHelp" placeholder="Login">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
  </body>
</html>