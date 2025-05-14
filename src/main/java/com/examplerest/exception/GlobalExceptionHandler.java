package com.examplerest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object> >handleNotFound(ResourceNotFoundException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        error.put("error","Not Found");
        error.put("error Code",HttpStatus.NOT_FOUND.value());
        error.put("message",ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IllegalArgumentsException.class)
    public ResponseEntity<Map<String,Object>> handleBadRequest(IllegalArgumentsException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        error.put("error","Invalid Request");
        error.put("error Code",HttpStatus.BAD_REQUEST.value());
        error.put("message",ex.getMessage());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
