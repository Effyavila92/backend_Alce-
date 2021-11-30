package com.misiontic.alcesteMs.exceptions;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(String message){
        super(message);
    }

}
