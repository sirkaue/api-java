package com.sirkaue.clientapi.service.exception;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String msg) {
        super(msg);
    }
}
