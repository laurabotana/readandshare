<%@ include file="/WEB-INF/views/include.jsp" %>
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
		  <c:choose>
		  	<c:when test = "${!model.sesionIniciada}">
				<li class="nav-item"><a class="nav-link" href="login.html">Loguearse</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="formRegistro.html">Registrarse</a></li>
			</ul>
			</c:when>
		  	<c:otherwise>
				<li class="nav-item"><a class="nav-link" href="miPerfil.html">Mi
						perfil</a></li>
				<li class="nav-item"><a class="nav-link" href="formAutor.html">Añadir
						Autor</a></li>
				<li class="nav-item"><a class="nav-link" href="formLibro.html">Añadir
						Libro</a></li>
				<li class="nav-item"><a class="nav-link" href="cercanos.html">Buscar
						cercanos</a></li>
				</ul>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item"><a class="nav-link" href="logout.html">Cerrar
							sesión ${model.alias}</a></li>
				</ul>
			</c:otherwise>
		  </c:choose>
		</ul>
	</div>
</nav>