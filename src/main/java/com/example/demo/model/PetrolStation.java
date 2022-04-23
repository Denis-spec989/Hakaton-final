package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "petrolstation")
@Getter
@Setter
@ToString
public class PetrolStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID petrolstationId;

    @Column(name="title")
    private String address;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @Column(name="name_")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="phone")
    private String phone;

    @Column(name="region")
    private String region;
}
