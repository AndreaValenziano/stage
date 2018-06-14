package com.purepay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by AndreaValenziano on 25/05/18.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Payment amount exceeds limits")
public class ExceededAmountLimitsException extends RuntimeException {

    public ExceededAmountLimitsException() {
        super("Payment amount exceeds limits");
    }
}
