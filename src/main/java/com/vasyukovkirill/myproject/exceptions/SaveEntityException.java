package com.vasyukovkirill.myproject.exceptions;

public class SaveEntityException extends UserGlobalException {
    public SaveEntityException() {
        super("Failed to save data in DataBase.");
    }
}
