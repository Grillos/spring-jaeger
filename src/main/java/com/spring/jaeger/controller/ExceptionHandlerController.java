package com.spring.jaeger.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.jaeger.domain.ErrorResponseException;
import com.spring.jaeger.domain.Response;
import com.spring.jaeger.enumaration.ExceptionEnum;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ErrorResponseException.class)
	public ResponseEntity<Response> errorResponseExceptionHandler(ErrorResponseException ex) {
		return new ResponseEntity<>(ex.getResponse(), ex.getStatus());
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Response> entityNotFoundException(EntityNotFoundException ex) {
		return new ResponseEntity<>(
				Response.builder().code(ExceptionEnum.NOT_FOUND.getId())
						.description(ExceptionEnum.NOT_FOUND.getDescription()).message(ex.getMessage()).build(),
				HttpStatus.NOT_FOUND);
	}

}
