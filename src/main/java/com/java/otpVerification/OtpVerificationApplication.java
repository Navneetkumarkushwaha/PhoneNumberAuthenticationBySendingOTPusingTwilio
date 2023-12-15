package com.java.otpVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.otpVerification.config.TwilioConfig;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class OtpVerificationApplication {

	@Autowired
	private TwilioConfig twilioconfig;
	
	@PostConstruct
	public void initTwilio() {
		Twilio.init(twilioconfig.getAccountSid(),twilioconfig.getAuthToken());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OtpVerificationApplication.class, args);
	}

	
	
}
