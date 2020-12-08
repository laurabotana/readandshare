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
				<c:out value="${model.usuario.login}" />
			</p>
			<p>
				Mail:
				<c:out value="${model.usuario.mail}" />
			</p>
			<p>
				Nombre:
				<c:out value="${model.usuario.nombre}" />
			</p>
			<p>
				Apellidos:
				<c:out value="${model.usuario.apellidos}" />
			</p>
			<p>
				Provincia:
				<c:out value="${model.usuario.provincia}" />
			</p>
			<p>
				Localidad:
				<c:out value="${model.usuario.localidad}" />
			</p>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>