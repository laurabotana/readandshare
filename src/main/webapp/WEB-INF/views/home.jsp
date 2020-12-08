<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<section class="gallery-block cards-gallery">
			<div class="container">
				<div class="heading">
					<h2>Libros más valorados</h2>
					<%-- <select name="libro" id="libro">
						<c:forEach items="${model.libros}" var="libro">
							<option value="${libro.id}">${libro.titulo}</option>
						</c:forEach>
					</select> --%>
				</div>
				<div class="row">
					<c:forEach items="${model.valoraciones}" var="valoracion">
						<div class="col-4 col-md-2">
							<div class="card border-0 transform-on-hover">
								<a class="lightbox" href="libro${valoracion.libro.id}.html"> <img
									src="data:image/jpg;base64,${valoracion.libro.imagenStr}" alt="${valoracion.libro.titulo}" class="card-img-top">
								</a>
								<div class="card-body">
									<h6>
										<a href="#">${libro.titulo}</a>
									</h6>
									<p class="text-muted card-text">${valoracion.libro.nombreAutor}</p>
									<p class="text-muted card-text">
										<c:choose>
		  									<c:when test = "${not empty valoracion.media}">
		  										${valoracion.media}
		  									</c:when>
		  									<c:otherwise>
		  										Sin valoración
		  									</c:otherwise>
		  								</c:choose>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
		<script>
			baguetteBox.run('.cards-gallery', {
				animation : 'slideIn'
			});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>