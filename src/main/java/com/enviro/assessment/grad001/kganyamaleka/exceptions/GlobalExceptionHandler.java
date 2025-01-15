package com.enviro.assessment.grad001.kganyamaleka.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

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
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    // Handle DataIntegrityViolationException
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("status", HttpStatus.BAD_REQUEST.value());
//        response.put("error", "Bad Request");
//        response.put("message", "Database error: " + ex.getMostSpecificCause().getMessage());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    // Handle generic exceptions
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex, WebRequest request) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//        response.put("error", "Internal Server Error");
//        response.put("message", "An unexpected error occurred: " + ex.getMessage());
//        response.put("path", request.getDescription(false).replace("uri=", ""));
//
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }


        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Resource Not Found", "message", ex.getMessage()));
        }

        @ExceptionHandler(InvalidDataException.class)
        public ResponseEntity<Object> handleInvalidData(InvalidDataException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid Data", "message", ex.getMessage()));
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleGeneralException(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Internal Server Error", "message", "An unexpected error occurred."));
        }
    }



