package com.purepay.utils;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
public enum RequestType {
    WIFI("WIFI"),
    MOBILE("MOBILE");

    private String value;

    private RequestType(String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }
}
