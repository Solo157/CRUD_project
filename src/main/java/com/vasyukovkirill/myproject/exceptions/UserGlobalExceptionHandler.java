package com.vasyukovkirill.myproject.exceptions;

import com.vasyukovkirill.myproject.exceptions.handlers.InfoUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<InfoUserException> handleException(UserGlobalException exception) {
        InfoUserException infoUserException = new InfoUserException();
        infoUserException.setInfo(exception.getMessage());
        return new ResponseEntity<>(infoUserException, HttpStatus.NOT_FOUND);
    }


}
