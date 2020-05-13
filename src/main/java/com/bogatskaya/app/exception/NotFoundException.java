package com.bogatskaya.app.exception;

public class NotFoundException extends BaseException{

    public NotFoundException(String mesaage, Throwable cause) {
        super(mesaage, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
