package com.vasyukovkirill.myproject.exceptions;

public class IsEmptySearchQueryException extends UserGlobalException {
    public IsEmptySearchQueryException() {
        super("Search query is empty.");
    }
}
