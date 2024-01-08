package com.davacom.checkOutPayment.entities;

import com.davacom.checkOutPayment.enums.BaseClass;
import com.davacom.checkOutPayment.enums.CATEGORY;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseClass {
    private CATEGORY category;
    private Double price;
    private String description;
}
