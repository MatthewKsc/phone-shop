package com.matthewksc.phoneshop.exeptions;

public class NotFoundPhoneException extends RuntimeException{

    public NotFoundPhoneException(String model) {
        super("No such model in database: "+model);
    }
}
