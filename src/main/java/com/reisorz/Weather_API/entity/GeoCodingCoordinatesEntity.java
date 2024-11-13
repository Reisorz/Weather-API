package com.reisorz.Weather_API.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCodingCoordinatesEntity {

    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lon")
    private String longitude;

}
