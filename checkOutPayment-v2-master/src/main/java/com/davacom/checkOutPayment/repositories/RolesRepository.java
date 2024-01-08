package com.davacom.checkOutPayment.repositories;

import com.davacom.checkOutPayment.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long > {
    Roles findByName(String name);
}
