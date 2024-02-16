package com.bahadircolak.googleplacebackend.web;

import com.bahadircolak.googleplacebackend.service.PlaceService;
import com.bahadircolak.googleplacebackend.web.response.PlacesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {

    private final PlaceService placeService;

    private static final Logger log = LoggerFactory.getLogger(PlaceController.class);

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places")
    public PlacesResponse getNearbyPlaces(@RequestParam double longitude,
                                          @RequestParam double latitude,
                                          @RequestParam double radius) {

        log.info("Received request with coordinates: {}, {}, radius: {}", longitude, latitude, radius);

        return new PlacesResponse(placeService.getNearbyPlaces(longitude, latitude, radius));
    }
}
