package com.purepay;

import com.purepay.entity.*;
import com.purepay.exceptions.ExceededAmountLimitsException;
import com.purepay.exceptions.NotFoundException;
import com.purepay.exceptions.NotSavedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by AndreaValenziano on 24/05/18.
 */
@RestController
@ComponentScan
@EnableAutoConfiguration
@CrossOrigin
public class StartBillingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PaymentService paymentService;

    @Autowired
    StartBillingServiceProxy proxy;

    @Autowired
    RetailerManagementProxy retailerManagementProxy;


    @PostMapping("/billing")
    public ResponseEntity<Payment> doBilling(@RequestBody @Valid PaymentDTO paymentDTO) {
        logger.info("Start of doBilling: {}",paymentDTO);

        Payment payment = new Payment(paymentDTO);

        ResponseEntity<Payment> billResponseEntity;
        Optional<Payment> savedPayment;

        payment.setPaymentState(new PaymentState("start", "1"));



        Optional<Product> product = Optional.ofNullable(
                retailerManagementProxy.getProduct(paymentDTO.getProductUniqueCode()));
        if(!product.isPresent()){
            throw new NotFoundException("Product not found");
        }
        payment.setProduct(product.get());
        Optional<Retailer> retailer = Optional.ofNullable(product.get().getRetailer());
        if(retailer.isPresent()){
            payment.setRetailer(retailer.get());
        }else{
            throw new NotFoundException("Retailer not found");
        }

        logger.info("Call external services to checkDayLimits");

        if (proxy.checkDayLimits(payment)) {
            paymentService.setDayLimitOk(true);
        } else {
            paymentService.setDayLimitOk(false);
        }

        payment.setInsertDate(LocalDateTime.now());

        logger.info("Do getAllBills");

        List<Payment> payments = paymentService.getAllBills(payment.getMsisdn());
        payments.add(payment);
        logger.info("List of completed payments: {}", payments);


        double sum = paymentService.getTotalAmountOfMonth(payments);
        logger.info("SUM: {}", sum);

        if (proxy.checkMonthLimits(sum)) {
            paymentService.setMonthLimitOk(true);
        } else {
            paymentService.setMonthLimitOk(false);
        }

        if (paymentService.isDayLimitOk()
                && paymentService.isMonthLimitOk()) {
            savedPayment = paymentService.save(payment);
            if(!savedPayment.isPresent()){
                throw new NotSavedException("Payement not saved");
            }
            logger.info("SAVED PAYMENT: {}", savedPayment);

            return new ResponseEntity<>(savedPayment.get(), HttpStatus.CREATED);
        } else {
            throw new ExceededAmountLimitsException();
        }
    }

    @GetMapping("/payment/month-total")
    public ResponseEntity<Double> getTotalOfTheMonth(@RequestBody String msisdn) {

        List<Payment> payments = paymentService.getAllBills(msisdn.getBytes());
        return new ResponseEntity<>(paymentService.getTotalAmountOfMonth(payments), HttpStatus.OK);

    }
}

