package com.davacom.checkOutPayment.repositories;

import com.davacom.checkOutPayment.entities.UserOfApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOfAppRepository extends JpaRepository<UserOfApp, Long> {
    UserOfApp findByEmail(String email);
}
