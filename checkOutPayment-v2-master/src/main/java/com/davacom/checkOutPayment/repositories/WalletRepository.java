package com.davacom.checkOutPayment.repositories;

import com.davacom.checkOutPayment.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
