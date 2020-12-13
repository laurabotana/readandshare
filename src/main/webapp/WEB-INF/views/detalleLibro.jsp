<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="row p-5">
				<div class="col">
					<h4>
						<c:out value="${model.libro.titulo}" />
					</h4>
					<p>
						<c:out value="${model.libro.nombreAutor}" />
					</p>
					<p class="small">
						Editorial:
						<c:out value="${model.libro.editorial}" />
					</p>
					<p class="small">
						Año:
						<c:out value="${model.libro.ano}" />
					</p>
					<p class="small">
						Número de páginas:
						<c:out value="${model.libro.numPaginas}" />
					</p>
				</div>
				<div class="col img-fluid" style="max-width: 200px">
					<img src="data:image/jpg;base64,${model.libro.imagenStr}"
						alt="${model.libro.titulo}" class="img-fluid">
				</div>
			</div>
			<div class="row p-4">
				<c:out value="${model.libro.sinopsis}" />
			</div>
			<c:choose>
				<c:when test="${model.libroValorado}">
					<h5>VALORACIÓN</h5>
					<p>
						Nota:
						<c:out value="${model.valoracionLibro.nota}" />
					</p>
					<c:choose>
						<c:when test="${model.valoracionLibro.critica != null}">
							<p>
								Crítica:
								<c:out value="${model.valoracionLibro.critica}" />
							</p>
						</c:when>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${model.sesionIniciada}">
							<div class="container">
								<form class=p-4 method="POST" action="addValoracion.html"
									class="needs-validation">
									<div class="d-none">
										<input type="text" class="form-control" id="idLibro"
											name="idLibro" value="${model.idLibro}" required>
									</div>
									<div class="col-12">
										<label for="nota">Nota [0-10]:<span class="red">*</span></label>
										<input type="number" class="form-control" id="nota"
											name="nota" required min="0" max="10">
									</div>
									<div>
										<label for="critica">Crítica:<span class="red">*</span></label>
										<textarea class="form-control" id="critica" name="critica"
											maxlength="300" rows="3" cols="20"></textarea>
									</div>
									<div class="form-group col-12">
										<br />
										<button class="btn btn-primary" type="submit" name="submit">Guardar</button>
										<button class="btn btn-success" type="reset" name="reset">Limpiar</button>
									</div>
								</form>
							</div>
						</c:when>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>