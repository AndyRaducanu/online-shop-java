package com.sda.onlineshopjava.service;

import com.sda.onlineshopjava.entityes.UserAccount;
import com.sda.onlineshopjava.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("incerc sa ma loghez cu emailul: " + email);
//        cauta un user
        Optional<UserAccount> optionalUserAccount =userAccountRepository.findByEmail(email);
        if ( optionalUserAccount.isEmpty()){
            throw new UsernameNotFoundException(email);
        }
        UserAccount userAccount =optionalUserAccount.get();
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(userAccount.getUserRole().name()));



        return new User(email, userAccount.getPassword(), roles);
    }
}
