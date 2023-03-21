package com.sda.onlineshopjava.controller;

import com.sda.onlineshopjava.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {
    @GetMapping("/addProduct")
    public String addProductGet(Model model){
        ProductDto productDto = new ProductDto();
        productDto.setName("telefon");
        model.addAttribute("productDto",productDto);

        return "addProduct";
    }
    @PostMapping("/addProduct")
    public String addProductPost(){
        log.info("apelat add product");
        return "redirect:/addProduct";
    }

}
