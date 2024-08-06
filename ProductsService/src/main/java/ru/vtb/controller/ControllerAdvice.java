package ru.vtb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vtb.dto.ErrorResponseDTO;
import ru.vtb.exception.PaymentException;
import ru.vtb.exception.ProductException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ProductException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleProductException(ProductException exception) {
        return new ErrorResponseDTO(exception.getMessage());
    }

    @ExceptionHandler(PaymentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handlePaymentException(PaymentException exception) {
        return new ErrorResponseDTO(exception.getMessage());
    }
}
