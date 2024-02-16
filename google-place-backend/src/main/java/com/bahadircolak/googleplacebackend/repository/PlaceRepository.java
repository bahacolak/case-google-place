package com.bahadircolak.googleplacebackend.repository;

import com.bahadircolak.googleplacebackend.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByLongitudeAndLatitudeAndRadius(double longitude, double latitude, double radius);

    Place findFirstByLongitudeAndLatitudeAndName(double longitude, double latitude, String name);
}
