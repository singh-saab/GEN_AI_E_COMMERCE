package com.psl.ecom.eapp.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.ecom.eapp.dto.OTPStatusDTO;
import com.psl.ecom.eapp.entity.User;
import com.psl.ecom.eapp.request.AuthRequest;
import com.psl.ecom.eapp.request.OTPRequest;
import com.psl.ecom.eapp.response.AuthResponse;
import com.psl.ecom.eapp.response.OTPResponse;
import com.psl.ecom.eapp.service.OtpService;
import com.psl.ecom.eapp.service.UserService;
import com.psl.ecom.eapp.service.auth.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private UserService userService;
	private ModelMapper modelMapper;
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;
	private OtpService otpService;

	public AuthController(UserService userService, ModelMapper modelMapper, AuthenticationManager authenticationManager,
			JwtService jwtService, OtpService otpService) {
		super();
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		this.otpService = otpService;
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		try {
			User user = modelMapper.map(userService.findByEmail(authRequest.getUsername()), User.class);

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

			if (authentication.isAuthenticated()) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(jwtService.generateToken(authRequest.getUsername(), user));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@PostMapping("/generate/otp")
	@PreAuthorize("hasAnyAuthority('ADMIN','CUSTOMER')")
	public ResponseEntity<OTPResponse> generateOTP(OTPRequest otpReq) {
		try {
			String otpMssg = otpService.generateOtp(otpReq.getEmail(), otpReq.getToPhoneNumber());
			System.out.println("0000000000000000");
			OTPResponse res = new OTPResponse();
			res.setStatus(OTPStatusDTO.DELIVERED);
			res.setMessage(otpMssg);
			return ResponseEntity.status(HttpStatus.CREATED).body(res);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/validate/otp")
	@PreAuthorize("hasAnyAuthority('ADMIN','CUSTOMER')")
	public ResponseEntity<Boolean> validateOTP(Principal principal, @RequestBody Integer otp) {
		try {
			Boolean isValidated = otpService.validateOTP(principal.getName(), otp);
			return isValidated ? ResponseEntity.status(HttpStatus.OK).body(isValidated)
					: ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isValidated);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
