package com.psl.ecom.eapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Long id;

	private String name;

	private String email;

	@JsonIgnore
	private String password;
}
