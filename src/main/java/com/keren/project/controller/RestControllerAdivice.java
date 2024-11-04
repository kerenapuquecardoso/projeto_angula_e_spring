package com.keren.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class RestControllerAdivice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationsExceptions(MethodArgumentNotValidException e){
       BindingResult bind = e.getBindingResult();
       List<String> messages = bind.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
       return new ApiErrors(messages);


    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException( ResponseStatusException e){
        String mensagem = e.getMessage();
        HttpStatus codigoHttpStatus = (HttpStatus) e.getStatusCode();
        ApiErrors apiErrors = new ApiErrors(mensagem);
        return  new ResponseEntity(apiErrors, codigoHttpStatus);
    }
    
}
