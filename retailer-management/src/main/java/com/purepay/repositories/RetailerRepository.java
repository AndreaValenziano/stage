package com.purepay.repositories;

import com.purepay.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Integer> {
    Optional<Retailer> findByUserNameAndPassword(String username, byte[] password);

    Optional<Retailer> findByCryptingKey(byte[] cryptingKey);

    Optional<Retailer> findByUserName(String userName);

}
