package com.davacom.checkOutPayment.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticateRequest {
    private String email;
    private String password;
}
