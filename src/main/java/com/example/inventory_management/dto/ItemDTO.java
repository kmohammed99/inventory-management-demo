package com.example.inventory_management.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private String name;
    private String sku;
    private Long supplierId;
    private int quantity;
    private int minQuantity;
}
