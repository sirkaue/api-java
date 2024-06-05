package com.sirkaue.api_java.service.exception;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String msg) {
        super(msg);
    }
}
