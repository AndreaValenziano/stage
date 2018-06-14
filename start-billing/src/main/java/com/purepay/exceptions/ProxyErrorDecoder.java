package com.purepay.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

import static feign.FeignException.errorStatus;

/**
 * Created by AndreaValenziano on 08/06/18.
 */
public class ProxyErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            if(response.status()==404){
                return new NotFoundException(response.reason());
            }
            return new RuntimeException(
                    response.reason()
            );
        }

        return errorStatus(methodKey, response);
    }
}
