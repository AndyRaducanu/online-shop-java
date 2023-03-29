package com.sda.onlineshopjava.dto;

import com.sda.onlineshopjava.enums.UserRole;
import lombok.Data;

@Data
public class UserAccountDto {
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String userRole;
}
