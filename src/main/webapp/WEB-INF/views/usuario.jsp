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
			<form class=p-2 method="POST" action="mandarMensaje.html" >
				<p>Escribir un mensaje a <c:out value="${model.usuario.login}" /></p>
				<textarea  rows="4" cols="50" maxlength="500" name="mensaje"></textarea><br/>
				<input type="text" class="d-none" name="emisor" value="${model.usuarioOrigen.id}">
				<input type="text" class="d-none" name="receptor" value="${model.usuario.id}">
				<button class="btn btn-primary" type="submit" name="submit">Guardar</button>
				<button class="btn btn-success" type="reset" name="reset">Limpiar</button>
			</form>
			
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>