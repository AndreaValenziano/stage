package com.purepay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
@RestController
@CrossOrigin
public class RetrieveMsisdnController {

    @PostMapping("/msisdn")
    public ResponseEntity<UserInfo> getMsisdn(@RequestBody NavigationType navigationType) {

        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("RETRIEVE MSISDN {}", navigationType.getNavigationType());

        if (navigationType.getNavigationType().toLowerCase().equals("mobile")) {
            return (new ResponseEntity<UserInfo>(
                    new UserInfo("+393485916588", "vodafone"),
                    HttpStatus.OK));
        } else {
            throw new UserUnenrichableException();
        }

    }

    static class NavigationType{
        private String navigationType;

        public String getNavigationType() {
            return navigationType;
        }

        public void setNavigationType(String navigationType) {
            this.navigationType = navigationType;
        }
    }

}
