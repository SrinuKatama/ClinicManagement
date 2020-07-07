package com.bridgelabs.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bridgelabs.responses.Responses;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(UserException.class)
	public final ResponseEntity<Responses> userException(UserException ex)
	{
		Responses exp = new Responses();
		exp.setMessage(ex.getMessage());
		exp.setStatusCode(ex.getStatus());
		exp.setDetails(ex.getTime());
	return ResponseEntity.status(exp.getStatusCode()).body(new Responses(exp.getMessage(), exp.getStatusCode(),exp.getDetails()));
	}
}
