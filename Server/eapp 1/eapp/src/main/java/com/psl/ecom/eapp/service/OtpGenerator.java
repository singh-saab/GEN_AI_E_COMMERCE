package com.psl.ecom.eapp.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Description(value = "Service for generating and validating OTP.")
@Service
public class OtpGenerator {

	private static final Integer EXPIRE_MIN = 5;
	private LoadingCache<String, Integer> otpCache;

	/**
	 * Constructor configuration.
	 */
	public OtpGenerator() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					@Override
					public Integer load(String s) throws Exception {
						return 0;
					}
				});
	}

	/**
	 * Method for generating OTP and put it in cache.
	 *
	 * @param key - cache key
	 * @return cache value (generated OTP number)
	 */
	public Integer generateOTP(String key) {
		Random random = new Random();
		int OTP = 100000 + random.nextInt(900000);
		System.out.println(OTP);
		try {
			otpCache.put(key, OTP);			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
//		System.out.println("22222222222222222222222");
		return OTP;
	}

	/**
	 * Method for getting OTP value by key.
	 *
	 * @param key - target key
	 * @return OTP value
	 */
	public Integer getOPTByKey(String key) {
		return otpCache.getIfPresent(key);
	}

	/**
	 * Method for removing key from cache.
	 *
	 * @param key - target key
	 */
	public void clearOTPFromCache(String key) {
		otpCache.invalidate(key);
	}
}
