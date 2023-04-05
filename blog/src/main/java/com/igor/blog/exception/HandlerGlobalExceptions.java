package com.igor.blog.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandlerGlobalExceptions {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<ErroDetails> resourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest) {
		ErroDetails erroDetails = ErroDetails.builder()
											.timesTamp(LocalDateTime.now())
											.message(exception.getMessage())
											.path(webRequest.getDescription(false))
											.erroCode("NOT_FOUND")
											.build();
		return new ResponseEntity<>(erroDetails,HttpStatus.NOT_FOUND);
									
	}
}
