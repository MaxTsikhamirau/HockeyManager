package com.example.demo.tsikhamirau.exceptions;

public class UserNotFoundException extends RuntimeException {
    String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }

    public UserNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public UserNotFoundException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public UserNotFoundException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
