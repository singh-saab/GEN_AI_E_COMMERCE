package com.psl.ecom.eapp.service;

import java.util.List;

import com.psl.ecom.eapp.dto.ProductDTO;
import com.psl.ecom.eapp.entity.Product;

public interface ProductService {

	ProductDTO create(Product product);

	ProductDTO findById(Long id) throws Exception;

	List<ProductDTO> findAll();

	ProductDTO updateById(Long id, Product newProduct) throws Exception;

	Boolean deleteById(Long id) throws Exception;

}
