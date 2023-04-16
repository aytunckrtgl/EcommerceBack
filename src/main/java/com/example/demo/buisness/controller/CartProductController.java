package com.example.demo.buisness.controller;

import com.example.demo.buisness.dto.CartProductDto;
import com.example.demo.buisness.service.CartProductService;
import com.example.demo.buisness.service.CartService;
import com.example.demo.model.entity.CartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartl")
@CrossOrigin(origins = "http://localhost:3000")
public class CartProductController {
    @Autowired
    private CartProductService cartProductService;

    @GetMapping("/{cartId}")
    public List<CartProductDto> listCart(@PathVariable("cartId") long cartId){
       return cartProductService.listCart(cartId);
    }
}
