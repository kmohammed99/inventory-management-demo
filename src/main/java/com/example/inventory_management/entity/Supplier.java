package com.example.inventory_management.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String email;
    private String phone;

}