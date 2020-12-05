<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title>Form Valoración</title>
</head>
<body>
	<div class="container">

		<form class=p-4 method="POST" action="addValoracion.html"
			class="needs-validation" novalidate>

			<div class="form-row ">
				<div class="col-12">
					Libro: <span id="libro">--Libro selecionado--</span>
				</div>
			</div>
			<div class="col-12">
				<label for="nota">Nota [0-10]:<span class="red">*</span></label> <input
					type="number" class="form-control" id="nota" name="nota" required
					min="0" max="10">
			</div>
			<div>
				<label for="critica">Crítica:<span class="red">*</span></label>
				<textarea class="form-control" id="critica" name="critica"
					required maxlength="300" rows="3" cols="20"></textarea>
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