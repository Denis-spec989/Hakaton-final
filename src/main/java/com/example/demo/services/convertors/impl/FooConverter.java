package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.AbstractConverter;
import com.example.demo.services.convertors.InputType;
import com.example.demo.services.convertors.SuperConverter;

public class FooConverter extends AbstractConverter<Foo, PetrolStationDto> {

    public FooConverter(SuperConverter<PetrolStationDto> superConverter) {
        super(superConverter);
    }

    @Override
    public PetrolStationDto convert(Foo input) {
        PetrolStationDto f = new PetrolStationDto();
        f.setName(input.getName());
        return f;
    }

    @Override
    public InputType getType() {
        return InputType.XLSX;
    }
}
