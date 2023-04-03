package com.sda.onlineshopjava.mapper;

import com.sda.onlineshopjava.dto.UserAccountDto;
import com.sda.onlineshopjava.entityes.Cart;
import com.sda.onlineshopjava.entityes.UserAccount;
import com.sda.onlineshopjava.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserAccountMapper {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserAccount map(UserAccountDto userAccountDto){
        return UserAccount.builder()
                .email(userAccountDto.getEmail())
                .address(userAccountDto.getAddress())
                .fullName(userAccountDto.getFullName())
                .password(bCryptPasswordEncoder.encode(userAccountDto.getPassword()))
                .userRole(UserRole.valueOf(userAccountDto.getUserRole()))
                .cart(new Cart())
                .build();
    }
}
