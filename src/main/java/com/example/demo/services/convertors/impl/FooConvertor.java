package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;

public class FooConvertor implements Converter<Foo, PetrolStationDto> {
    @Override
    public PetrolStationDto convert(Foo input) {
        PetrolStationDto f = new PetrolStationDto();
        f.setName(input.getName());
        return f;
    }

    @Override
    public String getInputType() {
        return Foo.class.getName();
    }

    @Override
    public String getOutputType() {
        return PetrolStationDto.class.getName();
    }
}
