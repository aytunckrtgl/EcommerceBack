package com.example.demo.buisness.service;

public interface CartService {
    void addToCart(long productId ,  long cartId);
    void removeFromCart(long productId,  long cartId);
    String checkOut();
}
