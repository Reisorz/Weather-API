package com.reisorz.Weather_API.provider;

import com.reisorz.Weather_API.domain.CityCoordinates;
import com.reisorz.Weather_API.domain.WeatherRequestDetails;
import com.reisorz.Weather_API.entity.GeoCodingCoordinatesEntity;
import com.reisorz.Weather_API.entity.OpenWeatherResponseEntity;
import com.reisorz.Weather_API.entity.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherProvider {

    @Value("${api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String weatherUrl;


    //Provides weather from the Weather API as a WeatherResponse object.
    public OpenWeatherResponseEntity getWeather(final CityCoordinates cityCoordinates) throws Exception {
        //Geocoding API call

        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<OpenWeatherResponseEntity> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null,null);

        //Build URL
        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(weatherUrl)
                .queryParam("lat", cityCoordinates.getLatitude())
                .queryParam("lon", cityCoordinates.getLongitude())
                .queryParam("appid", apiKey).build();

        try {
            responseEntity = restTemplate
                    .exchange(uriBuilder.toUriString(),
                            HttpMethod.GET,
                            requestEntity,
                            OpenWeatherResponseEntity.class);
        } catch (HttpStatusCodeException e) {
            throw new Exception(e.getMessage());
        }

        return  responseEntity.getBody();


    }
}