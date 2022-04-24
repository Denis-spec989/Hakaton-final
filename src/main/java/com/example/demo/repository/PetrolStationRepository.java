package com.example.demo.repository;

import com.example.demo.entities.PetrolStationEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.UUID;

public interface PetrolStationRepository extends JpaRepository<PetrolStationEntity, UUID> {

    @Query("select new PetrolStationEntity(p.id, p.address, p.latitude, p.longtitude, p.name, p.country, p.phone, p.region) from PetrolStationEntity p where (:address is null or p.address=:address) and (:latitude is null or p.latitude=:latitude) and (:longitude is null or p.longtitude=:longitude) and (:name is null or p.name=:name) and (:country is null or p.country=:country) and (:phone is null or p.phone=:phone) and (:region is null or p.region like :region)")
    List<PetrolStationEntity> findAllByFilter(
            @Nullable String address,
            @Nullable Double latitude,
            @Nullable Double longitude,
            @Nullable String name,
            @Nullable String country,
            @Nullable String phone,
            @Nullable String region
    );

    @Query("select new PetrolStationEntity(p.id, p.address, p.latitude, p.longtitude, p.name, p.country, p.phone, p.region) from PetrolStationEntity p where (:address is null or p.address=:address) and (:latitude is null or p.latitude=:latitude) and (:longitude is null or p.longtitude=:longitude) and (:name is null or p.name=:name) and (:country is null or p.country=:country) and (:phone is null or p.phone=:phone) and (:region is null or p.region like :region)")
    List<PetrolStationEntity> findAllByFilterPaginated(
            @Nullable String address,
            @Nullable Double latitude,
            @Nullable Double longitude,
            @Nullable String name,
            @Nullable String country,
            @Nullable String phone,
            @Nullable String region,
            Pageable pageable
    );

}
