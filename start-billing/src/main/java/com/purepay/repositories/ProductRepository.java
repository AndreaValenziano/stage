package com.purepay.repositories;

import com.purepay.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AndreaValenziano on 23/05/18.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

   Product findByIdProduct(int idProduct) ;

}
