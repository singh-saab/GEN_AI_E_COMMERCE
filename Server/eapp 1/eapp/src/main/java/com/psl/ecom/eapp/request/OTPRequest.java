package com.psl.ecom.eapp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTPRequest {

	private String toPhoneNumber;
	private String email;
}
