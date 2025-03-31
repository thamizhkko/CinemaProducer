package com.example.Spring_Cinema_Producer.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex) {

		Map<String, Object> errorResponse = new HashMap<String, Object>();

		errorResponse.put("error ", "Not found ");
		errorResponse.put("message", ex.getMessage());
		errorResponse.put("timeStamp", LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
	
	@ExceptionHandler(CinemaIdNotFoundException.class)
	public ResponseEntity<Object> handleCinemaIdNotFoundException(CinemaIdNotFoundException ex){
		
		Map<String, Object> errorResponse=new HashMap<String, Object>();
		errorResponse.put("error ", "Not found cinema id");
		errorResponse.put("message", ex.getMessage());
		errorResponse.put("timeStamp", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	
	@ExceptionHandler(MovieIdNotFoundException.class)
	public ResponseEntity<Object> handleMovieIdNotFoundException(MovieIdNotFoundException ex){
		
		Map<String, Object> errorResponse=new HashMap<String, Object>();
		errorResponse.put("error ", "Not found movie id");
		errorResponse.put("message", ex.getMessage());
		errorResponse.put("timeStamp", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<Object> handleUserIdNotFoundException(UserIdNotFoundException ex){
		
		Map<String, Object> errorResponse=new HashMap<String, Object>();
		errorResponse.put("error ", "Not found user id");
		errorResponse.put("message", ex.getMessage());
		errorResponse.put("timeStamp", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
}
