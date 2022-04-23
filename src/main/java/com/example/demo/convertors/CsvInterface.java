package com.example.demo.convertors;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CsvInterface {
    public void save(MultipartFile file);
}
