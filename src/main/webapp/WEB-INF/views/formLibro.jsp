<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
	<div class="container">

		<form class="p-4" method="POST" action="addLibro.html" enctype="multipart/form-data"
			class="needs-validation">

			<div class="form-row ">
				<div class="col-12">
					<label for="titulo">Titulo:<span class="red">*</span></label> <input
						type="text" class="form-control" id="titulo" name="titulo"
						required maxlength="45">
				</div>
				<div class="col-12">
					<label for="editorial">Editorial:<span class="red">*</span></label>
					<input type="text" class="form-control" id="editorial"
						name="editorial" required maxlength="45">
				</div>
				<div class="col-12">
					<label for="ano">Año:<span class="red">*</span></label>
					<input type="number" class="form-control" id="ano" name="ano"
						required min="0" max="9999">
				</div>
				<div class="col-12">
					<label for="numPaginas">Número de páginas:<span class="red">*</span></label>
					<input type="number" class="form-control" id="numPaginas" name="numPaginas"
						required min="0" max="9999">
				</div>
				<div class="col-12">
					<label for="sinopsis">Sinopsis:<span class="red">*</span></label>
					<textarea class="form-control" id="sinopsis" name="sinopsis"
						required maxlength="500" rows="5" cols="20"></textarea>
				</div>
				<div class="col-12">
					<label for="autor">Autor:<span class="red">*</span></label>
					<select name="autor" id="autor">
						<c:forEach items="${model.autores}" var="autor">
							<option value="${autor.id}">${autor.nombre}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="col-12">
					<label for="genero">Género:<span class="red">*</span></label>
					<select name="genero" id="genero">
						<c:forEach items="${model.generos}" var="genero">
							<option value="${genero.id}">${genero.genero}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="col-12">
					<label for="imagen">Imagen:<span class="red">*</span></label> 
					<input type="file" class="form-control" id="imagen" name="imagen">
				</div>
			</div>

			<div class="form-group col-12">
				<br />
				<button class="btn btn-primary" type="submit" name="submit">Guardar</button>
				<button class="btn btn-success" type="reset" name="reset">Limpiar</button>
			</div>

		</form>

	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>