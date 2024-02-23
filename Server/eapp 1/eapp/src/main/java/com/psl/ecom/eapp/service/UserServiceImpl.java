package com.psl.ecom.eapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psl.ecom.eapp.dto.UserDTO;
import com.psl.ecom.eapp.entity.Role;
import com.psl.ecom.eapp.entity.User;
import com.psl.ecom.eapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDTO create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (user.getRole() != Role.ADMIN)
			user.setRole(Role.CUSTOMER);
		return modelMapper.map(userRepository.save(user), UserDTO.class);
	}

	@Override
	public Boolean existsById(Long id) {
		if (userRepository.existsById(id))
			return true;
		return false;
	}

	@Override
	public UserDTO findById(Long id) throws Exception {
		User user = userRepository.findById(id).orElse(null);
		if (user == null)
			throw new Exception("user with id: " + id + " is not found");
		else
			return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO findByEmail(String email) throws Exception {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if (optionalUser.isEmpty())
			throw new Exception("user with email: " + email + " is not found");
		else
			return modelMapper.map(optionalUser.get(), UserDTO.class);
	}

	@Override
	public String findEmailByName(String name) {
		Optional<User> user = userRepository.findByName(name);
		if (user.isPresent()) {
			return user.get().getEmail();
		}
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		List<User> users = (List<User>) userRepository.findAll();
		return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateById(Long id, User newUser) throws Exception {
		User user = userRepository.findById(id).orElse(null);
		if (user == null)
			throw new Exception("user with id: " + id + " is not found");
		else {
			user.setName(newUser.getName());
			user.setEmail(newUser.getEmail());
			user.setPassword(newUser.getPassword());
			return modelMapper.map(userRepository.save(user), UserDTO.class);
		}

	}

	@Override
	public Boolean deleteById(Long id) throws Exception {
		User user = userRepository.findById(id).orElse(null);
		if (user == null)
			throw new Exception("user with id: " + id + " is not found");
		else {
			userRepository.delete(user);
			return true;
		}
	}

}
