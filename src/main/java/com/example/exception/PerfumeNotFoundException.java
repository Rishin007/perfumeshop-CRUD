package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PerfumeNotFoundException extends RuntimeException {
    public PerfumeNotFoundException() {
        super("NO PERFUMES HAVE BEEN FOUND");
    }
}
