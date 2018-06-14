package com.purepay.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by AndreaValenziano on 13/04/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseException {

    private String message;
    private String detail;
    private Date timestamp;

    public ResponseException(Date timestamp, String message, String detail) {
        this.message = message;
        this.detail = detail;
        this.timestamp = timestamp;
    }

    public ResponseException(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {


        return message;
    }


    public String getDetail() {
        return detail;
    }


    public Date getTimestamp() {
        return timestamp;
    }


}
