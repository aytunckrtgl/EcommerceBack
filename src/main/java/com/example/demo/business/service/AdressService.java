package com.example.demo.business.service;

import com.example.demo.business.dto.AddressDto;

import java.util.List;

public interface AdressService {
    void setAddress(long userId, String addressLine);

    void removeAddress(long addressId);

    List<AddressDto> showAddresses(long userId);
}
