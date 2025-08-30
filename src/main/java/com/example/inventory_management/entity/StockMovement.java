package com.example.inventory_management.entity;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Item item;

    private int amount;

    private String note;

}