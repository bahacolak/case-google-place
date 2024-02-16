import React, { useState } from 'react';
import PlaceForm from './components/PlaceForm';
import MapContainer from './components/MapContainer';

function App() {
  const [places, setPlaces] = useState([]);

  const handleSubmit = ({ latitude, longitude, radius }) => {
    fetch(`http://localhost:8070/places?latitude=${latitude}&longitude=${longitude}&radius=${radius}`)
      .then((response) => response.json())
      .then((data) => setPlaces(data.places)
      .catch((error) => console.error('Error:', error)))
  };

  return (
    <div>
      <h1>Find Nearby Places</h1>
      <PlaceForm onSubmit={handleSubmit} />
      {!!places.length && <MapContainer places={places} />}
    </div>
  );
}

export default App;