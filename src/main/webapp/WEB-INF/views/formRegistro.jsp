<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
	<head>
		<title>Form Registro</title>
	</head>
  <body>
	<div class="container">
	
	<form class=p-4 method="POST" action="addUsuario.html" class="needs-validation" novalidate>

		<div class="form-row">
			<div class="col-12">
				<label for="usuario">Usuario:<span class="red">*</span></label>
				<input type="text" class="form-control" id="usuario" name="login" required>
			</div>
		</div>
		<div class="form-row">
			<div class="col-12">
				<label for="pass">Contraseña:<span class="red">*</span></label>
				<input type="password" class="form-control" id="pass" name="password" required>
			</div>
		</div>
		<div class="form-row">
			<div class="col-12">
				<label for="pass">Email:<span class="red">*</span></label>
				<input type="email" class="form-control" id="mail" name="mail" required>
			</div>
		</div>
		<div class="form-row">
			<div class="col-12">
				<label for="nombre">Nombre:<span class="red">*</span></label>
				<input type="text" class="form-control" id="nombre" name="nombre" required>
			</div>
		</div>
		<div class="form-row">
			<div class="col-12">
				<label for="apellidos">Apellidos:<span class="red">*</span></label>
				<input type="text" class="form-control" id="apellidos" name="apellidos" required>
			</div>
		</div>
		<div class="form-row">
			<div class="col-12">
				<label for="provincia">Provincia:<span class="red">*</span></label>
				<input type="text" class="form-control" id="provincia" name="provincia" required>
			</div>
		</div>
		<div class="form-row">
			<div class="col-12">
				<label for="localidad">Localidad:<span class="red">*</span></label>
				<input type="text" class="form-control" id="localidad" name="localidad" required>
			</div>
		</div>
		
		<div class="form-group col-12">
			<br/>
			<button class="btn btn-primary" type="submit" name="submit">Guardar</button>
			<button class="btn btn-success" type="reset" name="reset">Limpiar</button>
		</div>

	</form>
	
	</div>
  </body>
</html>