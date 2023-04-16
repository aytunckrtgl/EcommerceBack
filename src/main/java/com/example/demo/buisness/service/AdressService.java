package com.example.demo.buisness.service;

public interface AdressService {
    void setAddress(long userId, String addressLine);
    void removeAddress(long addressId);
}
