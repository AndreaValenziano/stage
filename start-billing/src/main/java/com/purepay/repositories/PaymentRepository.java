package com.purepay.repositories;

import com.purepay.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AndreaValenziano on 23/05/18.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

   public List<Payment> findAllByMsisdn(byte[] msisdn);

}
