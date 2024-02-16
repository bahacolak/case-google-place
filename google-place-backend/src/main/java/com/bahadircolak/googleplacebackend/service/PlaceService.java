package com.bahadircolak.googleplacebackend.service;

import com.bahadircolak.googleplacebackend.model.Place;
import com.bahadircolak.googleplacebackend.repository.PlaceRepository;
import com.bahadircolak.googleplacebackend.web.dto.GooglePlaceResult;
import com.bahadircolak.googleplacebackend.web.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final GooglePlacesApiService googlePlacesApiService;

    public List<PlaceDto> getNearbyPlaces(double longitude, double latitude, double radius) {
        List<Place> placesFromDatabase = placeRepository.findByLongitudeAndLatitudeAndRadius(longitude, latitude, radius);
        List<PlaceDto> nearbyPlacesDto = new ArrayList<>();

        if (!placesFromDatabase.isEmpty()) {
            for (Place place : placesFromDatabase) {
                nearbyPlacesDto.add(PlaceDto.fromEntity(place));
            }
        } else {
            List<GooglePlaceResult> googlePlaces = googlePlacesApiService.getNearbyPlaces(longitude, latitude, radius);

            for (GooglePlaceResult googlePlace : googlePlaces) {
                Place existingPlace = placeRepository.findFirstByLongitudeAndLatitudeAndName(
                        googlePlace.getGeometry().getLocation().getLng(),
                        googlePlace.getGeometry().getLocation().getLat(),
                        googlePlace.getName());

                if (existingPlace == null) {
                    Place newPlace = new Place();
                    newPlace.setName(googlePlace.getName());
                    newPlace.setLongitude(googlePlace.getGeometry().getLocation().getLng());
                    newPlace.setLatitude(googlePlace.getGeometry().getLocation().getLat());
                    newPlace.setRadius(radius);
                    placeRepository.save(newPlace);
                    nearbyPlacesDto.add(PlaceDto.fromApiResponse(googlePlace));
                } else {
                    nearbyPlacesDto.add(PlaceDto.fromEntity(existingPlace));
                }
            }
        }

        return nearbyPlacesDto;
    }

}
