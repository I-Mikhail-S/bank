package org.bank.demo.exception;

public class NotFoundTransactionalException extends RuntimeException{
    public NotFoundTransactionalException(String message) {
        super(message);
    }
}
