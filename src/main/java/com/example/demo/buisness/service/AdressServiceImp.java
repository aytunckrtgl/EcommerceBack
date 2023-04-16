package com.example.demo.buisness.service;

import com.example.demo.model.entity.Address;
import com.example.demo.model.entity.LocalUser;
import com.example.demo.model.repository.AddressRepository;
import com.example.demo.model.repository.LocalUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdressServiceImp implements AdressService{

    @Autowired
    private LocalUserRepository localUserRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void setAddress(long userId ,String addressLine){
        Optional<LocalUser> optionalUser = localUserRepository.findById(userId);
        LocalUser user = optionalUser.get();
        Address  address = new Address();
        address.setUser(user);
        address.setAddressLine(addressLine);
        addressRepository.save(address);


    }

    @Transactional
    public void removeAddress(long addressId){
        Optional<Address> optionaladdress = addressRepository.findById(addressId);
        Address address = optionaladdress.get();
        addressRepository.delete(address);

    }
}
