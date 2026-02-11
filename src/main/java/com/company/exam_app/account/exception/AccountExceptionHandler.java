package com.company.exam_app.account.exception;

import com.company.exam_app.account.controller.CustomerAccountController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackageClasses ={ CustomerAccountController.class})

public class AccountExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex){

        Map<String,String> errorMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((errorField) ->{
            errorMap.put(errorField.getField() ,errorField.getDefaultMessage());
        });

        Map<String,Object> response = new HashMap<>();
        response.put("transactionStatusCode",HttpStatus.BAD_REQUEST.value());
        response.put("transactionStatusDescription",errorMap);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleMessageNotReadbleException(
            HttpMessageNotReadableException ex){
        return ResponseEntity.badRequest()
                .body("HttpMessageNotReadableException");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleEntityNotFound(EntityNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("transactionStatusCode", 404);
        errorResponse.put("transactionStatusDescription",ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


}



