package com.reisorz.Weather_API.entity;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WeatherResponse implements Serializable {
    private String weather;
    private String details;
    private Float temp;
    private Integer humidity;
    private String icon;
}
