package com.sda.onlineshopjava.repository;

import com.sda.onlineshopjava.entityes.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
