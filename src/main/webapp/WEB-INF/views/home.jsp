<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<section class="gallery-block cards-gallery">
			<div class="container">
				<div class="heading">
					<h2>Libros más valorados</h2>
				</div>
				<div class="row">
					<div class="col-4 col-md-2">
						<div class="card border-0 transform-on-hover">
							<a class="lightbox" href="static/img/quijote.jpg"> <img
								src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
							</a>
							<div class="card-body">
								<h6>
									<a href="#">El quijote</a>
								</h6>
								<p class="text-muted card-text">Miguel de Cervantes</p>
							</div>
						</div>
					</div>
					<div class="col-4 col-md-2">
						<div class="card border-0 transform-on-hover">
							<a class="lightbox" href="static/img/quijote.jpg"> <img
								src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
							</a>
							<div class="card-body">
								<h6>
									<a href="#">El quijote</a>
								</h6>
								<p class="text-muted card-text">Miguel de Cervantes</p>
							</div>
						</div>
					</div>
					<div class="col-4 col-md-2">
						<div class="card border-0 transform-on-hover">
							<a class="lightbox" href="static/img/quijote.jpg"> <img
								src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
							</a>
							<div class="card-body">
								<h6>
									<a href="#">El quijote</a>
								</h6>
								<p class="text-muted card-text">Miguel de Cervantes</p>
							</div>
						</div>
					</div>
					<div class="col-4 col-md-2">
						<div class="card border-0 transform-on-hover">
							<a class="lightbox" href="static/img/quijote.jpg"> <img
								src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
							</a>
							<div class="card-body">
								<h6>
									<a href="#">El quijote</a>
								</h6>
								<p class="text-muted card-text">Miguel de Cervantes</p>
							</div>
						</div>
					</div>
					<div class="col-4 col-md-2">
						<div class="card border-0 transform-on-hover">
							<a class="lightbox" href="static/img/quijote.jpg"> <img
								src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
							</a>
							<div class="card-body">
								<h6>
									<a href="#">El quijote</a>
								</h6>
								<p class="text-muted card-text">Miguel de Cervantes</p>
							</div>
						</div>
					</div>
					<div class="col-4 col-md-2">
						<div class="card border-0 transform-on-hover">
							<a class="lightbox" href="static/img/quijote.jpg"> <img
								src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
							</a>
							<div class="card-body">
								<h6>
									<a href="#">El quijote</a>
								</h6>
								<p class="text-muted card-text">Miguel de Cervantes</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
		<script>
		baguetteBox.run('.cards-gallery', { animation: 'slideIn'});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>