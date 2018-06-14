package com.purepay.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
@Valid
public class PaymentDTO {

    @NotNull
    @NotEmpty
    private String flowTypeCode;

    @NotNull
    private double price;

    @NotNull
    @NotEmpty
    private String msisdn;

    private Customer customer;

    @NotNull
    private int productUniqueCode;


    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public @NotNull int getProductUniqueCode() {
        return productUniqueCode;
    }

    public void setProductUniqueCode(@NotNull int productUniqueCode) {
        this.productUniqueCode = productUniqueCode;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "flowTypeCode='" + flowTypeCode + '\'' +
                ", price=" + price +
                ", msisdn='" + msisdn + '\'' +
                ", customer=" + customer +
                ", productUniqueCode=" + productUniqueCode +
                '}';
    }
}
