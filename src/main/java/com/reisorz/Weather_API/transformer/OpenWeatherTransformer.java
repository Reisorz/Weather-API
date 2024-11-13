package com.reisorz.Weather_API.transformer;

import com.reisorz.Weather_API.domain.CityWeather;
import com.reisorz.Weather_API.entity.OpenWeatherResponseEntity;
import com.reisorz.Weather_API.entity.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherTransformer {

    public CityWeather transformToDomain(OpenWeatherResponseEntity entity) {

        return CityWeather.builder()
                .weather(entity.getWeather()[0].getMain())
                .details(entity.getWeather()[0].getDescription())
                .build();
    }

    public WeatherResponse transformToEntity(CityWeather cityWeather) {
        return WeatherResponse.builder()
                .weather(cityWeather.getWeather())
                .details(cityWeather.getDetails())
                .build();
    }
}
