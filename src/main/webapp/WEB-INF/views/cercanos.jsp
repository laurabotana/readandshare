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
		  <li class="nav-item">
			<a class="nav-link" href="home.html">Más valorados</a>
		  </li>
		  <li class="nav-item active">
			<a class="nav-link" href="#">Buscar cercanos<span class="sr-only">(current)</span></a>
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
	<section>
	
		<div class="embed-responsive embed-responsive-1by1">
			<iframe class="embed-responsive-item" src="https://www.openstreetmap.org/export/embed.html?bbox=-8.423037528991701%2C43.346340936566776%2C-8.390164375305178%2C43.36412734793574&amp;layer=mapnik"></iframe>
		</div>
		
	</section>
	
   
</body>
</html>