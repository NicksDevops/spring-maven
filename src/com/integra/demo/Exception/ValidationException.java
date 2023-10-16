package com.integra.demo.Exception;

import java.util.List;

public class ValidationException extends AppException {
	
	
	public ValidationException(String errorCode, String errorMessage) 
	{
		super(errorCode,errorMessage);
	}

	public ValidationException(String errorCode, String errorMessage, List<String> context, Throwable cause) 
	{
		super(errorCode,errorMessage,context,cause);
	}
	
}
