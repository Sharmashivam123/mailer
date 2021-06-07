package com.shivam.mailer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shivam.mailer.exceptions.exceptiontypes.UserNotFoundException;
import com.shivam.mailer.model.ErrorResponse;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

	public static String message;

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exception){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
	}
	
}
