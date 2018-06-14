package com.purepay.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private long idPayment;

    @NotNull
    @Length(max = 2)
    private String flowTypeCode;

    @Lob
    @Column(columnDefinition = "BLOB", name = "msisdn")
    @JsonIgnore
    private byte[] msisdn;
    private double price;

    @Transient
    @JsonAlias("msisdn")
    private String msisdnStr;


    @Column(columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime insertDate;

    @Column(columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idCustomer", foreignKey = @ForeignKey(name = "FK_CUSTOMER"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct", foreignKey = @ForeignKey(name = "FK_PRODUCT"))
    @NotNull
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaymentState", foreignKey = @ForeignKey(name = "FK_PAYMENT_STATE"))
    private PaymentState paymentState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRetailer", foreignKey = @ForeignKey(name = "FK_RETAILER"))
    @NotNull
    private Retailer retailer;

    public Payment(PaymentDTO paymentDTO){
        this.flowTypeCode = paymentDTO.getFlowTypeCode();
        this.msisdn = paymentDTO.getMsisdn().getBytes();
        this.customer = paymentDTO.getCustomer();
        this.price=paymentDTO.getPrice();
    }

    public Payment() {
    }

    public long getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(long idPayment) {
        this.idPayment = idPayment;
    }

    public byte[] getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(byte[] msisdn) {
        this.msisdn = msisdn;
    }

    public String getMsisdnStr() {
        return msisdnStr;
    }

    public void setMsisdnStr(String msisdnStr) {
        this.msisdnStr = msisdnStr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFlowTypeCode() {
        return flowTypeCode;
    }

    public void setFlowTypeCode(String flowTypeCode) {
        this.flowTypeCode = flowTypeCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PaymentState getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

}
