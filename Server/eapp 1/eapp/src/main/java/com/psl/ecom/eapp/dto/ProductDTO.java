package com.psl.ecom.eapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private Long id;

	private String description;

	private Double amount;

	private String imageUrl;
}
