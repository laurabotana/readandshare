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
						<a href="autor.html?id=${model.libro.autor}"> <c:out value="${model.libro.nombreAutor}" /></a>
					</p>
					<p class="small">
						Editorial:
						<c:out value="${model.libro.editorial}" />
					</p>
					<p class="small">
						A�o:
						<c:out value="${model.libro.ano}" />
					</p>
					<p class="small">
						N�mero de p�ginas:
						<c:out value="${model.libro.numPaginas}" />
					</p>
					<p class="small text-muted">
						<c:out value="${model.libro.nombreGenero}" />
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
				<c:when test="${model.libroValoradoUsuarioActual}">
					<h5>VALORACI�N</h5>
					<p>
						Nota:
						<c:out value="${model.valoracionLibroUsuarioActual.nota}" />
					</p>
					<c:choose>
						<c:when test="${model.valoracionLibroUsuarioActual.critica != null}">
							<p>
								Cr�tica:
								<c:out value="${model.valoracionLibroUsuarioActual.critica}" />
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
									<!-- <div class="col-12">
										<label for="nota">Nota [0-10]:<span class="red">*</span></label>
										<input type="number" class="form-control" id="nota"
										name="nota" required min="0" max="10">

									

									</div> -->

									<div>
										<p class="clasificacion">
											<input id="radio10" type="radio" name="nota" value="10"><label for="radio10">&#9733;</label>
											<input id="radio9" type="radio" name="nota" value="9"><label for="radio9">&#9733;</label>
											<input id="radio8" type="radio" name="nota" value="8"><label for="radio8">&#9733;</label>
											<input id="radio7" type="radio" name="nota" value="7"><label for="radio7">&#9733;</label>
											<input id="radio6" type="radio" name="nota" value="6"><label for="radio6">&#9733;</label>
											<input id="radio5" type="radio" name="nota" value="5"><label for="radio5">&#9733;</label>
											<input id="radio4" type="radio" name="nota" value="4"><label for="radio4">&#9733;</label>
											<input id="radio3" type="radio" name="nota" value="3"><label for="radio3">&#9733;</label>
											<input id="radio2" type="radio" name="nota" value="2"><label for="radio2">&#9733;</label>
											<input id="radio1" type="radio" name="nota" value="1"><label for="radio1">&#9733;</label>
										</p>
										
									</div>
									<div>
										<label for="critica">Cr�tica:<span class="red">*</span></label>
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
			<h5>VALORACIONES DE USUARIOS</h5>
			
				<c:forEach items="${model.valoraciones}" var="valoracion" >
					<div class="border border-secondary rounded p-2">
						<p ><span class="font-weight-bold">${valoracion.nota}</span> - <a class="text-muted" href="usuario.html?alias=${valoracion.usuario}">${valoracion.usuario}</a></p>
						<p>${valoracion.critica}</p>
					</div>
					<br/>
				</c:forEach>
				
				
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>