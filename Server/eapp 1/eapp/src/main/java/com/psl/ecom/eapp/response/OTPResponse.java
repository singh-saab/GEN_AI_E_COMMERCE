package com.psl.ecom.eapp.response;

import com.psl.ecom.eapp.dto.OTPStatusDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTPResponse {
	private OTPStatusDTO status;
	private String message;
}
