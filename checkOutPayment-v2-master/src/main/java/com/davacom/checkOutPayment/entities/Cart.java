package com.davacom.checkOutPayment.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Map<Product, Integer> cartItems = new HashMap<>();
}
