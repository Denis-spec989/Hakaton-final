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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public <T> void load(T input) throws IOException {
        Iterable<PetrolStationDto> petrolStationDtos = converterService.convert(input);
        save(petrolStationDtos);
    }

    @Override
    public List<PetrolStationModel> get(
            @Nullable Integer limit,
            @Nullable Integer offset,
            @Nullable String address,
            @Nullable Double latitude,
            @Nullable Double longtitude,
            @Nullable String name,
            @Nullable String country,
            @Nullable String phone,
            @Nullable String region
    ) {
        List<PetrolStationEntity> entities;
        if (limit != null && offset != null) {
            entities = petrolStationRepository.findAllByFilterPaginated(
                    address,
                    latitude,
                    longtitude,
                    name,
                    country,
                    phone,
                    region,
                    PageRequest.of(offset, limit, Sort.by("id").descending())
            );
        } else {
            entities = petrolStationRepository.findAllByFilter(
                    address,
                    latitude,
                    longtitude,
                    name,
                    country,
                    phone,
                    region
            );
        }
        List<PetrolStationModel> models = new ArrayList<>();

        for (PetrolStationEntity entity : entities) {
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
