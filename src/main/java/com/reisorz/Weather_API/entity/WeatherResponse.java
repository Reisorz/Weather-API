package com.reisorz.Weather_API.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WeatherResponse {
    private String weather;
    private String details;
}
