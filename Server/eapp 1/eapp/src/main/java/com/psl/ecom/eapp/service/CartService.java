package com.psl.ecom.eapp.service;

import com.psl.ecom.eapp.dto.CartDTO;
import com.psl.ecom.eapp.entity.Cart;

public interface CartService {

	CartDTO addToCart(Cart cart);
}
