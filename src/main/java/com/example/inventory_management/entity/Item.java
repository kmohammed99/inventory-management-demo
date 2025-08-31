package com.example.inventory_management.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String sku;
    @ManyToOne
    private Supplier supplier;
    @Column(nullable = false)
    private int quantity = 0;
    @Column(nullable = false)
    private int minQuantity = 0;
}