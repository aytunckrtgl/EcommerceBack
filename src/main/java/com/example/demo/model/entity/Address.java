package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId", nullable = true)
    private long id;

    @Column(name = "AddressLine", nullable = true)
    private String AddressLine;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = true)
    private LocalUser user;

}
