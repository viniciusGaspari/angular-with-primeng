package com.vanguard.predict.demo.exceptions;

import com.vanguard.predict.demo.models.exception_response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(MyRuntimeException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandlerResponse(MyRuntimeException ex){
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                ex.status
        );
        return ResponseEntity.status(ex.status).body(response);
    }

}
