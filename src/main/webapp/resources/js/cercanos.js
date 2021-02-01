var markers = new Array();

$( document ).ready(function() {
//	markers = new Array();
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
	
	var listaUsuariosCercanos = JSON.parse(usuariosCercanosString);
	
	if(Array.isArray(listaUsuariosCercanos) && listaUsuariosCercanos.length > 0) {
		for(var i = 0; i<listaUsuariosCercanos.length;i++) {
			var datos = listaUsuariosCercanos[i];
			marcarMapa(datos, map, Icono);
		}
	}
	
});

function marcarMapa(datos, map, icono) {
	$.ajax({
		url: location.protocol + '//nominatim.openstreetmap.org/search?format=json&q='+unescape(encodeURIComponent(datos.localidad + ', ' + datos.provincia)),
		success: function (data) {
			if(Array.isArray(data) && data.length > 0) {
				var coord = null;
				for(var i = 0; i<data.length;i++) {
					var encontrado = false;
					if(Array.isArray(markers) && markers.length > 0) {
						for(var j = 0; j<markers.length; j++) {
							if(data[i].lat === markers[j].lat && data[i].lon === markers[j].lon) {
								encontrado = true;
								break;
							}
						}
					}
					if(!encontrado) {
						coord = {
							lat: data[i].lat,
							lon: data[i].lon
						};
						markers.push(coord);
						break;
					}
				}
				if(coord !== null) {
					L.marker(
					[ coord.lat, coord.lon ], {
						title : datos.alias,
						draggable : false,
						opacity : 1,
						icon : icono
					}).bindPopup('<a href="usuario.html?alias=' + datos.alias + '">'+ datos.alias +'</a>').addTo(map);
				}
			}   
		}
	});
}
