package com.psl.ecom.eapp.entity;

public enum Role {
	ADMIN("ADMIN"), CUSTOMER("CUSTOMER");

	private String value;

	private Role(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
