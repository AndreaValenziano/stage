package com.purepay.repository;

import com.purepay.entity.BillingConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by AndreaValenziano on 29/05/18.
 */
public interface BillingConfigRepository extends JpaRepository<BillingConfig,Integer> {

    BillingConfig findByClient_AccessToken(String accessToken);
}
