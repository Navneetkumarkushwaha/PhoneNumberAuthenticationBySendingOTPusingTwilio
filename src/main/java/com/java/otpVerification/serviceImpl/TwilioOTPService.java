package com.java.otpVerification.serviceImpl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.otpVerification.config.TwilioConfig;
import com.java.otpVerification.dto.OtpStatus;
import com.java.otpVerification.dto.PasswordResetRequestDto;
import com.java.otpVerification.dto.PasswordResetResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.lookups.v1.PhoneNumber;

import reactor.core.publisher.Mono;

@Service
public class TwilioOTPService {
	
	@Autowired
	private PasswordResetRequestDto passwordResetRequestDto;
	
	@Autowired
	private TwilioConfig twilioConfig;
	
	
	HashMap<String, String> otpMap = new HashMap<>();

	
	public Mono<PasswordResetResponseDto> sendOTPForPasswordReset(PasswordResetRequestDto passwordResetRequestDto) {
		
		try {
			
			com.twilio.type.PhoneNumber to = new com.twilio.type.PhoneNumber(passwordResetRequestDto.getPhoneNumber());
			
			com.twilio.type.PhoneNumber from = new com.twilio.type.PhoneNumber(twilioConfig.getTrailNumber());
			
			String otp = generateOTP();
			
			String otpMessage = "Dear Student ,Your OTP is ##"+otp +"## Use this passcode to complete your registration. Thankyou";
			
			Message message = Message.creator(
				      to,
				      from,
				      otpMessage)
				    .create();
			
			otpMap.put(passwordResetRequestDto.getUserName(),otp);
			
			PasswordResetResponseDto abc = new PasswordResetResponseDto(OtpStatus.DELIVERED,otpMessage);
			
			return Mono.just(abc);
			
		}catch (Exception e) {
			
			PasswordResetResponseDto abc = new PasswordResetResponseDto(OtpStatus.FAILED,e.getMessage());
			
			return Mono.just(abc);
		}
	}
	
	public Mono<String> validateOTP(String userInputOtp,String userName){
		if(userInputOtp.equals(otpMap.get(userName))) {
			otpMap.remove(userName,userInputOtp);
			return Mono.just("Valid OTP");
		}else {
			return Mono.error(new IllegalArgumentException("Invalid otp Please retry"));
		}
		
	}
	
	
	public String generateOTP() {
		return new DecimalFormat("000000")
				.format(new Random().nextInt(999999));
	}
	
	
	
}
