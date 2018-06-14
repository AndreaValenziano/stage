package com.purepay;

import com.purepay.entity.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.time.LocalDateTime;

/**
 * Created by AndreaValenziano on 25/05/18.
 */
@RestController
@PropertySource("application.properties")
@CrossOrigin
public class SendSmsController {

    @Autowired
    SmsService smsService;

    @Value("${sms.text:default}")
    private String messageText;


    @PostMapping("/send-sms")
    public ResponseEntity<Sms> sendSms(@RequestBody Sms sms){

        //TODO: call pb services to send a sms

            long code = smsService.generatedRandomCode();
            sms.setCode(code);
            sms.setMsisdn(sms.getMsisdn());
            sms.setCreationTime(LocalDateTime.now());
            sms.setText(MessageFormat.format(this.messageText,String.valueOf(code)));
            //only for demosration
            return new ResponseEntity<>(smsService.save(sms),HttpStatus.OK);

            //in production: don't send code and text message

    }



}
