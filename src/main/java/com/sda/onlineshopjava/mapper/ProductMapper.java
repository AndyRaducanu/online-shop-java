package com.sda.onlineshopjava.mapper;

import com.sda.onlineshopjava.dto.ProductDto;
import com.sda.onlineshopjava.entityes.Product;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@Component
public class ProductMapper {
    public Product map(ProductDto productDto, MultipartFile multipartFile){

        return Product.builder()
                .price(Integer.valueOf(productDto.getPrice()))
                .description(productDto.getDescription())
                .name(productDto.getName())
                .category(productDto.getCategory())
                .unitsInStock(Integer.valueOf(productDto.getUnitsInStock()))
                .img(convertToByteArray(multipartFile))
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
                .img(Base64.encodeBase64String(product.getImg()))
                .build();

    }
    private byte[] convertToByteArray(MultipartFile multipartFile){
        try {
            return multipartFile.getBytes();
        } catch (IOException e) {
            return new byte[0];
        }
    }

}
