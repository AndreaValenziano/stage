package com.purepay.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.ColumnDefault;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private long idCustomer;

    @NotNull
    @Length(max=300)
    private String customerName;

    @Length(max=200)
    private String customerCity;

    @Length(max=3)
    private String countryCode;
    @Length(max=3)
    private String mailZoneCode;


    @Column(columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime insertDate;

    @Column(columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime deleteDate;

    @ColumnDefault(value = "0")
    private boolean isDeleted;


    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getBuyerName() {
        return customerName;
    }

    public void setBuyerName(String buyerName) {
        this.customerName = buyerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMailZoneCode() {
        return mailZoneCode;
    }

    public void setMailZoneCode(String mailZoneCode) {
        this.mailZoneCode = mailZoneCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
