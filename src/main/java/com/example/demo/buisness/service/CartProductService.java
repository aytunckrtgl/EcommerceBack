package com.example.demo.buisness.service;

import com.example.demo.buisness.dto.CartProductDto;
import com.example.demo.model.entity.CartProduct;

import java.util.List;

public interface CartProductService {
    void addProductCart(long productId ,  long cartId);
    void updateProductCart(long productId , long cartId, CartProduct cartProduct);
    public void deleteProductCart(long productId ,  long cartId,  CartProduct cartProduct);
    public void deleteOneProductCart(long productId ,  long cartId, CartProduct cartProduct);
    public List<CartProductDto> listCart(long cartId);

}
/*
          cartProduct = new CartProduct();
            Optional<Product> optionalproduct = productRepository.findById(productId);
            Product product = optionalproduct.get();
            cartProduct.setProduct(product);
            cartProduct.setSalesQuantity(1);
            Optional<Cart> optionalcart = cartRepository.findById(cartId);
            Cart cart = optionalcart.get();
            cart.getCartProductList().add(cartProduct);
 */