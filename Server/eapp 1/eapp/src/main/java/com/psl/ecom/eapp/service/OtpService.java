package com.psl.ecom.eapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;

import com.psl.ecom.eapp.config.TwilioConfig;
import com.twilio.type.PhoneNumber;

@Description(value = "Service responsible for handling OTP related functionality.")
@Service
public class OtpService {

	private final Logger LOGGER = LoggerFactory.getLogger(OtpService.class);

	@Autowired
	private OtpGenerator otpGenerator;
	@Autowired
	private TwilioConfig twilioConfig;

	/**
	 * Constructor dependency injector
	 * 
	 * @param otpGenerator - otpGenerator dependency
	 * @param emailService - email service dependency
	 * @param userService  - user service dependency
	 */
//	public OtpService(OtpGenerator otpGenerator, UserService userService, TwilioConfig twilioConfig) {
//		this.otpGenerator = otpGenerator;
//		this.twilioConfig = twilioConfig;
//	}

	/**
	 * Method for generate OTP number
	 *
	 * @param key - provided key (username in this case)
	 * @return integer value (otp)
	 * @throws Exception 
	 */
	public String generateOtp(String key, String toPhnNo) throws Exception {
		PhoneNumber to = new PhoneNumber(toPhnNo);
		PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
		Integer otpValue = otpGenerator.generateOTP(key);
		System.out.println("111111111111111111");
		if (otpValue == -1) {
			LOGGER.error("OTP generator is not working...");
			throw new Exception("Failed to create otp !");
		}
		String otpMessage = "Dear Customer , Your OTP is ##" + otpValue
				+ "##. Use this Passcode to complete your transaction. Thank You.";
		// send message
		Message.creator(to, from, otpMessage).create();

		LOGGER.info("Generated OTP: {}", otpValue);

		return otpMessage;
	}

	/**
	 * Method for validating provided OTP
	 *
	 * @param key       - provided key
	 * @param otpNumber - provided OTP number
	 * @return boolean value (true|false)
	 */
	public Boolean validateOTP(String key, Integer otpNumber) {
		// get OTP from cache
		Integer cacheOTP = otpGenerator.getOPTByKey(key);
		if (cacheOTP != null && cacheOTP.equals(otpNumber)) {
			otpGenerator.clearOTPFromCache(key);
			return true;
		}
		return false;
	}
}