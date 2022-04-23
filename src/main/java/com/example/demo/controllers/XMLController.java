package com.example.demo.controllers;

import com.example.demo.services.impl.XmlServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/xml")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XMLController {

    private final XmlServiceImpl xmlService;

    @ApiOperation(
            value = "Upload data using xml format"
    )
    @PostMapping(value = "", consumes = "multipart/form-data")
    public ResponseEntity<Object> createStations(@RequestParam("file") MultipartFile file) throws IOException {
        xmlService.save(file);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }
}
