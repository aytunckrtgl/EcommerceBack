package com.example.demo.business.service;

import com.example.demo.business.dto.UserDto;
import com.example.demo.model.entity.LocalUser;

public interface UserService {

    void add(UserDto userDto);

    void change(UserDto userDto, long userId);

    void delete(long userId);

    LocalUser findUserByUsername(String username);
}
