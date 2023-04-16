package com.example.demo.buisness.dto;

import com.example.demo.model.entity.LocalUser;

public class AddressDto {

    private String AddressLine;
    private LocalUser user;

    public String getAddressLine() {
        return AddressLine;
    }

    public void setAddressLine(String addressLine) {
        AddressLine = addressLine;
    }

    public LocalUser getUser() {
        return user;
    }

    public void setUser(LocalUser user) {
        this.user = user;
    }
}
