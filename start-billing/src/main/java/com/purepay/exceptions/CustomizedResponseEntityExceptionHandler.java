package com.purepay.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * Created by AndreaValenziano on 13/04/18.
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
ResponseException responseException =
        new ResponseException(new Date(), ex.getMessage(), request.getDescription(false) );
        return new ResponseEntity(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value={NotFoundException.class, ExceededAmountLimitsException.class,NotSavedException.class })
    public void handleNotFoundException(Exception ex) throws Throwable {
       throw ex.getCause();
    }




    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseException responseException =
                new ResponseException("Validation failed", new Date());
        return new ResponseEntity(responseException, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseException responseException =
                new ResponseException("Validation failed", new Date());
        return new ResponseEntity(responseException, HttpStatus.BAD_REQUEST);
    }
}
