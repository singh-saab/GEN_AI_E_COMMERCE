package com.psl.ecom.eapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.psl.ecom.eapp.dto.ProductDTO;
import com.psl.ecom.eapp.entity.Product;
import com.psl.ecom.eapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private ModelMapper modelMapper;

	public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
		super();
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductDTO create(Product product) {
		return modelMapper.map(productRepository.save(product), ProductDTO.class);
	}

	@Override
	public ProductDTO findById(Long id) throws Exception {
		if (!productRepository.existsById(id))
			throw new Exception("product with id:" + id + " is not found");
		return modelMapper.map(productRepository.findById(id), ProductDTO.class);
	}

	@Override
	public List<ProductDTO> findAll() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDTO updateById(Long id, Product newProduct) throws Exception {
		if (!productRepository.existsById(id))
			throw new Exception("product with id:" + id + " is not found");
		Product existingProduct = productRepository.findById(id).get();
		existingProduct.setAmount(newProduct.getAmount());
		existingProduct.setDescription(newProduct.getDescription());
		existingProduct.setImageUrl(newProduct.getImageUrl());
		return modelMapper.map(productRepository.save(existingProduct), ProductDTO.class);
	}

	@Override
	public Boolean deleteById(Long id) throws Exception {
		if (!productRepository.existsById(id))
			throw new Exception("product with id:" + id + " is not found");
		productRepository.deleteById(id);
		return true;
	}

}
