package com.example.demo.configs;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.requests.PetrolStationRequest;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.impl.CsvConvertor;
import com.example.demo.services.convertors.impl.JsonConvertor;
import com.example.demo.services.convertors.impl.models.Json;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.multipart.MultipartFile;

@Configuration
@Lazy(value = false)
public class ConvertorsConfig {

    @Bean
    public Converter<MultipartFile, Iterable<PetrolStationDto>> csvPetrolStationDtoConverter() {
        return new CsvConvertor();
    }

    @Bean
    public Converter<Json, Iterable<PetrolStationDto>> jsonPetrolStationDtoConverter() {
        return new JsonConvertor();
    }
}
