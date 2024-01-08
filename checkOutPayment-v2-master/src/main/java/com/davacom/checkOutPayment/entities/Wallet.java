package com.davacom.checkOutPayment.entities;

import com.davacom.checkOutPayment.enums.BaseClass;
import com.davacom.checkOutPayment.enums.CURRENCY;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Wallet extends BaseClass {
    private CURRENCY currency;
    private Double amount;
    @OneToOne
    private UserOfApp appOwner;
}
