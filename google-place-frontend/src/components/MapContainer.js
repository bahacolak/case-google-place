import React from 'react';
import GoogleMapReact from 'google-map-react';

const MapContainer = ({ places }) => {
  const defaultProps = {
    center: {
      lat: places[0].latitude,
      lng: places[0].longitude
    },
    zoom: 0
  };

 const renderMarkers = (map, maps) => {
  let markers = places.map(place => {
    return new maps.Marker({
      position: { lat: place.latitude, lng: place.longitude },
      map,
      title: place.name
    })
  })

  return markers;
 };

  return (
    <div style={{ height: '100vh', width: '100%' }}>
      <GoogleMapReact
        bootstrapURLKeys={{ key: "AIzaSyBe-HZcT6yMniwEcvJ_ij9HqfcWgkwMhBE" }}
        defaultCenter={defaultProps.center}
        defaultZoom={defaultProps.zoom}
        onGoogleApiLoaded={({ map, maps }) => renderMarkers(map, maps)}
      >
      </GoogleMapReact>
    </div>
  );
};

export default MapContainer;
