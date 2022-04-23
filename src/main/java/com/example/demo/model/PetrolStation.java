package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;


@Entity
@Table(name = "task")
@Getter
@Setter
@ToString
public class PetrolStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petrolstation_id")
    private Long petrolstationId;

    @Column(name="title")
    private String address;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="phone")
    private String phone;

    @Column(name="region")
    private String region;
}
