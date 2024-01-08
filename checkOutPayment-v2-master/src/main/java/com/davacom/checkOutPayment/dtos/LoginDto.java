package com.davacom.checkOutPayment.dtos;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {
    @Email
    @NotBlank
    private String emailOrUsername;
    @NotBlank
    private String password;
}
