package com.purepay;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by AndreaValenziano on 06/06/18.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "User is unenrichable")
public class UserUnenrichableException extends RuntimeException {

}
