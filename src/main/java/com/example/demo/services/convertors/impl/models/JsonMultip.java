package com.example.demo.services.convertors.impl.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class JsonMultip {
    private final MultipartFile multipartFile;
}
