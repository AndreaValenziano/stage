package com.purepay.controllers;

import com.purepay.entity.Product;
import com.purepay.entity.Retailer;
import com.purepay.exceptions.AlreadyExistException;
import com.purepay.exceptions.NotFoundException;
import com.purepay.exceptions.NotSavedException;
import com.purepay.services.RetailerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@RestController
@RequestMapping("/retailer-management")
@CrossOrigin
public class ProductController {

    @Autowired
    RetailerService retailerService;

    @PostMapping("/product")
    public ResponseEntity<Product> newProduct(@RequestBody @Valid Product product, @RequestHeader String token) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("CREATING PRODUCT, TOKEN: {}",token);
        Optional<Retailer> retailer = retailerService.findByToken(token);

        if (retailer.isPresent()) {
            retailer.get().setToken(new String(retailer.get().getCryptingKey()));
            product.setRetailer(retailer.get());

        } else {
            throw new NotFoundException("Wrong Token");

        }

        if (retailerService.findProductByUniqueCode(product.hashCode()).isPresent()) {
            throw new AlreadyExistException("Product already exists!");
        }
        logger.info("RETAILER : {}",product.getRetailer().getUserName());
        product.setProductUniqueCode(product.hashCode());

        Optional<Product> savedProduct = retailerService.save(product);
        if (savedProduct.isPresent()) {
            return new ResponseEntity<>(savedProduct.get(), HttpStatus.CREATED);
        } else {
            throw new NotSavedException("Product not saved");
        }
    }

    @GetMapping("/product/{code}")
    public ResponseEntity<Product> retrieveProduct(@PathVariable(name = "code") int productUniqueCode) {

        Optional<Product> foundProduct = retailerService.findProductByUniqueCode(productUniqueCode);

        if (foundProduct.isPresent()) {
            return new ResponseEntity<>(foundProduct.get(), HttpStatus.OK);
        } else {
            throw new NotFoundException("Product not found");
        }
    }
}

