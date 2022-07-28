package com.cidenet.cidenet.Excepcions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(Excepciones.class)
    public MessageError excepciones(Excepciones excepcion) {
        return new MessageError("Excepciones", excepcion.getMessage());
    }

}
