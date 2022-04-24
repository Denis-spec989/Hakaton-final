package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import com.example.demo.services.convertors.impl.models.Csv;
import com.example.demo.services.convertors.impl.models.JsonMultip;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JsonMultipConvertor implements Converter<JsonMultip, Iterable<PetrolStationDto>> {

    @Override
    public ArrayList<PetrolStationDto> convert(JsonMultip input) throws IOException {
        //BufferedReader fileReader = new BufferedReader(new InputStreamReader(input.getMultipartFile().getInputStream(), StandardCharsets.UTF_8));
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        stream.write(input.getMultipartFile().getBytes());
        String finalString = new String(stream.toByteArray());

        ArrayList<PetrolStationDto> stations = new ArrayList<PetrolStationDto>();
        stations = new ObjectMapper().readValue(finalString, new TypeReference<ArrayList<PetrolStationDto>>() {});
             return stations;
        }

    @Override
    public String getInputType() {
        return JsonMultip.class.getName();
    }

    @Override
    public String getOutputType() {
        return Iterable.class.getName();
    }
}