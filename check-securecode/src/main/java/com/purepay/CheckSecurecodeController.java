package com.purepay;

import com.purepay.entity.Sms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by AndreaValenziano on 25/05/18.
 */
@RestController
@CrossOrigin
public class  CheckSecurecodeController {

    @Autowired
    SmsService smsService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/check-secure-code")
    public ResponseEntity<Sms> checkSecureCode(@RequestBody Sms sms) {
        String msisdn = sms.getMsisdn();
        long receivedCode = sms.getReceivedCode();
        Optional<Sms> smsOptional = smsService.checkSecureCode(sms.getMsisdn(), sms.getReceivedCode());

        if ( smsOptional.isPresent()){
            sms = smsOptional.get();
            sms.setReceivedCode(receivedCode);
            logger.info("sms found -> {}",sms);
            sms.setUpdateTime(LocalDateTime.now());
            return new ResponseEntity<>( smsService.update(sms), HttpStatus.OK);
        }
        else
            throw new WrongSecureCodeException();
    }
}
