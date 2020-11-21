<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<body>
	<header>
		<h1>ReadShare</h1>
	</header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"> <img src="static/img/icono.png"
			width="30" height="30" alt="">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="home.html">Más
						valorados</a></li>
				<li class="nav-item"><a class="nav-link" href="cercanos.html">Buscar
						cercanos</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">Mi
						perfil<span class="sr-only">(current)</span>
				</a></li>
				  <li class="nav-item">
					<a class="nav-link" href="formRegistro.html">Registrarse</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="login.html">Loguearse</a>
				  </li>
			</ul>

			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<section class="gallery-block cards-gallery">
		<div class="container">
			<div class="heading">
				<h2>Mis datos</h2>
			</div>
			<p>Alias: <c:out value="${perfil.login}"/></p>
			<p>Mail: <c:out value="${perfil.mail}"/></p>
			<p>Nombre: <c:out value="${perfil.nombre}"/></p>
			<p>Apellidos: <c:out value="${perfil.apellidos}"/></p>
			<p>Provincia: <c:out value="${perfil.provincia}"/></p>
			<p>Localidad: <c:out value="${perfil.localidad}"/></p>
		
		</div>
		
		
	</section>
	<section class="gallery-block cards-gallery">
		<div class="container">
			<div class="heading">
				<h2>Lista de deseos</h2>
			</div>
			<div class="row">
				<div class="col-4 col-md-2">
					<div class="card border-0 transform-on-hover">
						<a class="lightbox" href="static/img/quijote.jpg"> <img
							src="static/img/quijote.jpg" alt="Card Image"
							class="card-img-top">
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
							src="static/img/quijote.jpg" alt="Card Image"
							class="card-img-top">
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
						<a class="lightbox" href="static/img/image3.jpg"> <img
							src="static/img/quijote.jpg" alt="Card Image"
							class="card-img-top">
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
							src="static/img/quijote.jpg" alt="Card Image"
							class="card-img-top">
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
							src="static/img/quijote.jpg" alt="Card Image"
							class="card-img-top">
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
							src="static/img/quijote.jpg" alt="Card Image"
							class="card-img-top">
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
	<section class="gallery-block cards-gallery">
		<div class="container">
			<div class="heading">
				<h2>Mi biblioteca</h2>
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
</body>
</html>