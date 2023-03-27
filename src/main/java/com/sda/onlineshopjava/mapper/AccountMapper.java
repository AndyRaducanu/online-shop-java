package com.sda.onlineshopjava.mapper;

import com.sda.onlineshopjava.dto.AccountDto;
import com.sda.onlineshopjava.entityes.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account map(AccountDto accountDto) {
        return Account.builder()
                .userName(accountDto.getUserName())
                .email(accountDto.getEmail())
                .password(accountDto.getPassword())
                .rePassword(accountDto.getRePassword())
                .build();
    }

    public AccountDto map(Account account){
        return AccountDto.builder()
                .id(String.valueOf(account.getId()))
                .userName(account.getUserName())
                .email(account.getEmail())
                .password(account.getPassword())
                .rePassword(account.getRePassword())
                .build();

    }
}
