package com.bahadircolak.googleplacebackend.web.dto;

import com.bahadircolak.googleplacebackend.model.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlaceDto {

    private String name;
    private double longitude;
    private double latitude;

    public static PlaceDto fromEntity(Place place) {
        return new PlaceDto(place.getName(), place.getLongitude(), place.getLatitude());
    }

    public static PlaceDto fromApiResponse(GooglePlaceResult googlePlaceResult) {
        return new PlaceDto(googlePlaceResult.getName(), googlePlaceResult.getGeometry().getLocation().getLng(), googlePlaceResult.getGeometry().getLocation().getLat());
    }
}
