package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CartProduct")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_id" )
    private Cart cart;


    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "salesQuantity" )
    private int salesQuantity;


    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}
