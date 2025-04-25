package com.jobfinder.catalogservice.web;

import java.util.HashMap;
import java.util.Map;
import com.jobfinder.catalogservice.domain.JobAlreadyExistsException;
import com.jobfinder.catalogservice.domain.JobNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JobControllerAdvice {

    @ExceptionHandler(JobNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String JobNotFoundHandler(JobNotFoundException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(JobAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String JobAlreadyExistsHandler(JobAlreadyExistsException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidExceptions(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String> ();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
