package com.workintech.fizzystore.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class FizzyStoreUniversalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<FizzyStoreErrorResponse> handleException(FizzyStoreException exception) {
        FizzyStoreErrorResponse fizzyStoreErrorResponse = new FizzyStoreErrorResponse(exception.getMessage(), exception.getHttpStatus().value(), System.currentTimeMillis());

        return new ResponseEntity<>(fizzyStoreErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<FizzyStoreErrorResponse> handleException(Exception exception) {
        FizzyStoreErrorResponse fizzyStoreErrorResponse = new FizzyStoreErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis());

        return new ResponseEntity<>(fizzyStoreErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
