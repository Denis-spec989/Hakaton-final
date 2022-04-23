package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;

public class BooConvertor implements Converter<Boo, PetrolStationDto> {

    @Override
    public PetrolStationDto convert(Boo input) {
        PetrolStationDto f = new PetrolStationDto();
        f.setName(input.getName());
        return f;
    }

    @Override
    public String getInputType() {
        return Boo.class.getName();
    }

    @Override
    public String getOutputType() {
        return PetrolStationDto.class.getName();
    }
}
