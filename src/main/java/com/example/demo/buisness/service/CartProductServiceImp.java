package com.example.demo.buisness.service;

import com.example.demo.buisness.dto.CartProductDto;
import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.CartProduct;
import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Product;
import com.example.demo.model.repository.CartProductRepository;
import com.example.demo.model.repository.CartRepository;
import com.example.demo.model.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartProductServiceImp implements CartProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartProductRepository cartProductRepository;

    @Transactional
    public void addProductCart(long productId ,  long cartId){

        Optional<Product> optionalproduct = productRepository.findById(productId);
        Product product = optionalproduct.get();
        Optional<Cart> optionalcart = cartRepository.findById(cartId);
        Cart cart = optionalcart.get();

        CartProduct cartProduct = new CartProduct();
        cartProduct.setProduct(product);
        cartProduct.setSalesQuantity(1);
        cartProduct.setCart(cart);
        cartProductRepository.save(cartProduct);

        //cart.getCartProductList().add(cartProduct);
        //cartRepository.save(cart);

    }
    @Transactional
    public void updateProductCart(long productId ,  long cartId, CartProduct cartProduct){
        Optional<Product> optionalproduct = productRepository.findById(productId);
        Product product = optionalproduct.get();
        Optional<Cart> optionalcart = cartRepository.findById(cartId);
        Cart cart = optionalcart.get();

        cartProduct.setProduct(product);
        cartProduct.setSalesQuantity(cartProduct.getSalesQuantity()+1);
        cartProduct.setCart(cart);
        cartProductRepository.save(cartProduct);

        //cart.getCartProductList().add(cartProduct);
        //cartRepository.save(cart);

    }
    @Transactional
    public void deleteOneProductCart(long productId ,  long cartId, CartProduct cartProduct){


        Optional<Product> optionalproduct = productRepository.findById(productId);
        Product product = optionalproduct.get();
        Optional<Cart> optionalcart = cartRepository.findById(cartId);
        Cart cart = optionalcart.get();


        cartProduct.setCart(cart);
        cartProduct.setProduct(product);
        cartProduct.setSalesQuantity(cartProduct.getSalesQuantity()-1);
        cartProductRepository.save(cartProduct);

      //  cart.getCartProductList().add(cartProduct);
       // cartRepository.save(cart);

    }
    @Transactional
    public void deleteProductCart(long productId ,  long cartId, CartProduct cartProduct){
        cartProductRepository.delete(cartProduct);

    }

    @Transactional
    public List<CartProductDto> listCart(long cartId){
        List<CartProductDto> cartProductDtolist = new ArrayList<>();
        Iterable<CartProduct> iterableCartProduct = cartProductRepository.findByCartId(cartId);

        for(CartProduct cartProduct : iterableCartProduct){

            CartProductDto cartProductDto = new CartProductDto();
            cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
            cartProductDto.setProduct(cartProduct.getProduct());

            cartProductDtolist.add(cartProductDto);

        }

      

        return cartProductDtolist;
    }

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
