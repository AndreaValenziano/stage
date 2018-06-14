package com.purepay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Already exist")
public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message) {
        super(message);
    }
}
