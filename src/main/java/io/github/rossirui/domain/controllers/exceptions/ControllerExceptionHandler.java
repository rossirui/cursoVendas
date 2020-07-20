package io.github.rossirui.domain.controllers.exceptions;

import io.github.rossirui.domain.services.exceptions.LocalObjectNotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(LocalObjectNotFoudException.class)
    public ResponseEntity<StardardError> localObjectNotFound(LocalObjectNotFoudException e,
                                                             HttpServletRequest request) {
        StardardError error = new StardardError(HttpStatus.NOT_FOUND.value(),
                e.getMessage(), System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
