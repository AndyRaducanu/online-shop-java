package com.sda.onlineshopjava.repository;

import com.sda.onlineshopjava.entityes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserAccountEmail(String email);
}
