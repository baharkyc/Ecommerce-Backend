package com.workintech.fizzystore.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FizzyStoreException extends RuntimeException{

    private HttpStatus httpStatus;

    public FizzyStoreException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
