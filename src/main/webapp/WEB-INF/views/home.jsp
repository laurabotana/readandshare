<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<body>
	<header>
		<h1>ReadShare</h1>
	</header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">
			<img src="static/img/icono.png" width="30" height="30" alt="">
		</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" 
			  data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
			  aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
		  <li class="nav-item active">
			<a class="nav-link" href="#">Más valorados <span class="sr-only">(current)</span></a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="cercanos.html">Buscar cercanos</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="miPerfil.html">Mi perfil</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="register.html">Registrarse</a>
		  </li>
		</ul>
		
		<form class="form-inline my-2 my-lg-0">
		  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	  </div>
	</nav>
	
   <section class="gallery-block cards-gallery">
	    <div class="container">
	        <div class="heading">
	          <h2>Libros más valorados</h2>
	        </div>
	        <div class="row">
	            <div class="col-4 col-md-2">
	                <div class="card border-0 transform-on-hover">
	                	<a class="lightbox" href="static/img/quijote.jpg">
	                		<img src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
	                	</a>
	                    <div class="card-body">
	                        <h6><a href="#">El quijote</a></h6>
	                        <p class="text-muted card-text">Miguel de Cervantes</p>
	                    </div>
	                </div>
	            </div>
	            <div class="col-4 col-md-2">
	                <div class="card border-0 transform-on-hover">
						<a class="lightbox" href="static/img/quijote.jpg">
		                	<img src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
		                </a>
	                    <div class="card-body">
	                        <h6><a href="#">El quijote</a></h6>
	                        <p class="text-muted card-text">Miguel de Cervantes</p>
	                    </div>
	                </div>
	            </div>
	            <div class="col-4 col-md-2">
	                <div class="card border-0 transform-on-hover">
	                	<a class="lightbox" href="static/img/quijote.jpg">
	                		<img src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
	                	</a>
	                    <div class="card-body">
	                        <h6><a href="#">El quijote</a></h6>
	                        <p class="text-muted card-text">Miguel de Cervantes</p>
	                    </div>
	                </div>
	            </div>
	            <div class="col-4 col-md-2">
	                <div class="card border-0 transform-on-hover">
	                	<a class="lightbox" href="static/img/quijote.jpg">
	                		<img src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
	                	</a>
	                    <div class="card-body">
	                        <h6><a href="#">El quijote</a></h6>
	                        <p class="text-muted card-text">Miguel de Cervantes</p>
	                    </div>
	                </div>
	            </div>
	            <div class="col-4 col-md-2">
	                <div class="card border-0 transform-on-hover">
	                	<a class="lightbox" href="static/img/quijote.jpg">
	                		<img src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
	                	</a>
	                    <div class="card-body">
	                        <h6><a href="#">El quijote</a></h6>
	                        <p class="text-muted card-text">Miguel de Cervantes</p>
	                    </div>
	                </div>
	            </div>
	            <div class="col-4 col-md-2">
	                <div class="card border-0 transform-on-hover">
	                	<a class="lightbox" href="static/img/quijote.jpg">
	                		<img src="static/img/quijote.jpg" alt="Card Image" class="card-img-top">
	                	</a>
	                    <div class="card-body">
	                        <h6><a href="#">El quijote</a></h6>
	                        <p class="text-muted card-text">Miguel de Cervantes</p>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
    </section>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script>
        baguetteBox.run('.cards-gallery', { animation: 'slideIn'});
    </script>
</body>
</html>