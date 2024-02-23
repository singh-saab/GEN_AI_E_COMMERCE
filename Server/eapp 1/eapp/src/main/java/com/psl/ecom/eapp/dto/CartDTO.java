package com.psl.ecom.eapp.dto;

import java.util.List;

import com.psl.ecom.eapp.entity.Product;
import com.psl.ecom.eapp.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	private Long id;

	private List<Product> products;

	private User user;
}
