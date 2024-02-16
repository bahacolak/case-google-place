package com.bahadircolak.googleplacebackend.repository;

import com.bahadircolak.googleplacebackend.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlaceRepository extends JpaRepository<Place, Long> {


}
