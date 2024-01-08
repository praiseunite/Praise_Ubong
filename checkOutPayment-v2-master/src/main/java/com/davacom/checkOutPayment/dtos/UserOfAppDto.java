package com.davacom.checkOutPayment.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserOfAppDto {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
}
