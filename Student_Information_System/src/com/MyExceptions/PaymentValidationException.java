package com.MyExceptions;

public class PaymentValidationException extends Exception {

    public PaymentValidationException() {
        super("Payment validation failed.");
    }
}