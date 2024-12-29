package com.selleniumexpress.error;

import java.time.LocalDateTime;

public class CustomError {
	
	public  String date;
	
	public  String message;
	
	public String errorType;

	public CustomError() {
		// TODO Auto-generated constructor stub
	}

	public CustomError(String date, String message, String errorType) {
		super();
		this.date = date;
		this.message = message;
		this.errorType = errorType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	
	

}
