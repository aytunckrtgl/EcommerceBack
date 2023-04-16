package com.example.demo.business.service;

public interface AdressService {
    void setAddress(long userId, String addressLine);

    void removeAddress(long addressId);
}
