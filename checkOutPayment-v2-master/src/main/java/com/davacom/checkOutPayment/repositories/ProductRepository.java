package com.davacom.checkOutPayment.repositories;

import com.davacom.checkOutPayment.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
