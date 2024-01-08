package com.davacom.checkOutPayment.service;


import com.davacom.checkOutPayment.dtos.CartDto;
import com.davacom.checkOutPayment.dtos.UserOfAppDto;
import com.davacom.checkOutPayment.entities.Product;
import com.davacom.checkOutPayment.entities.UserOfApp;

import java.util.List;

public interface UserOfAppService {
    String registerNewUser(UserOfAppDto user);
    CartDto addProductToCart(Product product);
    List<UserOfApp> getAllUsersOfApp();
}
