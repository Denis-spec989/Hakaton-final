package com.example.demo.convertors;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CsvService {
    public void save(MultipartFile file) throws IOException;
}
