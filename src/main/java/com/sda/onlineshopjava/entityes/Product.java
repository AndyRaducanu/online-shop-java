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
//@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private  String name;
    private String description;
    @Nonnull
    private  Integer price;
    @Nonnull
    private  String category;
    @Nonnull
    private  Integer unitsInStock;
}
