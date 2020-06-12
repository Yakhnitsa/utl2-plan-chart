function showMap(mapId,stationArray){
    var mymap = L.map(mapId).setView([50.440989, 30.489694], 8);

    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox.streets',
        accessToken: 'your.mapbox.access.token'
    }).addTo(mymap);

    var mainIcon = L.icon({
        iconUrl: '/static/img/map_icons/UTL2_flag.png',
        shadowUrl: '/static/img/map_icons/UTL2_flag_shadow.png',

        iconSize:     [38, 95], // size of the icon
        shadowSize:   [50, 64], // size of the shadow
        iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
        shadowAnchor: [4, 62],  // the same for the shadow
        popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    L.marker([50.440989, 30.489694],{icon: mainIcon}).addTo(mymap)
        .bindPopup("<b>УТЛ-2</b><br />Мы здесь").openPopup();

    if(stationArray != null){
        stationArray.forEach(addPoint);
    }



    // L.circle([50.518544, 30.234004], 1000, {
    //     color: 'red',
    //     fillColor: '#f03',
    //     fillOpacity: 0.5
    // }).addTo(mymap).bindPopup("I am a circle.");
    //
    // L.polygon([
    //     [48.512111, 32.260717],
    //     [50.069991, 31.453183],
    //     [49.234111, 28.468438]
    // ]).addTo(mymap).bindPopup("I am a polygon.");


    var popup = L.popup();

    function onMapClick(e) {
        popup
            .setLatLng(e.latlng)
            .setContent("Координаты: " + e.latlng.toString())
            .openOn(mymap);
    }

    mymap.on('click', onMapClick);


    function addPoint(value){
        L.marker([value.locationX,value.locationY],{icon: mainIcon}).addTo(mymap)
            .bindPopup(value.rusName);
        ;
    }
}