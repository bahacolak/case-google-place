package com.bahadircolak.googleplacebackend.service;

import com.bahadircolak.googleplacebackend.config.GooglePlacesApiConfiguration;
import com.bahadircolak.googleplacebackend.web.dto.GooglePlaceResult;
import com.bahadircolak.googleplacebackend.web.response.GooglePlacesApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GooglePlacesApiService {

    private final GooglePlacesApiConfiguration googlePlacesApiConfiguration;
    private final RestTemplate restTemplate;

    public List<GooglePlaceResult> getNearbyPlaces(double longitude, double latitude, double radius) {
        String apiUrl = buildGooglePlacesApiUrl(longitude, latitude, radius);
        GooglePlacesApiResponse response = restTemplate.getForObject(apiUrl, GooglePlacesApiResponse.class);
        return response != null ? response.getResults() : Collections.emptyList();
    }

    private String buildGooglePlacesApiUrl(double longitude, double latitude, double radius) {
        String apiUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
        apiUrl += "location=" + latitude + "," + longitude;
        apiUrl += "&radius=" + radius;
        apiUrl += "&key=" + googlePlacesApiConfiguration.getGooglePlacesApiKey();
        return apiUrl;
    }
}
