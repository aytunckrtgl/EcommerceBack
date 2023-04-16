package com.example.demo.buisness.service;

import com.example.demo.model.entity.CartProduct;
import com.example.demo.model.repository.CartProductRepository;
import com.example.demo.model.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartProductRepository cartProductRepository;
    @Autowired
    private CartProductService cartProductService;
    @Autowired
    private CartRepository cartRepository;

    public CartServiceImp() {
    }

    @Transactional
    public void addToCart(long productId , long cartId){
        CartProduct cartProduct = cartProductRepository.findByProductIdAndCartId(productId, cartId);
        if(cartProduct == null){
            cartProductService.addProductCart(productId, cartId);

        }
        else{
            cartProductService.updateProductCart(productId, cartId, cartProduct);
        }

    }

    @Transactional
    public void removeFromCart(long productId,  long cartId){
        CartProduct cartProduct = cartProductRepository.findByProductIdAndCartId(productId, cartId);
        if(cartProduct.getSalesQuantity() == 1){
            cartProductService.deleteProductCart(productId, cartId, cartProduct);
        }
        else{
            cartProductService.deleteOneProductCart(productId, cartId, cartProduct);
        }
    }


    public String checkOut(){
        //TODO BURAYİ UNUTMA
        //TODO CARTI SIFIRLA, İLERİDE ORDERLERİ DE KAYDEDİP GÖSTEREBİLİRSİN.

    return "Satın Alım Başarılı";
    }
}
