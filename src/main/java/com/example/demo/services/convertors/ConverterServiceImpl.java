package com.example.demo.services.convertors;

import com.example.demo.dto.PetrolStationDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConverterServiceImpl implements ConverterService<PetrolStationDto> {
    private final Map<String, Converter<?, PetrolStationDto>> convertes = new HashMap<>();

    private ConverterServiceImpl(List<Converter<?, PetrolStationDto>> converterList) {
        System.out.println("Creating service");
        for (Converter<?, PetrolStationDto> converter : converterList) {
            System.out.println("Adding Converter<" + converter.getInputType() + ", " + converter.getOutputType() + ">");
            convertes.put(converter.getInputType(), converter);
        }
    }

    public <T> PetrolStationDto convert(T input) {
        Converter<T, PetrolStationDto> converter = (Converter<T, PetrolStationDto>) convertes.get(input.getClass().getName());
        return converter.convert(input);
    }
}
