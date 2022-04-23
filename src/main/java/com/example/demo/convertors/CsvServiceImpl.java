package com.example.demo.convertors;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.helper.CSVHelper;
import com.example.demo.services.impl.PetrolStationServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvServiceImpl {

    private final PetrolStationServiceImpl petrolStationService;

    public void save(MultipartFile file) throws IOException{
        try {
            List<PetrolStationDto> stations = CSVHelper.csvToPetrolStation(file.getInputStream());
            petrolStationService.save(stations);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
