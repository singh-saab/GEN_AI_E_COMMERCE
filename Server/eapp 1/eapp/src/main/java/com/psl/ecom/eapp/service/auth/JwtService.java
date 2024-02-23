package com.psl.ecom.eapp.service.auth;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.psl.ecom.eapp.dto.UserDTO;
import com.psl.ecom.eapp.entity.User;
import com.psl.ecom.eapp.response.AuthResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	private static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
	private ModelMapper modelMapper;

	public JwtService(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public AuthResponse generateToken(String userName, User user) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userName, user);
	}

	private AuthResponse createToken(Map<String, Object> claims, String userName, User user) {

		AuthResponse authResponse = new AuthResponse();

		String token = Jwts.builder().setClaims(claims).setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 24 * 60 * 60))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

		authResponse.setUser(modelMapper.map(user, UserDTO.class));
		authResponse.setToken(token);

		return authResponse;
	}

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
