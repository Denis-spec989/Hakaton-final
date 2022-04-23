package com.example.demo.configs;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy(value = false)
public class ConvertorsConfig {

    @Bean
    public Converter<Foo, PetrolStationDto> fooPetrolStationDtoConverter() {
        return new FooConvertor();
    }

    @Bean
    public Converter<Boo, PetrolStationDto> booPetrolStationDtoConverter() {
        return new BooConvertor();
    }

    @Bean
    public Converter<Csv, PetrolStationDto> csvPetrolStationDtoConverter() {
        return new CsvConvertor();
    }

    @Bean
    public Converter<Json, PetrolStationDto> jsonPetrolStationDtoConverter() {
        return new JsonConvertor();
    }
}
