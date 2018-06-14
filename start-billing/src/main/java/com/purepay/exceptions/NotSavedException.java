package com.purepay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Not saved")
public class NotSavedException extends RuntimeException {
    public NotSavedException(String message) {
        super(message);
    }
}
