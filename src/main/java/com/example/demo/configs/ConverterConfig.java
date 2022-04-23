package com.example.demo.configs;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.InputType;
import com.example.demo.services.convertors.SuperConverter;
import com.example.demo.services.convertors.impl.Foo;
import com.example.demo.services.convertors.impl.FooConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConverterConfig {

    @Bean
    public Converter<Foo, Iterable<PetrolStationDto>> foo(SuperConverter<Iterable<PetrolStationDto>> superConverter) {
        return new FooConverter(superConverter);
    }


    @Bean
    public RestTemplate test(Converter<Foo, Iterable<PetrolStationDto>> f, SuperConverter<Iterable<PetrolStationDto>> superConverter) {
        Converter<Foo, Iterable<PetrolStationDto>> cvn = (Converter<Foo, Iterable<PetrolStationDto>>) superConverter.getConverter(InputType.XLSX);
        System.out.println(cvn.convert(new Foo()));

        return new RestTemplate();
    }
}
