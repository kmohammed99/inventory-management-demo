package com.example.inventory_management.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "createSupplierResponse", namespace = "http://example.com/inventory")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateSupplierResponse {
    private Long supplierId;

}