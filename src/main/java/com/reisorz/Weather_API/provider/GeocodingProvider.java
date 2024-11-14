package com.reisorz.Weather_API.provider;

import com.reisorz.Weather_API.domain.WeatherRequestDetails;
import com.reisorz.Weather_API.entity.GeoCodingCoordinatesEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingProvider {

    @Value("${api.key}")
    private String apiKey;

    @Value("${geocoding.api.url}")
    private String geocodingUrl;

    //Provides coordinates (lon and lat) from the Geocoding API as a GeoCodingCoordinatesEntity object.
    public GeoCodingCoordinatesEntity getCoordinates(final WeatherRequestDetails weatherRequestDetails) throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<GeoCodingCoordinatesEntity[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null,null);

        //Build URL
        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("q", weatherRequestDetails.getCity())
                .queryParam("limit", "1")
                .queryParam("appid", apiKey).build();

        try {
            responseEntity = restTemplate
                    .exchange(uriBuilder.toUriString(),
                            HttpMethod.GET,
                            requestEntity,
                            GeoCodingCoordinatesEntity[].class);
        } catch (HttpStatusCodeException e) {
            throw new Exception(e.getMessage());
        }

        return  responseEntity.getBody()[0];


    }
}
