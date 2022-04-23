package com.example.demo.services.convertors.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.services.convertors.Converter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CsvConvertor implements Converter<MultipartFile, Iterable<PetrolStationDto>> {

    @Override
    public ArrayList<PetrolStationDto> convert(MultipartFile file) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter('|'))) {
            ArrayList<PetrolStationDto> stations = new ArrayList<PetrolStationDto>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                PetrolStationDto station = new PetrolStationDto(csvRecord.get("address"), Double.parseDouble(csvRecord.get("latitude")), Double.parseDouble(csvRecord.get("longtitude")), csvRecord.get("name"), csvRecord.get("country"), csvRecord.get("phone"), csvRecord.get("region"));

                stations.add(station);
            }

            return stations;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    @Override
    public String getInputType() {
        return MultipartFile.class.getName();
    }

    @Override
    public String getOutputType() {
        return Iterable.class.getName();
    }
}
