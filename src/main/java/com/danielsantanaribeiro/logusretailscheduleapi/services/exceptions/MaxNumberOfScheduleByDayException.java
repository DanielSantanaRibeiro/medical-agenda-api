package com.danielsantanaribeiro.logusretailscheduleapi.services.exceptions;

public class MaxNumberOfScheduleByDayException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaxNumberOfScheduleByDayException(String message) {
		super(message);
	}
	
	public MaxNumberOfScheduleByDayException(String message, Throwable cause) {
		super(message, cause);
	}
}
