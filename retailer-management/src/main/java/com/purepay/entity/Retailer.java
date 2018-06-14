package com.purepay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.purepay.RetailerDTO;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by AndreaValenziano on 31/05/18.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int idRetailer;

    @NotNull
    @Length(max = 200)
    private String retailerName;

    @Length(max = 500)
    private String retailerDescription;

    @Length(max = 30)
    private String retailerCode;

    @Length(max = 50)
    private String userName;

    @Lob
    @Column(columnDefinition = "BLOB")
    @JsonIgnore
    private byte[] password;

    @Lob
    @Column(columnDefinition = "BLOB")
    @JsonIgnore
    private byte[] cryptingKey;

    @Transient
    private String token;


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

    @Length(max = 200)
    private String retailerCCEmail;

    @Length(max = 45)
    private String retailerCCTel;

    public Retailer() {
    }

    public Retailer(RetailerDTO retailerDTO) {
        this.userName = retailerDTO.getUsername();
        this.password = retailerDTO.getPassword().getBytes();
        this.retailerName = retailerDTO.getRetailerName();
        this.retailerDescription = retailerDTO.getRetailerDescription();
        this.retailerCode = retailerDTO.getRetailerCode();
        this.retailerCCEmail = retailerDTO.getRetailerCCEmail();
        this.retailerCCTel = retailerDTO.getRetailerCCTel();
        Logger logger = LoggerFactory.getLogger(this.getClass());
        this.token = UUID.randomUUID().toString();
        this.cryptingKey = token.getBytes();
        logger.info("TOKEN RETAILER CONSTRUCTOR: {}",token);

    }

    public int getIdRetailer() {
        return idRetailer;
    }

    public void setIdRetailer(int idRetailer) {
        this.idRetailer = idRetailer;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getRetailerDescription() {
        return retailerDescription;
    }

    public void setRetailerDescription(String retailerDescription) {
        this.retailerDescription = retailerDescription;
    }

    public String getRetailerCode() {
        return retailerCode;
    }

    public void setRetailerCode(String retailerCode) {
        this.retailerCode = retailerCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public byte[] getCryptingKey() {
        return cryptingKey;
    }

    public void setCryptingKey(byte[] cryptingKey) {
        this.cryptingKey = cryptingKey;
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

    public String getRetailerCCEmail() {
        return retailerCCEmail;
    }

    public void setRetailerCCEmail(String retailerCCEmail) {
        this.retailerCCEmail = retailerCCEmail;
    }

    public String getRetailerCCTel() {
        return retailerCCTel;
    }

    public void setRetailerCCTel(String retailerCCTel) {
        this.retailerCCTel = retailerCCTel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
