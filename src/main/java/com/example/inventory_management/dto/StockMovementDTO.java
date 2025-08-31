package com.example.inventory_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockMovementDTO {
    private Long itemId;
    private int amount;
    private String note;

}
