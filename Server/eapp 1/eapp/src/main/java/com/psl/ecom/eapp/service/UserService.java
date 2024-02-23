package com.psl.ecom.eapp.service;

import java.util.List;

import com.psl.ecom.eapp.dto.UserDTO;
import com.psl.ecom.eapp.entity.User;

public interface UserService {

	UserDTO create(User user);
	
	Boolean existsById(Long id);

	UserDTO findById(Long id) throws Exception;
	
	String findEmailByName(String name);

	UserDTO findByEmail(String email) throws Exception;

	List<UserDTO> findAll();

	UserDTO updateById(Long id, User newUser) throws Exception;

	Boolean deleteById(Long id) throws Exception;
}
