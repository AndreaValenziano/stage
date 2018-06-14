package com.purepay;

import com.purepay.entity.Sms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by AndreaValenziano on 25/05/18.
 */
@Service
public class SmsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SmsRepository smsRepository;

    public long generatedRandomCode() {

        long code = Math.round(Math.random() * 100000);
        return code;
    }


    public Sms save(Sms sms) {
        return smsRepository.save(sms);
    }


    public Optional<Sms> checkSecureCode(String msisdn, long receivedCode) {
        Sms sms = smsRepository.findFirstByMsisdnOrderByCreationTimeDesc(msisdn);
        return sms.getCode() == receivedCode
                ? Optional.of(sms)
                : Optional.empty();
    }

    public Sms update(Sms sms) {
        logger.info("sms id -> {}",sms.getId());
       int smsUpdatedId =  smsRepository.setSmsInfoById(sms.getUpdateTime(),sms.getReceivedCode(), sms.getId());
        logger.info("Return value for updating -> {} ",smsUpdatedId);
       return sms;

    }
}
