package com.psl.ecom.eapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.psl.ecom.eapp.dto.CartDTO;
import com.psl.ecom.eapp.entity.Cart;
import com.psl.ecom.eapp.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;
	private ModelMapper modelMapper;

	public CartServiceImpl(CartRepository cartRepository, ModelMapper modelMapper) {
		super();
		this.cartRepository = cartRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CartDTO addToCart(Cart cart) {
		return modelMapper.map(cartRepository.save(cart), CartDTO.class);
	}

}
