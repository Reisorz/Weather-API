package com.reisorz.Weather_API.transformer;

import com.reisorz.Weather_API.domain.CityCoordinates;
import com.reisorz.Weather_API.entity.GeoCodingCoordinatesEntity;
import org.springframework.stereotype.Service;

@Service
public class GeocodingCoordinatesTransformer {

    //Transforms the GeoCodingCoordinatesEntity from GeocodingProvider into CityCoordinates object. Simplifying the data obtained.
    public CityCoordinates transformToDomain(GeoCodingCoordinatesEntity entity) {
        return CityCoordinates.builder()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }
}
