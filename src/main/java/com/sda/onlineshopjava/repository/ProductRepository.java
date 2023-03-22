package com.sda.onlineshopjava.repository;

import com.sda.onlineshopjava.entityes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product,Long> {

}
