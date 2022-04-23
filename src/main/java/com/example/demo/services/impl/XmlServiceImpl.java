package com.example.demo.services.impl;

import com.example.demo.convertors.XmlConverterImpl;
import com.example.demo.dto.PetrolStationDto;
import com.example.demo.helper.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class XmlServiceImpl {

    @Autowired
    private PetrolStationServiceImpl petrolStationService;
    private XmlConverterImpl xmlConverter;

    public void save(MultipartFile file) throws IOException {
        petrolStationService.save(xmlConverter.parseXML(file));
    }
}
