package com.nv.user.dtos;

import lombok.Data;

@Data
public class CreateUserDto {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
}
