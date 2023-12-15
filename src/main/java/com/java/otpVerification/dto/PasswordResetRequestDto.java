package com.java.otpVerification.dto;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PasswordResetRequestDto {
	
	private String phoneNumber;
	
	private String userName;
	
	private String oneTimePassword;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	public PasswordResetRequestDto(String phoneNumber, String userName, String oneTimePassword) {
		super();
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.oneTimePassword = oneTimePassword;
	}

	public PasswordResetRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
