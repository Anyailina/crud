package org.annill.crud.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ErrorDto {
    private final Integer code;
    private final String description;
}
