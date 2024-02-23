package com.psl.ecom.eapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.ecom.eapp.dto.CartDTO;
import com.psl.ecom.eapp.entity.Cart;
import com.psl.ecom.eapp.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	public ResponseEntity<CartDTO> addToCart(@RequestBody Cart cart) {
		CartDTO cartDTO = cartService.addToCart(cart);
		if (cartDTO != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(cartDTO);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
