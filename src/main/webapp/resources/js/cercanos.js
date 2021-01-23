$( document ).ready(function() {
    var map = L.map('map', {
					center : [ 43.3197, -8.3626 ],
					zoom : 11,
					maxBounds : [ [ 43, -9 ], [ 43.5, -8 ] ],
					minZoom : 10,
					maxZoom : 20
				});

	L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png',{attribution : '© <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
								}).addTo(map);

	var Icono = L.icon({
							iconUrl : "https://icons.getbootstrap.com/icons/person.svg",
							iconSize : [ 30, 40 ],
							iconAnchor : [ 15, 40 ],
							popupAnchor : [ 0, -40 ]
						});

	var usuariosCercanosString = $("#idListaUsuariosCercanos").text().trim();
	
	var listaUsuariosCercanos = usuariosCercanosString.split(";");
	
	if(Array.isArray(listaUsuariosCercanos) && listaUsuariosCercanos.length > 0) {
		for(var i = 0; i<listaUsuariosCercanos.length;i++) {
			var usuarioLocalidad = JSON.parse(JSON.stringify(listaUsuariosCercanos[i].split(",")));
			if(Array.isArray(usuarioLocalidad) && usuarioLocalidad.length == 2) {
				var datos = {
					usuario: unescape(encodeURIComponent(usuarioLocalidad[0])),
					localidad: unescape(encodeURIComponent(usuarioLocalidad[1]))
				};
				$.ajax({
					url: location.protocol + '//nominatim.openstreetmap.org/search?format=json&q='+datos.localidad,
					async: false,
					success: function (data) {
						if(Array.isArray(data) && data.length > 0) {
							L.marker(
							[ data[0].lat, data[0].lon ], {
								title : datos.usuario,
								draggable : false,
								opacity : 1,
								icon : Icono
							}).bindPopup('<a href="usuario.html?alias=' + datos.usuario + '">'+ datos.usuario +'</a>').addTo(map);
						}   
					}
				});
			}
		}	
	}

//	var pepe = L.marker([ 43.30543518333978, -8.50927833575279 ], {
//					title : "pepe",
//					draggable : false,
//					opacity : 1,
//					icon : Icono
//				}).bindPopup("<i>pepe</i>").addTo(map);
//
//	var usuCambre = L.marker(
//						[ 43.29210173197645, -8.344515647049395 ], {
//							title : "usuCambre",
//							draggable : false,
//							opacity : 1,
//							icon : Icono
//						}).bindPopup("<i>usuCambre</i>").addTo(map);
//
//	var pruebaUsuario = L.marker(
//						[ 43.35577793290818, -8.406004672215566 ], {
//							title : "pruebaUsuario",
//							draggable : false,
//							opacity : 1,
//							icon : Icono
//						}).bindPopup('<a href="usuario.html?alias=pruebaUsuario">pruebaUsuario</a>').addTo(map);
});

