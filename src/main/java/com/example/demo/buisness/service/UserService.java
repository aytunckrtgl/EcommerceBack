package com.example.demo.buisness.service;

import com.example.demo.buisness.dto.UserDto;
import com.example.demo.model.entity.LocalUser;

import java.util.List;

public interface UserService {

    void add(UserDto userDto);
    void change(UserDto userDto, long userId);
    void delete(long userId);
    UserDto find(long userId);
    List<UserDto> list();

    LocalUser findUserByUsername(String username);
}
