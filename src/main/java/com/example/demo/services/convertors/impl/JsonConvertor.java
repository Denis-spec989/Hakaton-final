package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.requests.PetrolStationRequest;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.impl.models.Json;

import java.util.ArrayList;

public class JsonConvertor implements Converter<Json, Iterable<PetrolStationDto>> {


    @Override
    public Iterable<PetrolStationDto> convert(Json input) {
        ArrayList<PetrolStationDto> dtos = new ArrayList<>();
        for (PetrolStationRequest request : input.getPetrolStations()) {
            dtos.add(
                    new PetrolStationDto(
                            request.getAddress(),
                            request.getLatitude(),
                            request.getLongtitude(),
                            request.getName(),
                            request.getCountry(),
                            request.getPhone(),
                            request.getRegion()
                    )
            );
        }

        return dtos;
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
