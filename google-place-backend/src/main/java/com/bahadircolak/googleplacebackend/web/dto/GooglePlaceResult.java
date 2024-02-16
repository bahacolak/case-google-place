package com.bahadircolak.googleplacebackend.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GooglePlaceResult {

    private String name;
    private Geometry geometry;
}
