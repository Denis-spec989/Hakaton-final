package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PetrolStationModel {
    private final UUID id;
    private final double latitude;
    private final double longtitude;
    private final String name;
    private final String country;
    private final String phone;
    private final String region;
}
