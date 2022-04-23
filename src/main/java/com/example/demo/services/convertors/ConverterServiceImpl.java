package com.example.demo.services.convertors;

import com.example.demo.dto.PetrolStationDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConverterServiceImpl implements ConverterService<Iterable<PetrolStationDto>> {
    private final Map<String, Converter<?, Iterable<PetrolStationDto>>> convertes = new HashMap<>();

    private ConverterServiceImpl(List<Converter<?, Iterable<PetrolStationDto>>> converterList) {
        System.out.println("Creating service");
        for (Converter<?, Iterable<PetrolStationDto>> converter : converterList) {
            System.out.println("Adding Converter<" + converter.getInputType() + ", " + converter.getOutputType() + ">");
            convertes.put(converter.getInputType(), converter);
        }
    }

    public <T> Iterable<PetrolStationDto> convert(T input) {
        Converter<T, Iterable<PetrolStationDto>> converter = (Converter<T, Iterable<PetrolStationDto>>) convertes.get(input.getClass().getName());
        return converter.convert(input);
    }
}
