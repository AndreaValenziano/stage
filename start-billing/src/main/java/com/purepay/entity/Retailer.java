package com.purepay.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by AndreaValenziano on 31/05/18.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int idRetailer;

    @NotNull
    @Length(max=200)
    private String retailerName;

    @Length(max=500)
    private String retailerDescription;

    @Length(max=30)
    private String retailerCode;

    @Length(max=50)
    private String userName;

    @Lob
    @Column(columnDefinition = "BLOB")
    @JsonIgnore
    private byte[] password;

    @Lob
    @Column(columnDefinition = "BLOB")
    @JsonIgnore
    private byte[] cryptingKey;

    @JsonAlias("cryptingKey")
    @Transient
    private String cryptingKeyStr;

    @JsonAlias("password")
    @Transient
    private String passwordStr;


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

    @Length(max=200)
    private String retailerCCEmail;

    @Length(max=45)
    private String retailerCCTel;


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

    public String getCryptingKeyStr() {
        return cryptingKeyStr;
    }

    public void setCryptingKeyStr(String cryptingKeyStr) {
        this.cryptingKeyStr = cryptingKeyStr;
    }

    public String getPasswordStr() {
        return passwordStr;
    }

    public void setPasswordStr(String passwordStr) {
        this.passwordStr = passwordStr;
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

}
