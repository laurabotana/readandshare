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

function composeTitle(marker) {
	var title = null;
	if(Array.isArray(marker) && marker.length > 0) {
		for(var i = 0; i<marker.length; i++) {
			if(title === null) {
				title = '';
			} else {
				title = title.concat(', ');
			}
			title = title.concat(marker[i].alias);
		}
	}
	return title;
}

function composeLinks(marker) {
	var links = null;
	if(Array.isArray(marker) && marker.length > 0) {
		for(var i = 0; i<marker.length; i++) {
			if(links === null) {
				links = '';
			} else {
				links = links.concat('<br />');
			}
			links = links.concat('<a href="usuario.html?alias=' + marker[i].alias + '">'+ marker[i].alias +'</a>');
		}
	}
	return links;
}

function marcarMapa(datos, map, icono) {
	$.ajax({
		url: location.protocol + '//nominatim.openstreetmap.org/search?format=json&q='+unescape(encodeURIComponent(datos.localidad + ', ' + datos.provincia)),
		success: function (data) {
			if(Array.isArray(data) && data.length > 0) {
				var title = null;
				var links = null;
				var coord = null;
				for(var i = 0; i<data.length;i++) {
					var pos = null;
					if(Array.isArray(markers) && markers.length > 0) {
						for(var j = 0; j<markers.length; j++) {
							if(Array.isArray(markers[j]) && markers[j].length > 0) {
								for(var k = 0; k<markers[j].length; k++) {
									if(data[i].lat === markers[j][k].coord.lat && data[i].lon === markers[j][k].coord.lon) {
										pos = j;
										break;
									}
								}
								if(pos !== null) {
									break;
								}
							}
						}
					}
					var datosUsuario = {
						alias: datos.alias,
						coord : {
							lat: data[i].lat,
							lon: data[i].lon
						}
					}
					coord = datosUsuario.coord;
					if(pos !== null) {
						var marker = markers[pos];
						marker.push(datosUsuario);
						markers[pos] = marker;
					} else {
						var marker = new Array();
						marker.push(datosUsuario);
						markers.push(marker);
					}
					title = composeTitle(pos !== null ? markers[pos] : markers[markers.length -1]);
					links = composeLinks(pos !== null ? markers[pos] : markers[markers.length -1]);
				}
				if(coord !== null && title !== null && links !== null) {
					L.marker(
					[ coord.lat, coord.lon ], {
						title : title,
						draggable : false,
						opacity : 1,
						icon : icono
					}).bindPopup(links).addTo(map);
				}
			}   
		}
	});
}