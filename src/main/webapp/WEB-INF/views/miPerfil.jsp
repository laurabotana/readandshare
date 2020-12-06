<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="heading">
				<h2>Mis datos</h2>
			</div>
			<p>
				Alias:
				<c:out value="${perfil.login}" />
			</p>
			<p>
				Mail:
				<c:out value="${perfil.mail}" />
			</p>
			<p>
				Nombre:
				<c:out value="${perfil.nombre}" />
			</p>
			<p>
				Apellidos:
				<c:out value="${perfil.apellidos}" />
			</p>
			<p>
				Provincia:
				<c:out value="${perfil.provincia}" />
			</p>
			<p>
				Localidad:
				<c:out value="${perfil.localidad}" />
			</p>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>