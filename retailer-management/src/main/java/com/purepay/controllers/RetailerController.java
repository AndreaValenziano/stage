package com.purepay.controllers;

import com.purepay.RetailerDTO;
import com.purepay.entity.Retailer;
import com.purepay.exceptions.AlreadyExistException;
import com.purepay.exceptions.NotFoundException;
import com.purepay.exceptions.NotSavedException;
import com.purepay.services.RetailerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@RestController
@RequestMapping("/retailer-management")
@CrossOrigin
public class RetailerController {

    @Autowired
    RetailerService retailerService;

    @PostMapping("/retailer")
    public ResponseEntity<RetailerDTO> newRetailer(@RequestBody @Valid RetailerDTO retailerDTO) {
        Optional<Retailer> savedRetailer;
        Logger logger = LoggerFactory.getLogger(this.getClass());


        if (!retailerService.findByUsername(retailerDTO.getUsername())
                .isPresent()) {
            savedRetailer = retailerService.save(new Retailer(retailerDTO));

            if (!savedRetailer.isPresent()) {
                throw new NotSavedException("Retailer not saved");
            }
        } else {
            throw new AlreadyExistException("Retailer " + retailerDTO.getUsername() + " already exists");
        }

        return new ResponseEntity<>(new RetailerDTO(savedRetailer.get()), CREATED);
    }

    //TODO: SOLVE THIS BUG
    @GetMapping("/retailer")
    public ResponseEntity<Retailer> retrieveRetailer(@RequestBody @Valid RetailerDTO retailerDTO) {
        return new ResponseEntity<>(retailerService.findByUsernameAndPassword(retailerDTO.getUsername(), retailerDTO.getPassword())
                .orElseThrow(NotFoundException::new), OK);
    }


}
