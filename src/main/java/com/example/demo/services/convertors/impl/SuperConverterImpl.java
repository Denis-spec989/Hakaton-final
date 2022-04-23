package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Convertable;
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
public class SuperConverterImpl implements SuperConverter<Iterable<PetrolStationDto>> {
    private final Map<InputType, Converter<? extends Convertable, Iterable<PetrolStationDto>>> converters = new HashMap<>();

    @Override
    public boolean hasConverter(InputType type) {
        return this.converters.containsKey(type);
    }

    @Override
    public Iterable<InputType> getAvailableTypes() {
        return this.converters.keySet();
    }

    @Override
    public Converter<? extends Convertable, Iterable<PetrolStationDto>> getConverter(InputType type) {
        return this.converters.get(type);
    }

    @Override
    public void addConverter(Converter<? extends Convertable, Iterable<PetrolStationDto>> converter) {
        this.converters.put(converter.getType(), converter);
    }
}
