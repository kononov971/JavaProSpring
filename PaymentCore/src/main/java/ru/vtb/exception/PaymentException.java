package ru.vtb.exception;

public class PaymentException extends RuntimeException{

    public PaymentException(String message) {
        super(message);
    }
}
