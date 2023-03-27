package com.sda.onlineshopjava.entityes;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @Nonnull
    private  String userName;
    @Nonnull
    private  String email;
    @Nonnull
    private String password;
    @Nonnull
    private String rePassword;
}
