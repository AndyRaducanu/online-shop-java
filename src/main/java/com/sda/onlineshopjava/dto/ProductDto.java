package com.sda.onlineshopjava.dto;

import lombok.Data;

@Data
public class ProductDto {
    private  String name;
    private String description;
    private  String price;
    private  String category;
    private  String unitsInStock;
}
