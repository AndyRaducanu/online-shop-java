package com.sda.onlineshopjava.service;

import com.sda.onlineshopjava.dto.CartEntryDto;
import com.sda.onlineshopjava.dto.CheckoutDto;
import com.sda.onlineshopjava.dto.ProductQuantityDto;
import com.sda.onlineshopjava.entityes.Cart;
import com.sda.onlineshopjava.entityes.CartEntry;
import com.sda.onlineshopjava.entityes.Product;
import com.sda.onlineshopjava.mapper.CartEntryMapper;
import com.sda.onlineshopjava.repository.CartEntryRepository;
import com.sda.onlineshopjava.repository.CartRepository;
import com.sda.onlineshopjava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartEntryRepository cartEntryRepository;
    @Autowired
    private CartEntryMapper cartEntryMapper;
    public void addToCart(String productId, ProductQuantityDto productQuantityDto, String loggedInUserEmail ){
        CartEntry cartEntry = new CartEntry();

        Cart cart = cartRepository.findByUserAccountEmail(loggedInUserEmail);
        cartEntry.setCart(cart);

        Optional<Product> optionalProduct = productRepository.findById(Long.valueOf(productId));
        if (optionalProduct.isEmpty()){
            throw new RuntimeException("Product id is not valid");
        }
        Product product = optionalProduct.get();
        cartEntry.setProduct(product);

        cartEntry.setQuantity(Integer.valueOf(productQuantityDto.getQuantity()));

        cartEntryRepository.save(cartEntry);

    }

    public CheckoutDto getCheckoutDtoByUserEmail(String userEmail) {
        Cart cart = cartRepository.findByUserAccountEmail(userEmail);
        List<CartEntryDto> cartEntryDtoList = new ArrayList<>();
        Integer subtotal = 0;
        for (CartEntry cartEntry: cart.getCartEntryList()){
            CartEntryDto cartEntryDto = cartEntryMapper.map(cartEntry);
            cartEntryDtoList.add(cartEntryDto);
            subtotal = subtotal + cartEntry.getProduct().getPrice() * cartEntry.getQuantity();
        }
        return CheckoutDto.builder()
                .cartEntryDtoList(cartEntryDtoList)
                .subtotal(String.valueOf(subtotal))
                .shippingFee("10")
                .Total(String.valueOf(subtotal + 10))
                .build();
    }
}
