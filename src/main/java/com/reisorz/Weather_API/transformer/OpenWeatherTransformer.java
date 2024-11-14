package com.reisorz.Weather_API.transformer;

import com.reisorz.Weather_API.domain.CityWeather;
import com.reisorz.Weather_API.entity.OpenWeatherResponseEntity;
import com.reisorz.Weather_API.entity.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherTransformer {

    //Transforms the OpenWeatherResponseEntity from WeatherProvider into CityWeather object. Simplifying the data obtained.
    public CityWeather transformToDomain(OpenWeatherResponseEntity entity) {

        return CityWeather.builder()
                .weather(entity.getWeather()[0].getMain())
                .details(entity.getWeather()[0].getDescription())
                .temp(entity.getMain().getTemp())
                .humidity(entity.getMain().getHumidity())
                .build();
    }

    //Transforms CityWeather into a WeatherResponse
    public WeatherResponse transformToEntity(CityWeather cityWeather) {
        return WeatherResponse.builder()
                .weather(cityWeather.getWeather())
                .details(cityWeather.getDetails())
                .temp(cityWeather.getTemp())
                .humidity(cityWeather.getHumidity())
                .build();
    }
}
