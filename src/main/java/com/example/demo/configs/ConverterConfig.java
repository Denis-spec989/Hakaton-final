package com.example.demo.configs;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.InputType;
import com.example.demo.services.convertors.SuperConverter;
import com.example.demo.services.convertors.impl.Foo;
import com.example.demo.services.convertors.impl.FooConverter;
import io.swagger.v3.oas.models.media.XML;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConverterConfig {

    @Bean
    public Converter<Foo, PetrolStationDto> foo(SuperConverter<PetrolStationDto> superConverter) {
        return new FooConverter(superConverter);
    }


    @Bean
    public RestTemplate test(Converter<Foo, PetrolStationDto> f, SuperConverter<PetrolStationDto> superConverter) {
        Converter<Foo, PetrolStationDto> cvn = (Converter<Foo, PetrolStationDto>) superConverter.getConverter(InputType.XLSX);
        System.out.println(cvn.convert(new Foo()));

        return new RestTemplate();
    }
}
