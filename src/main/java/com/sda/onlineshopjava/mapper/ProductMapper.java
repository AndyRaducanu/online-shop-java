package com.sda.onlineshopjava.mapper;

import com.sda.onlineshopjava.dto.ProductDto;
import com.sda.onlineshopjava.entityes.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product map(ProductDto productDto){

        return Product.builder()
                .price(Integer.valueOf(productDto.getPrice()))
                .description(productDto.getDescription())
                .name(productDto.getName())
                .category(productDto.getCategory())
                .unitsInStock(Integer.valueOf(productDto.getUnitsInStock()))
                .build();
    }

    public ProductDto  map(Product product){

        return ProductDto.builder()
                .id(String.valueOf(product.getId()))
                .price(String.valueOf(product.getPrice()))
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .unitsInStock(String.valueOf(product.getUnitsInStock()))
                .build();

    }

}
