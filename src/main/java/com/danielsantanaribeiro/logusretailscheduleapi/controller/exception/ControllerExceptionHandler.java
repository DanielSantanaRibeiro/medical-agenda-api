package com.danielsantanaribeiro.logusretailscheduleapi.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.danielsantanaribeiro.logusretailscheduleapi.services.exceptions.MaxNumberOfScheduleByDayException;
import com.danielsantanaribeiro.logusretailscheduleapi.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req){
		StandardError stdError = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stdError);
	}
	
	@ExceptionHandler(MaxNumberOfScheduleByDayException.class)
	public ResponseEntity<StandardError> maxNumberOfScheduleByDay(MaxNumberOfScheduleByDayException e, HttpServletRequest req){
		StandardError stdError = new StandardError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(stdError);
	}
}
