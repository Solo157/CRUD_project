package com.vasyukovkirill.myproject.exceptions;

public class IncorrectSpecificationException extends UserGlobalException {
    public IncorrectSpecificationException() {
        super("Incorrect specification request.");
    }
}
