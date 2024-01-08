package com.davacom.thymeleafappjdbc.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String fullName;
    private String email;
    private String password;
}
