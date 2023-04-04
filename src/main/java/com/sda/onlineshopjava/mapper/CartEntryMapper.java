package com.sda.onlineshopjava.mapper;

import com.sda.onlineshopjava.dto.CartEntryDto;
import com.sda.onlineshopjava.entityes.CartEntry;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CartEntryMapper {
    public CartEntryDto map(CartEntry cartEntry){
        return CartEntryDto.builder()
                .name(cartEntry.getProduct().getName())
                .price(String.valueOf(cartEntry.getProduct().getPrice()))
                .quantity(String.valueOf(cartEntry.getQuantity()))
                .total(String.valueOf(cartEntry.getProduct().getPrice() * cartEntry.getQuantity()))
                .img(Base64.encodeBase64String(cartEntry.getProduct().getImg()))
                .build();
    }
}
