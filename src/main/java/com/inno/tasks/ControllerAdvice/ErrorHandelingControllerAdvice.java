package com.inno.tasks.ControllerAdvice;

import com.inno.tasks.Entity.Violation;
import com.inno.tasks.ErrorHandler.ValidationErrorResponse;
import com.inno.tasks.ExceptionHandeling.ResourceNotFoundException;
import com.sun.net.httpserver.HttpServer;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ErrorHandelingControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            error.getViolations().add(
                    new Violation(violation.getPropertyPath().toString(), violation.getMessage())
            );
        }
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e){
        ValidationErrorResponse error= new ValidationErrorResponse();
        for (FieldError fieldError:e.getBindingResult().getFieldErrors()){
            error.getViolations().add(
                    new Violation(fieldError.getField(),fieldError.getDefaultMessage())
            );
        }
        return error;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ValidationErrorResponse onNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(new Violation(request.getRequestURI(),e.getMessage()));
        return error;
    }
}

