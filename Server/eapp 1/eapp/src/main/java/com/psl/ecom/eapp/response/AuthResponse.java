package com.psl.ecom.eapp.response;

import com.psl.ecom.eapp.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

	private UserDTO user;

	private String token;
}
