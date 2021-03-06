package com.example.demo.services.convertors.impl.models;

import com.example.demo.requests.PetrolStationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class Json {
    private final Iterable<PetrolStationRequest> petrolStations;
}
