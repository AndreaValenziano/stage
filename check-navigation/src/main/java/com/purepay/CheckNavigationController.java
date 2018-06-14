package com.purepay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
@RestController
@CrossOrigin
@PropertySource("application.properties")
public class CheckNavigationController {

    @Autowired
    NavTypeRepository repo;

    @PostMapping("/check-navigation")
    public ResponseEntity<NavigationType> checkNavigation(@RequestHeader String data){

        NavigationType navType = repo.findById(1);
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("CHECK NAVIGATION: {}",navType.getType());
        return new ResponseEntity<>(navType, OK);
    }
}

