package com.purepay.services;

import com.purepay.entity.Product;
import com.purepay.entity.Retailer;
import com.purepay.repositories.ProductRepository;
import com.purepay.repositories.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@Service
public class RetailerService {

    @Autowired
    RetailerRepository retailerRepository;

    @Autowired
    ProductRepository productRepository;


    public Optional<Retailer> findByUsernameAndPassword(String username, String password) {

        return retailerRepository.findByUserNameAndPassword(username, password.getBytes());

    }


    public Optional<Retailer> save(Retailer retailer) {
        return Optional.of(retailerRepository.save(retailer));
    }


    public Optional<Retailer> findByToken(String token) {
        return retailerRepository.findByCryptingKey(token.getBytes());
    }

    public Optional<Product> save(Product product) {
        return Optional.of(productRepository.save(product));
    }

    public Optional<List<Product>> findAllProduct() {
        return Optional.of(productRepository.findAll());
    }

    public Optional<Product> findProductByUniqueCode(int productUniqueCode) {

        return productRepository.findByProductUniqueCode(productUniqueCode);
    }

    public Optional<Retailer> findByUsername(String username) {
        return retailerRepository.findByUserName(username);
    }
}
