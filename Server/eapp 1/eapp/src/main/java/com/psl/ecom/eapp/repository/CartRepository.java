package com.psl.ecom.eapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psl.ecom.eapp.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
