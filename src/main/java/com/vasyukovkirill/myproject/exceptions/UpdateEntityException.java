package com.vasyukovkirill.myproject.exceptions;

public class UpdateEntityException extends UserGlobalException {
    public UpdateEntityException() {
        super("This user isn't active");
    }
}
