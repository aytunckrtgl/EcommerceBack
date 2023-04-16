package com.example.demo.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId" , nullable = true)
    private long cartId;
    @Column(name = "cardNumber" , nullable = true)
    private String cardNumber;
    @OneToOne
    @JoinColumn(name = "user_id" , nullable = true)
    private LocalUser user;

    @OneToMany(mappedBy = "cart" , cascade = CascadeType.REMOVE , orphanRemoval = true)
    private List<CartProduct> cartProductList = new ArrayList<CartProduct>();

    //TODO CARDSTATUS ENUM


    public List<CartProduct> getCartProductList() {
        return cartProductList;
    }

    public void setCartProductList(List<CartProduct> cartProductList) {
        this.cartProductList = cartProductList;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalUser getUser() {
        return user;
    }

    public void setUser(LocalUser user) {
        this.user = user;
    }
}
