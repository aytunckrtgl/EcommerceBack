package com.example.demo.buisness.controller;

import com.example.demo.buisness.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AdressService addresService;

    @PostMapping("/{userid}/add")
    public void addAdress(@PathVariable("userid") long userId,@RequestBody String address){
        addresService.setAddress(userId , address);
    }

    @DeleteMapping("/{addressid}/remove")
    public void deleteAddress(@PathVariable("addressid") long addressId){
        addresService.removeAddress(addressId);
    }



}
