<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<section class="gallery-block cards-gallery">
			<div class="container">
				<div class="heading">
					<h2><c:out value="${model.autor.nombre}" /></h2>
				</div>
				<div class="row">
						<c:forEach items="${model.librosAutor}" var="libro">
							<div class="col-4 col-md-2">
								<div class="card border-0 transform-on-hover">
									<a class="lightbox" href="libro.html?id=${libro.id}"> 
									<img
										src="data:image/jpg;base64,${libro.imagenStr}" alt="${libro.titulo}" class="card-img-top">
									</a>
									<div class="card-body">
										<h6>${libro.titulo}</h6>
	
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