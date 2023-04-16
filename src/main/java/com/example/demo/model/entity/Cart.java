package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId", nullable = true)

    private long cartId;
    @Column(name = "cardNumber", nullable = true)
    private String cardNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private LocalUser user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CartProduct> cartProductList = new ArrayList<CartProduct>();

    //TODO CARDSTATUS ENUM
}
