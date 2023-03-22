package com.sda.onlineshopjava.service;

import com.sda.onlineshopjava.dto.ProductDto;
import com.sda.onlineshopjava.entityes.Product;
import com.sda.onlineshopjava.mapper.ProductMapper;
import com.sda.onlineshopjava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public void create(ProductDto productDto) {
        Product product = productMapper.map(productDto);
        productRepository.save(product);
    }
}
