package com.enviro.assessment.grad001.kganyamaleka.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler is a centralized exception handler that catches exceptions
 * thrown across the entire application and returns customized error responses.
 * It specifically handles validation exceptions that occur when method arguments
 * do not meet the expected validation constraints.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException, which occurs when the request body
     * does not conform to the validation constraints defined in the model.
     * It collects all validation errors from the exception and returns them as a
     * map of field names and error messages.
     *
     * @param ex The exception thrown when validation fails.
     * @return A ResponseEntity containing a map of validation errors and a BAD_REQUEST status.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
