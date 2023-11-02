package com.santander.vermont.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String fullName;
    private String phone;
    private String address;
    @Override
    public String toString() {
        return this.getFullName() + "; " + this.getPhone() + "; " + this.getAddress();
    }
}
