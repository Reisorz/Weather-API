package com.reisorz.Weather_API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainEntity {

    @JsonProperty("temp")
    private String temp;
    @JsonProperty("humidity")
    private String humidity;

}
