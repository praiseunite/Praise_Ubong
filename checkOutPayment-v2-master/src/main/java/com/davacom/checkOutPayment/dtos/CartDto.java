package com.davacom.checkOutPayment.dtos;

import com.davacom.checkOutPayment.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class CartDto {
    private Map<Product, Integer> cartItems = new HashMap<>();

}
