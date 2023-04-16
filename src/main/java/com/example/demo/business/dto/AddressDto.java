package com.example.demo.business.dto;

import com.example.demo.model.entity.LocalUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private String AddressLine;
    private LocalUser user;
}
