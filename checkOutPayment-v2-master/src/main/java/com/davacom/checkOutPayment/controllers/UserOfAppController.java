package com.davacom.checkOutPayment.controllers;

import com.davacom.checkOutPayment.dtos.UserOfAppDto;
import com.davacom.checkOutPayment.entities.UserOfApp;
import com.davacom.checkOutPayment.repositories.UserOfAppRepository;
import com.davacom.checkOutPayment.service.UserOfAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-of-app")
@RequiredArgsConstructor
public class UserOfAppController {
    private final UserOfAppService userOfAppService;


    @GetMapping("/app-users")
    private List<UserOfApp> allUser() {
        return userOfAppService.getAllUsersOfApp();
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestBody UserOfAppDto userOfAppDto){
        return userOfAppService.registerNewUser(userOfAppDto);
    }


}
