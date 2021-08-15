package com.vasyukovkirill.myproject.exceptions;

public class DataNotFoundException extends UserGlobalException {
    public DataNotFoundException() {
        super("There isn't data in DataBase.");
    }
}
