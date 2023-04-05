package com.sda.onlineshopjava.repository;

import com.sda.onlineshopjava.entityes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
