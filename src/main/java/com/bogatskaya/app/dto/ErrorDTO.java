package com.bogatskaya.app.dto;

public class ErrorDTO {

    private String message;

    public ErrorDTO(final String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
