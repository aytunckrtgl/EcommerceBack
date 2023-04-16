package com.example.demo.business.service;

import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.CartProduct;
import com.example.demo.model.entity.Product;
import com.example.demo.model.repository.CartProductRepository;
import com.example.demo.model.repository.CartRepository;
import com.example.demo.model.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartProductServiceImp implements CartProductService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    @Transactional
    public void addProductCart(long productId, long cartId) {

        Product product = productRepository.findById(productId)
                .orElseThrow();

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow();

        CartProduct cartProduct = new CartProduct();
        cartProduct.setProduct(product);
        cartProduct.setSalesQuantity(1);
        cartProduct.setCart(cart);
        cartProductRepository.save(cartProduct);
    }

    @Transactional
    public void updateProductCart(long productId, long cartId, CartProduct cartProduct) {

        Product product = productRepository.findById(productId)
                .orElseThrow();

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow();

        cartProduct.setProduct(product);
        cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() + 1);
        cartProduct.setCart(cart);
        cartProductRepository.save(cartProduct);
    }

    @Transactional
    public void deleteOneProductCart(long productId, long cartId, CartProduct cartProduct) {

        Product product = productRepository.findById(productId)
                .orElseThrow();

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow();

        cartProduct.setCart(cart);
        cartProduct.setProduct(product);
        cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() - 1);
        cartProductRepository.save(cartProduct);
    }

    @Transactional
    public void deleteProductCart(long productId, long cartId, CartProduct cartProduct) {
        cartProductRepository.delete(cartProduct);
    }

    @Transactional
    public List<CartProduct> listCart(long cartId) {
        return cartProductRepository.findByCartId(cartId);
    }
    @Transactional
    public void deleteCart(long cartId){
        List<CartProduct> list1 = listCart(cartId);
        for(CartProduct cartProduct : list1){
            cartProductRepository.delete(cartProduct);

        }


    }
}
