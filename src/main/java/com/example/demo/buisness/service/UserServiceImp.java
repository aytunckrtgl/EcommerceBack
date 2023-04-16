package com.example.demo.buisness.service;

import com.example.demo.buisness.dto.UserDto;
import com.example.demo.model.entity.LocalUser;
import com.example.demo.model.repository.LocalUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    LocalUserRepository localUserRepository;

    @Transactional
    public void add(UserDto userDto){

        localUserRepository.save(toEntity(userDto));
    }

    @Transactional
    public void change(UserDto userDto, long userId){
        //TODO MAİL FALANDA DEGİSEBİLİR ONLARI DA YAP
        LocalUser user = toEntity(userDto);
        Optional<LocalUser> optionalUser =  localUserRepository.findById(userId);
        LocalUser user1 = optionalUser.get();
        user1.setPassword(user.getPassword());
        localUserRepository.save(user1);

    }
    @Transactional
    public void delete(long userId){
        Optional<LocalUser> optional  = localUserRepository.findById(userId);
        //TODO BURAYA EGER BULAMAZSA OPSİYONUNU EKLE TRY CATCH!
        LocalUser localuser = optional.get();
        localUserRepository.delete(localuser);


    }
    @Transactional

    public UserDto find(long userId) {
        //TODO BURAYA EGER BULAMAZSA OPSİYONUNU EKLE TRY CATCH!
        Optional<LocalUser> optional = localUserRepository.findById(userId);
        UserDto userDto = toDto(optional.get());
        return userDto;

    }
    @Transactional
    public List<UserDto> list(){
        List<UserDto> list = new ArrayList<UserDto>();
        for(LocalUser user : localUserRepository.findAll()){
            UserDto userDto = toDto(user);
            list.add(userDto);
        }
        return list;
    }

    public LocalUser toEntity(UserDto userDto){
        LocalUser user =new LocalUser();
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        return user;
    }

    public UserDto toDto(LocalUser user){
        UserDto userDto =new UserDto();
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());
        return userDto;

    }

    @Override
    public LocalUser findUserByUsername(String username){
        return localUserRepository.findUserByUsername(username).get();
    }



}
