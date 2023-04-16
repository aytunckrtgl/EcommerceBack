package com.example.demo.buisness.controller;

import com.example.demo.buisness.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired
    private CartService cartservice;

    @GetMapping("/add/{cartid}/{productid}")
    public void addToCart(@PathVariable("productid") long productId, @PathVariable("cartid") long cartId){
        cartservice.addToCart(productId ,  cartId);
    }

    @DeleteMapping("/remove/{cartid}/{productid}")
    public void removeFromCart(@PathVariable("productid") long productId, @PathVariable("cartid") long cartId){
        cartservice.removeFromCart(productId ,   cartId);
    }

    //TODO CHECKOUT


}
