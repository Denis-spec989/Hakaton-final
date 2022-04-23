package com.example.demo.entities;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "petrolstations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PetrolStationEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "address")
    private String address;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @Column(name = "region")
    private String region;

    public PetrolStationEntity(
            String address,
            double latitude,
            double longitude,
            String name,
            String country,
            String phone,
            String region
    ) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.region = region;
    }
}
