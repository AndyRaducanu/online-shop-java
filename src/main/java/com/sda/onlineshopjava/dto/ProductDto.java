package com.sda.onlineshopjava.dto;

import com.sda.onlineshopjava.entityes.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String id;
    private  String name;
    private String description;
    private  String price;
    private  String category;
    private  String unitsInStock;
}
