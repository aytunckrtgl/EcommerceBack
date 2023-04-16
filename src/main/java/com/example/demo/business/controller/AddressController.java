package com.example.demo.business.controller;

import com.example.demo.business.dto.AddressDto;
import com.example.demo.business.service.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/{userid}/show")
    public List<AddressDto> showAddresses(@PathVariable("userid") long userid) {

     return addresService.showAddresses(userid);

    }

}
