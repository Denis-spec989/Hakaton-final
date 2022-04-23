package com.example.demo.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PetrolStationResponse {
    private final String uuid;
    private final String address;
    private final double latitude;
    private final double longtitude;
    private final String name;
    private final String country;
    private final String phone;
    private final String region;
}
