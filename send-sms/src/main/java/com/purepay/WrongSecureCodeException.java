package com.purepay;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by AndreaValenziano on 25/05/18.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Wrong secure code")
public class WrongSecureCodeException extends RuntimeException {
}
