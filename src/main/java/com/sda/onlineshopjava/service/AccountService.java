package com.sda.onlineshopjava.service;

import com.sda.onlineshopjava.dto.AccountDto;
import com.sda.onlineshopjava.entityes.Account;
import com.sda.onlineshopjava.mapper.AccountMapper;
import com.sda.onlineshopjava.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    public void create(AccountDto accountDto){
        Account account = accountMapper.map(accountDto);
        accountRepository.save(account);
    }
}
