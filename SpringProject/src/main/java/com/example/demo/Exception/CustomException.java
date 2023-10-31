package com.example.demo.Exception;

import com.example.demo.Exception.CustomException;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}



