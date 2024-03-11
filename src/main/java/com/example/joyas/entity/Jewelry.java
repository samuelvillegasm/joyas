package com.example.joyas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "jewelries")
@Data
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String material;
    @Column(nullable = false)
    private Double weight;
    @Column(nullable = false)
    private String specification;
    @Column(nullable = false)
    private Boolean hasStone;
    @Column(nullable = false)
    private Boolean isAvailableForSale;
}
