package com.vasyukovkirill.myproject.exceptions;
public class NotFoundUserException extends UserGlobalException {
    public NotFoundUserException() {
        super("User not found.");
    }
}
