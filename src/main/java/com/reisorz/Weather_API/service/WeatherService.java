package com.reisorz.Weather_API.service;

import com.reisorz.Weather_API.domain.CityCoordinates;
import com.reisorz.Weather_API.domain.WeatherRequestDetails;
import com.reisorz.Weather_API.entity.WeatherResponse;
import com.reisorz.Weather_API.provider.GeocodingProvider;
import com.reisorz.Weather_API.transformer.GeocodingCoordinatesTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private GeocodingProvider geocodingProvider;

    @Autowired
    private GeocodingCoordinatesTransformer geocodingCoordinatesTransformer;

    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails) throws Exception {
        //get latitude and longitude
        final CityCoordinates cityCoordinates = geocodingCoordinatesTransformer.transformToDomain(geocodingProvider.getCoordinates(weatherRequestDetails)) ;
    }
}
