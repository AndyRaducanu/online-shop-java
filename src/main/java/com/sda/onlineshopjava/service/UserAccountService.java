package com.sda.onlineshopjava.service;

import com.sda.onlineshopjava.dto.UserAccountDto;
import com.sda.onlineshopjava.entityes.UserAccount;
import com.sda.onlineshopjava.mapper.UserAccountMapper;
import com.sda.onlineshopjava.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserAccountRepository userAccountRepository;
    public void userRegister(UserAccountDto userAccountDto){
        UserAccount userAccount = userAccountMapper.map(userAccountDto);
        userAccountRepository.save(userAccount);
    }
}
