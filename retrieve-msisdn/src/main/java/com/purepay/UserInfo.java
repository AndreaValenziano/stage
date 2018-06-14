package com.purepay;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
public class UserInfo {

    private  String providerRef;
    private  String msisdn;

    public UserInfo(String msisdn, String providerRef) {
        this.msisdn = msisdn;
        this.providerRef = providerRef;
    }

    public String getProviderRef() {
        return providerRef;
    }

    public void setProviderRef(String providerRef) {
        this.providerRef = providerRef;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}

