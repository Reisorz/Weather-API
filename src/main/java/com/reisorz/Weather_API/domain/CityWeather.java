package com.reisorz.Weather_API.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CityWeather {
    private String weather;
    private String details;
    private Float temp;
    private Integer humidity;
    private String icon;
}
