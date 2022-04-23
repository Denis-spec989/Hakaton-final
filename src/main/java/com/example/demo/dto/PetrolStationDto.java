package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetrolStationDto {
    private String address;

    private double latitude;

    private double longitude;

    private String name;

    private String country;

    private String phone;

    private String region;
}