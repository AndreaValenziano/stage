package com.purepay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.purepay.entity.Retailer;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetailerDTO {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;


    private String token;

    private String retailerName;

    private String retailerDescription;
    private String retailerCode;
    private String retailerCCEmail;
    private String retailerCCTel;

    public RetailerDTO(Retailer retailer) {
        this.username = retailer.getUserName();
        this.retailerName = retailer.getRetailerName();
        this.retailerDescription = retailer.getRetailerDescription();
        this.retailerCode = retailer.getRetailerCode();
        this.retailerCCEmail = retailer.getRetailerCCEmail();
        this.retailerCCTel = retailer.getRetailerCCTel();
        this.token = new String(retailer.getCryptingKey());


    }

    public RetailerDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public @Length(max = 500) String getRetailerDescription() {
        return retailerDescription;
    }

    public @Length(max = 30) String getRetailerCode() {
        return retailerCode;
    }

    public @Length(max = 200) String getRetailerCCEmail() {
        return retailerCCEmail;
    }

    public @Length(max = 45) String getRetailerCCTel() {
        return retailerCCTel;
    }
}
