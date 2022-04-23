package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.AbstractConverter;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.InputType;
import com.example.demo.services.convertors.SuperConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SuperConverterImpl implements SuperConverter<PetrolStationDto> {
    private final Map<InputType, ? extends AbstractConverter<Object, PetrolStationDto>> converters = new HashMap<>();

    @Override
    public boolean hasConverter(InputType type) {
        return this.converters.containsKey(type);
    }

    @Override
    public Iterable<InputType> getAvailableTypes() {
        return this.converters.keySet();
    }

    @Override
    public <V extends Object> PetrolStationDto convert(InputType type, V input) {
        return this.converters.get(type).convert(input);
    }

    @Override
    public void addConverter(Converter<?, PetrolStationDto> converter) {

    }
}
