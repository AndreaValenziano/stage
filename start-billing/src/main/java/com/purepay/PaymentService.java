package com.purepay;

import com.purepay.entity.Payment;
import com.purepay.entity.PaymentState;
import com.purepay.entity.Product;
import com.purepay.entity.Retailer;
import com.purepay.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by AndreaValenziano on 23/05/18.
 */
@Service
@ComponentScan
@EnableAutoConfiguration
public class PaymentService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PaymentStateRepository paymentStateRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RetailerRepository retailerRepository;

    private boolean isDayLimitOk = false;
    private boolean isMonthLimitOk = false;


    public Optional<Payment> save(Payment payment) {

        return Optional.ofNullable(paymentRepository.save(payment));
    }

    public List<Payment> getAllBills(byte[] msisdn) {
        return paymentRepository.findAllByMsisdn(msisdn);
    }

    public boolean isDayLimitOk() {
        return isDayLimitOk;
    }

    public void setDayLimitOk(boolean dayLimitOk) {
        isDayLimitOk = dayLimitOk;
    }

    public boolean isMonthLimitOk() {
        return isMonthLimitOk;
    }

    public void setMonthLimitOk(boolean monthLimitOk) {
        isMonthLimitOk = monthLimitOk;
    }

    public double getTotalAmountOfMonth(List<Payment> payments) {
        logger.info("payments: {}",payments.toString());

       return payments.stream().filter(p -> p.getInsertDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .mapToDouble((Payment::getPrice)).sum();
    }


    public byte[] encrypt(String privateData) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        return privateData.getBytes();

    }

    public Product getProduct(int id){
       return productRepository.findByIdProduct(id);
    }

    public PaymentState getPaymentState(int id){
        return paymentStateRepository.findByIdPaymentState(id);
    }

    public Retailer getRetailer(int id){
        return retailerRepository.findByIdRetailer(id);
    }

}
