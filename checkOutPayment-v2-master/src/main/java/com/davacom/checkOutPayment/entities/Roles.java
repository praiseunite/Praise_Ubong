package com.davacom.checkOutPayment.entities;


import com.davacom.checkOutPayment.enums.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Roles extends BaseClass {
    @Column(nullable = true, length =50, unique = true )
    private String name;
}
