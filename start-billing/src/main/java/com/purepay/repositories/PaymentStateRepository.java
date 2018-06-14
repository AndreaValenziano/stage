package com.purepay.repositories;

import com.purepay.entity.PaymentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AndreaValenziano on 23/05/18.
 */
@Repository
public interface PaymentStateRepository extends JpaRepository<PaymentState,Integer> {

   public PaymentState findByIdPaymentState(int id );

}
