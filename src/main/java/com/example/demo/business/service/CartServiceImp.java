package com.example.demo.business.service;

import com.example.demo.model.entity.CartProduct;
import com.example.demo.model.repository.CartProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService {

    private final CartProductRepository cartProductRepository;
    private final CartProductService cartProductService;

    @Transactional
    public void addToCart(long productId, long cartId) {
        CartProduct cartProduct = cartProductRepository.findByProductIdAndCartId(productId, cartId);

        if (cartProduct == null) {
            cartProductService.addProductCart(productId, cartId);
        } else {
            cartProductService.updateProductCart(productId, cartId, cartProduct);
        }
    }

    @Transactional
    public void removeFromCart(long productId, long cartId) {
        CartProduct cartProduct = cartProductRepository.findByProductIdAndCartId(productId, cartId);

        if (cartProduct.getSalesQuantity() == 1) {
            cartProductService.deleteProductCart(productId, cartId, cartProduct);
        } else {
            cartProductService.deleteOneProductCart(productId, cartId, cartProduct);
        }
    }

    @Override
    public String checkOut() {
        return "Satın Alım Başarılı";
    }
}
