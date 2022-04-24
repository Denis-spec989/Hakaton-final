package com.example.demo.configs;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.impl.CsvConvertor;
import com.example.demo.services.convertors.impl.JsonConvertor;
import com.example.demo.services.convertors.impl.JsonMultipConvertor;
import com.example.demo.services.convertors.impl.XmlConverter;
import com.example.demo.services.convertors.impl.models.Csv;
import com.example.demo.services.convertors.impl.models.Json;
import com.example.demo.services.convertors.impl.models.JsonMultip;
import com.example.demo.services.convertors.impl.models.PXML;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy(value = false)
public class ConvertorsConfig {

    @Bean
    public Converter<Csv, Iterable<PetrolStationDto>> csvPetrolStationDtoConverter() {
        return new CsvConvertor();
    }

    @Bean
    public Converter<Json, Iterable<PetrolStationDto>> jsonPetrolStationDtoConverter() {
        return new JsonConvertor();
    }

    @Bean
    public Converter<JsonMultip, Iterable<PetrolStationDto>> jsonMultipPetrolStationDtoConverter() {
        return new JsonMultipConvertor();
    }

    @Bean
    public Converter<PXML, Iterable<PetrolStationDto>> pxmlIterableConverter() {
        return new XmlConverter();
    }
}
