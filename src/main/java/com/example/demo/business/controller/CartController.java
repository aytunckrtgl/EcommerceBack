package com.example.demo.business.controller;

import com.example.demo.business.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartService cartservice;

    @GetMapping("/add/{cartid}/{productid}")
    public void addToCart(@PathVariable("productid") long productId, @PathVariable("cartid") long cartId) {
        cartservice.addToCart(productId, cartId);
    }

    @DeleteMapping("/remove/{cartid}/{productid}")
    public void removeFromCart(@PathVariable("productid") long productId, @PathVariable("cartid") long cartId) {
        cartservice.removeFromCart(productId, cartId);
    }
}
