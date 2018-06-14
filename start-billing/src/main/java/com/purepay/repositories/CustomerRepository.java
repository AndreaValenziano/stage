package com.purepay.repositories;

import com.purepay.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AndreaValenziano on 23/05/18.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

   public Customer findByIdCustomer(long id);

}
