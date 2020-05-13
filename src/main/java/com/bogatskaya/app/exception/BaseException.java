package com.bogatskaya.app.exception;

public class BaseException extends RuntimeException{

    private static final Long SERIAL_UID = 1657654234674L;

    public BaseException(final String mesaage, Throwable cause){
        super(mesaage,cause);
    }

    public BaseException(final String message){
        super(message);
    }
}
