package com.bahadircolak.googleplacebackend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class GooglePlacesApiConfiguration {

    @Value("${google.api.key}")
    private String googlePlacesApiKey;
}
