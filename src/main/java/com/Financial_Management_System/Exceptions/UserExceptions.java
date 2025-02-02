package com.Financial_Management_System.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserExceptions {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
         Map<String, String> errors = new HashMap<>();
         e.getBindingResult().getAllErrors().forEach(error -> {

            String fieldName = ((FieldError) error).getField();
             String errormessage = error.getDefaultMessage();
             errors.put(fieldName, errormessage);
         });

         return new ResponseEntity<Object> (errors, HttpStatus.BAD_REQUEST);
    }
}
