package com.bahadircolak.googleplacebackend.web.response;

import com.bahadircolak.googleplacebackend.web.dto.PlaceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlacesResponse {

    private List<PlaceDto> places;
}
