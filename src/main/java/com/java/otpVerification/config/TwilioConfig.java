package com.java.otpVerification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfig {
	
	private String accountSid;
	
	private String authToken;
	
	private String trailNumber;

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getTrailNumber() {
		return trailNumber;
	}

	public void setTrailNumber(String trailNumber) {
		this.trailNumber = trailNumber;
	}
	
	
	

}
