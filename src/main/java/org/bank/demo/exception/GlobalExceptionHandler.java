package org.bank.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundAccountException.class)
    public ResponseEntity<ApiError> handleNoAccountException(NotFoundAccountException exception) {
        ApiError error = new ApiError();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundCardException.class)
    public ResponseEntity<ApiError> handlerNoCardException(NotFoundCardException exception) {
        ApiError error = new ApiError();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundTransactionalException.class)
    public ResponseEntity<ApiError> handlerNoTransactionalException(NotFoundTransactionalException exception) {
        ApiError error = new ApiError();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
