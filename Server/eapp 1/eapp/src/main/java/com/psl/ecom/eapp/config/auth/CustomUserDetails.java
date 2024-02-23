package com.psl.ecom.eapp.config.auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.psl.ecom.eapp.entity.User;

@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails {

	private String username;

	private String password;

	private List<GrantedAuthority> authorities;

	public CustomUserDetails(User user) {
		super();

		this.username = user.getEmail();
		this.password = user.getPassword();
		this.authorities = Arrays.stream(user.getRole().getValue().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
