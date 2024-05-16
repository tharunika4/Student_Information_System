package com.MyExceptions;


public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds to make the payment.");
    }
}
