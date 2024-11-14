package com.reisorz.Weather_API.service;

import com.reisorz.Weather_API.domain.CityCoordinates;
import com.reisorz.Weather_API.domain.CityWeather;
import com.reisorz.Weather_API.domain.WeatherRequestDetails;
import com.reisorz.Weather_API.entity.WeatherResponse;
import com.reisorz.Weather_API.provider.GeocodingProvider;
import com.reisorz.Weather_API.provider.WeatherProvider;
import com.reisorz.Weather_API.transformer.GeocodingCoordinatesTransformer;
import com.reisorz.Weather_API.transformer.OpenWeatherTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private GeocodingProvider geocodingProvider;

    @Autowired
    private GeocodingCoordinatesTransformer geocodingCoordinatesTransformer;

    @Autowired
    private WeatherProvider weatherProvider;

    @Autowired
    private OpenWeatherTransformer openWeatherTransformer;

    @Cacheable(value = "getWeather", key = "#weatherRequestDetails.city", unless = "#result == null")
    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails) throws Exception {
        //get latitude and longitude from city
        final CityCoordinates cityCoordinates = geocodingCoordinatesTransformer
                .transformToDomain(geocodingProvider.getCoordinates(weatherRequestDetails));

        //get weather from cityCoordinates
        final CityWeather cityWeather = openWeatherTransformer
                .transformToDomain( weatherProvider.getWeather(cityCoordinates));

        return openWeatherTransformer.transformToEntity(cityWeather);

    }
}
