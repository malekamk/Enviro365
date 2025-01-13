package com.enviro.assessment.grad001.kganyamaleka;

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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Loop through all field errors and add them to the errors map.
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        // Return the error map with a BAD_REQUEST (400) HTTP status.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
