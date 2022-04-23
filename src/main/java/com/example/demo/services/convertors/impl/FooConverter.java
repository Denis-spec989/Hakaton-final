package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.AbstractConverter;
import com.example.demo.services.convertors.InputType;
import com.example.demo.services.convertors.SuperConverter;

import java.util.ArrayList;
import java.util.List;

public class FooConverter extends AbstractConverter<Foo, Iterable<PetrolStationDto>> {

    public FooConverter(SuperConverter<Iterable<PetrolStationDto>> superConverter) {
        super(superConverter);
    }

    @Override
    public Iterable<PetrolStationDto> convert(Foo input) {
        PetrolStationDto f = new PetrolStationDto();
        f.setName(input.getName());
        List<PetrolStationDto> fo = new ArrayList<>();
        fo.add(f);
        return fo;
    }

    @Override
    public InputType getType() {
        return InputType.XLSX;
    }
}
