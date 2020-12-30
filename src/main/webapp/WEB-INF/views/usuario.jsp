<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="heading">
				<h2>Datos</h2>
			</div>
			<p>
				Alias:
				<c:out value="${model.usuario.login}" />
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