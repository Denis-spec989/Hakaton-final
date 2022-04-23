package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;

import java.util.ArrayList;

public class JsonConvertor implements Converter<Json, Iterable<PetrolStationDto>> {


    @Override
    public Iterable<PetrolStationDto> convert(Json input) {
        return new ArrayList<>();
    }

    @Override
    public String getInputType() {
        return Json.class.getName();
    }

    @Override
    public String getOutputType() {
        return Iterable.class.getName();
    }

}
