package ru.vtb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vtb.dto.ErrorResponseDTO;
import ru.vtb.exception.PaymentException;
import ru.vtb.exception.ProductNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleProductException(ProductNotFoundException exception) {
        return new ErrorResponseDTO(exception.getMessage());
    }

    @ExceptionHandler(PaymentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleProductException(PaymentException exception) {
        return new ErrorResponseDTO(exception.getMessage());
    }
}
