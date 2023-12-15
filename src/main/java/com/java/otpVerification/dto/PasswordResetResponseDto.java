package com.java.otpVerification.dto;

public class PasswordResetResponseDto {
	
	private OtpStatus status;
	
	private String message;

	public OtpStatus getStatus() {
		return status;
	}

	public void setStatus(OtpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public PasswordResetResponseDto(OtpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public PasswordResetResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
