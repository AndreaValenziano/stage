package com.purepay.repositories;

import com.purepay.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AndreaValenziano on 23/05/18.
 */
@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Integer> {

    public Retailer findByUserName(String username);

    public Retailer findByIdRetailer(int id);

}
