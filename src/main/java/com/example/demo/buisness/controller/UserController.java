package com.example.demo.buisness.controller;

import com.example.demo.buisness.dto.AuthCredentialRequestDto;
import com.example.demo.buisness.dto.UserDto;
import com.example.demo.buisness.service.UserService;
import com.example.demo.model.entity.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userservice;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/test1")
    public String Test( ){

        return "Test";
    }



    @PostMapping("/add")
    public long addUser(@RequestBody UserDto userDto){
        //TODO PASSWORDUDA KONTROL ET
        //TODO KULLANICI ADI ALINMIŞSA UYARI VERSİN
        if (userDto.getUsername() == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        userservice.add(userDto);
        return 123;
    }

    @PutMapping("/change/{userid}")
    public long updateUser(@RequestBody UserDto userDto , @PathVariable("userid") long userId){
        userservice.change(userDto, userId);
        return 123;
    }


    @DeleteMapping("/delete")
    public long deleteUser(@RequestBody long userId){
        userservice.delete(userId);
        return userId;
    }

    @PostMapping("login")
    public long login(@RequestBody AuthCredentialRequestDto request){
        try{
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()
                    )
            );

            LocalUser localuser = userservice.findUserByUsername(request.getUsername());
            return localuser.getId();
        }
        catch(BadCredentialsException ex){
            return -1;
        }
    }



}
