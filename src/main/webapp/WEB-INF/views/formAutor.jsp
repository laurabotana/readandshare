<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title>Form Autor</title>
</head>
<body>
	<div class="container">

		<form class=p-4 method="POST" action="addAutor.html" class="needs-validation"
			novalidate>

			<div class="form-row ">
				<div class="col-12">
					<label for="nombre">Autor:<span class="red">*</span></label> 
					<input type="text" class="form-control" id="nombre" name="nombre" required>
				</div>
			</div>

			<div class="form-group col-12">
				<br />
				<button class="btn btn-primary" type="submit" name="submit">Guardar</button>
				<button class="btn btn-success" type="reset" name="reset">Limpiar</button>
			</div>

		</form>

	</div>
</body>
</html>