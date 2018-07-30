package com.infy.springbootrestapi.exception;

public class ErrorDetails {

	private String errorCode;
	private String description;

	public ErrorDetails(String errorCode, String description) {
		super();
		this.errorCode = errorCode;
		this.description = description;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
