package com.sda.onlineshopjava.repository;

import com.sda.onlineshopjava.entityes.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartEntryRepository extends JpaRepository<CartEntry, Long> {
}
