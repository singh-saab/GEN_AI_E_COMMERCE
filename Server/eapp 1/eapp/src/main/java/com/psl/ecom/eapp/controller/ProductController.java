package com.psl.ecom.eapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.ecom.eapp.dto.ProductDTO;
import com.psl.ecom.eapp.entity.Product;
import com.psl.ecom.eapp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("/create")
	public ResponseEntity<ProductDTO> create(@RequestBody Product product) {
		ProductDTO productDTO = productService.create(product);
		if (productDTO != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
