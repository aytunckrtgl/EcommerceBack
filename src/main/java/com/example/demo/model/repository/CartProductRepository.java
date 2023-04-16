package com.example.demo.model.repository;

import com.example.demo.model.entity.CartProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    @Query("select s from CartProduct s where s.cart.cartId = :cartId and s.product.id = :productId")
    CartProduct findByProductIdAndCartId(@Param("productId") long productId, @Param("cartId") long cartId);

    @Query("select s from CartProduct s where s.cart.cartId = :cartId")
    List<CartProduct> findByCartId(@Param("cartId") long cartId);
}
