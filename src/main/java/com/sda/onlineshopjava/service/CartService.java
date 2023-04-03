package com.sda.onlineshopjava.service;

import com.sda.onlineshopjava.dto.ProductQuantityDto;
import com.sda.onlineshopjava.entityes.Cart;
import com.sda.onlineshopjava.entityes.CartEntry;
import com.sda.onlineshopjava.entityes.Product;
import com.sda.onlineshopjava.repository.CartEntryRepository;
import com.sda.onlineshopjava.repository.CartRepository;
import com.sda.onlineshopjava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartEntryRepository cartEntryRepository;
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
}
