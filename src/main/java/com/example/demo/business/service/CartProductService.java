package com.example.demo.business.service;

import com.example.demo.business.dto.CartProductDto;
import com.example.demo.model.entity.CartProduct;

import java.util.List;

public interface CartProductService {
    void addProductCart(long productId, long cartId);
    void updateProductCart(long productId, long cartId, CartProduct cartProduct);
    void deleteProductCart(long productId, long cartId, CartProduct cartProduct);
    void deleteOneProductCart(long productId, long cartId, CartProduct cartProduct);
    List<CartProduct> listCart(long cartId);

    void deleteCart(long cartId);
}