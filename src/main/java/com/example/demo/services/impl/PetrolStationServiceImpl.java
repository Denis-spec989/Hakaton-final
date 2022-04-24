package com.example.demo.services.impl;

import com.example.demo.dto.PetrolStationDto;
import com.example.demo.entities.PetrolStationEntity;
import com.example.demo.exceptions.ConverterNotFoundException;
import com.example.demo.models.PetrolStationModel;
import com.example.demo.repository.PetrolStationRepository;
import com.example.demo.services.PetrolStationService;
import com.example.demo.services.convertors.ConverterService;
import com.example.demo.services.convertors.ConverterServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PetrolStationServiceImpl implements PetrolStationService {
    private final PetrolStationRepository petrolStationRepository;
    private final ConverterService<Iterable<PetrolStationDto>> converterService;

    PetrolStationEntity dtoToEntity(PetrolStationDto petrolStationDto) {
        return new PetrolStationEntity(
                petrolStationDto.getAddress(),
                petrolStationDto.getLatitude(),
                petrolStationDto.getLongtitude(),
                petrolStationDto.getName(),
                petrolStationDto.getCountry(),
                petrolStationDto.getPhone(),
                petrolStationDto.getRegion()
        );
    }

    @Override
    public void save(PetrolStationDto petrolStationDto) {
        petrolStationRepository.save(
                dtoToEntity(petrolStationDto)
        );
    }

    @Override
    public void save(Iterable<PetrolStationDto> petrolStationDtos) {
        ArrayList<PetrolStationEntity> petrolStationEntities = new ArrayList<>();
        for (PetrolStationDto dto : petrolStationDtos) {
            petrolStationEntities.add(
                    dtoToEntity(dto)
            );
        }

        petrolStationRepository.saveAll(petrolStationEntities);
    }

    @Override
    public <T> void load(T input) {
        Iterable<PetrolStationDto> petrolStationDtos = converterService.convert(input);
        save(petrolStationDtos);
    }

    @Override
    public List<PetrolStationModel> get() {
        List<PetrolStationEntity> entites = petrolStationRepository.findAll();
        List<PetrolStationModel> models = new ArrayList<>();

        for (PetrolStationEntity entity : entites) {
            models.add(
                    new PetrolStationModel(
                            entity.getId(),
                            entity.getLatitude(),
                            entity.getLongtitude(),
                            entity.getName(),
                            entity.getCountry(),
                            entity.getPhone(),
                            entity.getRegion(),
                            entity.getAddress()
                    )
            );
        }

        return models;
    }


}
