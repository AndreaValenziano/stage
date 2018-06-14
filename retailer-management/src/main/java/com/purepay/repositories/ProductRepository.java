package com.purepay.repositories;

import com.purepay.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {


    @Override
    List<Product> findAll();

    Optional<Product> findByProductUniqueCode(int productUniqueCode);
}
