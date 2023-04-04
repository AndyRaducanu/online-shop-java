package com.sda.onlineshopjava.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartEntryDto {
    private String img;
    private String name;
    private String price;
    private String quantity;
    private String total;
}
