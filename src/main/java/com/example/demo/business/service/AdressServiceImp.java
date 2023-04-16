package com.example.demo.business.service;

import com.example.demo.model.entity.Address;
import com.example.demo.model.entity.LocalUser;
import com.example.demo.model.repository.AddressRepository;
import com.example.demo.model.repository.LocalUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdressServiceImp implements AdressService {

    private final LocalUserRepository localUserRepository;
    private final AddressRepository addressRepository;

    @Transactional
    public void setAddress(long userId, String addressLine) {
        LocalUser user = localUserRepository.findById(userId)
                .orElseThrow();
        Address address = new Address();
        address.setUser(user);
        address.setAddressLine(addressLine);
        addressRepository.save(address);
    }

    @Transactional
    public void removeAddress(long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow();
        addressRepository.delete(address);
    }
}
