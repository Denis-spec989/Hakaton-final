package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, reason = "Converter not found")
public class ConverterNotFoundException extends RuntimeException {
}
