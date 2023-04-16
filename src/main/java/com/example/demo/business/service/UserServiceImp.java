package com.example.demo.business.service;

import com.example.demo.business.dto.UserDto;
import com.example.demo.model.entity.LocalUser;
import com.example.demo.model.repository.LocalUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final LocalUserRepository localUserRepository;

    @Transactional
    public void add(UserDto userDto) {
        localUserRepository.save(toEntity(userDto));
    }

    @Transactional
    public void change(UserDto userDto, long userId) {
        LocalUser user = localUserRepository.findById(userId)
                .orElseThrow();

        user.setPassword(userDto.getPassword());
        localUserRepository.save(user);
    }

    @Transactional
    public void delete(long userId) {
        LocalUser user = localUserRepository.findById(userId)
                .orElseThrow();
        localUserRepository.delete(user);
    }

    private LocalUser toEntity(UserDto userDto) {
        LocalUser user = new LocalUser();
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        return user;
    }

    private UserDto toDto(LocalUser user) {
        UserDto userDto = new UserDto();
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    @Override
    public LocalUser findUserByUsername(String username) {
        return localUserRepository.findUserByUsername(username)
                .orElseThrow();
    }

}
