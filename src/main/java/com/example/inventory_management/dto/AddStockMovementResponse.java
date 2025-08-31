package com.example.inventory_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "addStockMovementResponse")
public class AddStockMovementResponse {
    private String message;

}