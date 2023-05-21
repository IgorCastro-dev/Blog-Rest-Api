package com.igor.blog.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
	
	@ExceptionHandler(BlogResourceException.class)
	private ResponseEntity<ErroDetails> blogResourceException(BlogResourceException exception,WebRequest webRequest) {
		ErroDetails erroDetails = ErroDetails.builder()
				.timesTamp(LocalDateTime.now())
				.message(exception.getMessage())
				.path(webRequest.getDescription(false))
				.erroCode("BAD_REQUEST")
				.build();
		return new ResponseEntity<>(erroDetails,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ErroDetails> validationExcepition(MethodArgumentNotValidException exception,WebRequest webRequest){

		Map<String,String> erros = new HashMap<>();
		System.prin
		 exception.getBindingResult();
		ErroDetails erroDetails = ErroDetails.builder()
				.timesTamp(LocalDateTime.now())
				.message(m)
				.path(webRequest.getDescription(false))
				.erroCode("BAD_REQUEST")
				.build();
		return new ResponseEntity<>(erroDetails,HttpStatus.BAD_REQUEST);
	}
}








