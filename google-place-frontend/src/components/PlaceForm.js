import React, { useState } from 'react';

const PlaceForm = ({ onSubmit }) => {
  const [latitude, setLatitude] = useState('');
  const [longitude, setLongitude] = useState('');
  const [radius, setRadius] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({ latitude, longitude, radius });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Latitude:
        <input
          type="text"
          value={latitude}
          onChange={(e) => setLatitude(e.target.value)}
        />
      </label>
      <label>
        Longitude:
        <input
          type="text"
          value={longitude}
          onChange={(e) => setLongitude(e.target.value)}
        />
      </label>
      <label>
        Radius:
        <input
          type="text"
          value={radius}
          onChange={(e) => setRadius(e.target.value)}
        />
      </label>
      <button type="submit">Find Nearby Places</button>
    </form>
  );
};

export default PlaceForm;
