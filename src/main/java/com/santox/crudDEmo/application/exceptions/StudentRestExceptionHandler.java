package com.santox.crudDEmo.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//contiene @Component paradeclarrar metodos relacionados con el manejo de exceptions
public class StudentRestExceptionHandler {

    //agregar gestor de excpeciones
    @ExceptionHandler//método gestionador de excepciones
    public ResponseEntity<StudentErrorResponse> studentErrorEntity(StudentNotFoundException exception){
        //instanciar objeto de la clase studentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    //otro gestionador de excepciones para capturar cualquier excepcion
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExeption(Exception exception){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);

    }

}
