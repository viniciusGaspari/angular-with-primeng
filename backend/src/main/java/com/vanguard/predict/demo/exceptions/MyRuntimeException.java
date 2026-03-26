package com.vanguard.predict.demo.exceptions;

import lombok.Getter;

@Getter
public class MyRuntimeException extends RuntimeException{

    public final Integer status;
    public MyRuntimeException(String message, Integer status){
        super(message);
        this.status = status;
    }
}
