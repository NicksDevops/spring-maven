package com.integra.demo.Exception;

import java.util.List;

public class AppException extends RuntimeException{
	
	private String errorCode;
	private String errorMessage;
	private List<String> context; 
	private Throwable cause;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<String> getContext() {
		return context;
	}
	public void setContext(List<String> context) {
		this.context = context;
	}
	public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	
	public AppException(String errorCode, String errorMessage, List<String> context, Throwable cause) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.context = context;
		this.cause = cause;
	}
	public AppException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public AppException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}
}
