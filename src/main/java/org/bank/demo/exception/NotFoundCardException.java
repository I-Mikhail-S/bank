package org.bank.demo.exception;

public class NotFoundCardException extends RuntimeException{
    public NotFoundCardException(String message) {
        super(message);
    }
}
