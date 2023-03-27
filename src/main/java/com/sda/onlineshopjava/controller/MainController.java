package com.sda.onlineshopjava.controller;

import com.sda.onlineshopjava.dto.AccountDto;
import com.sda.onlineshopjava.dto.ProductDto;
import com.sda.onlineshopjava.entityes.Account;
import com.sda.onlineshopjava.repository.AccountRepository;
import com.sda.onlineshopjava.service.AccountService;
import com.sda.onlineshopjava.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MainController {
    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/addProduct")
    public String addProductGet(Model model) {
        ProductDto productDto = new ProductDto();

        model.addAttribute("productDto", productDto);

        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProductPost(@ModelAttribute ProductDto productDto) {
        System.out.println(productDto);
        log.info("apelat add product");
        productService.create(productDto);
        return "redirect:/addProduct";
    }

    @GetMapping("/home")
    public String homeGet(Model model) {

        List<ProductDto> productDtoList = productService.getAllProductDtoList();
        model.addAttribute("productDtoList", productDtoList);
        System.out.println(productDtoList);
        return "home";
    }
    @GetMapping("/product/{id}")
    public String viewProductGet(Model model,@PathVariable(value = "id") String id){
        System.out.println("click pe produsul cu id-ul" + id);
        return "viewProduct";
    }
//    ----------------------------------------

    @GetMapping("/register")
    public String registerGet(Model model){
        AccountDto accountDto = new AccountDto();
        model.addAttribute("accountDto",accountDto);
        return "register";
    }

    @PostMapping("/register")
    public String addRegisterPost(@ModelAttribute AccountDto accountDto){
        log.info("apelat register");
        accountService.create(accountDto);
        return "redirect:/home";

    }

}
