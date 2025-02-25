package org.annill.crud.configuration;

import org.annill.crud.exception.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ErrorDto> handlerException() {
        return ResponseEntity
                .status(400)
                .body(new ErrorDto(404, "entity exception"));

    }
}
