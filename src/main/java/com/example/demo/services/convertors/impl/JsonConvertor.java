package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonConvertor implements Converter<Json, PetrolStationDto> {


    @Override
    public PetrolStationDto convert(Json input) {
        return new PetrolStationDto();
    }

    @Override
    public String getInputType() {
        return null;
    }

    @Override
    public String getOutputType() {
        return null;
    }

}
