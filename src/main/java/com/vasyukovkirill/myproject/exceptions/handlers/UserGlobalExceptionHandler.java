package com.vasyukovkirill.myproject.exceptions.handlers;

import com.vasyukovkirill.myproject.exceptions.UserGlobalException;
import com.vasyukovkirill.myproject.dto.InfoForUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<InfoForUserDTO> handleException(UserGlobalException exception) {
        InfoForUserDTO infoForUserDTO = new InfoForUserDTO();
        infoForUserDTO.setInfo(exception.getMessage());
        return new ResponseEntity<>(infoForUserDTO, HttpStatus.NOT_FOUND);
    }


}
