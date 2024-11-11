package com.reisorz.Weather_API.controller;

import com.reisorz.Weather_API.domain.WeatherRequestDetails;
import com.reisorz.Weather_API.entity.WeatherResponse;
import com.reisorz.Weather_API.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather-api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public @ResponseBody WeatherResponse weather(@PathVariable("city") String city) {
        final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                .city(city)
                .build();

    }
}
