package com.examplerest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object> >handleNotFound(ResourceNotFoundException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("error","Not Found");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IllegalArgumentsException.class)
    public ResponseEntity<Map<String,Object>> handleBadRequest(IllegalArgumentsException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("error","Invalid Request");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
