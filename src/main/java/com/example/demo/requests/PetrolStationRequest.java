package com.example.demo.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class PetrolStationRequest {
    private final String address;
    private final double latitude;
    private final double longtitude;
    private final String name;
    private final String country;
    private final String phone;
    private final String region;
}
