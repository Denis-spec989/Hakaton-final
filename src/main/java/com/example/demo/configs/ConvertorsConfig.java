package com.example.demo.configs;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.ConverterServiceImpl;
import com.example.demo.services.convertors.impl.Boo;
import com.example.demo.services.convertors.impl.BooConvertor;
import com.example.demo.services.convertors.impl.Foo;
import com.example.demo.services.convertors.impl.FooConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

import java.awt.geom.RectangularShape;

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
    public RestTemplate restTemplate(ConverterServiceImpl converterService) {
        System.out.println(
                converterService.convert(
                        new Foo()
                ).getName()
        );
        return new RestTemplate();
    }
}
