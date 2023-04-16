package com.example.demo.business.controller;

import com.example.demo.business.service.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AdressService addresService;

    @PostMapping("/{userid}/add")
    public void addAdress(@PathVariable("userid") long userId, @RequestBody String address) {
        addresService.setAddress(userId, address);
    }

    @DeleteMapping("/{addressid}/remove")
    public void deleteAddress(@PathVariable("addressid") long addressId) {
        addresService.removeAddress(addressId);
    }
}
