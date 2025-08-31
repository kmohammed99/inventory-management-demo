package com.example.inventory_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "createItemResponse", namespace = "http://example.com/inventory")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateItemResponse {
    private Long id;
    private String name;
    private String sku;
    private int quantity;
    private int minQuantity;

}
