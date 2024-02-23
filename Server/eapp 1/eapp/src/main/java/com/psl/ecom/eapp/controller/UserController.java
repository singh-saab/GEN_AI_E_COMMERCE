package com.psl.ecom.eapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.ecom.eapp.dto.UserDTO;
import com.psl.ecom.eapp.entity.Role;
import com.psl.ecom.eapp.entity.User;
import com.psl.ecom.eapp.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostConstruct
	public void createAdminUser() {
		User user = new User();
		user.setName("Robert");
		user.setEmail("admin@ecom.com");
		user.setPassword("admin@r#7000");
		user.setRole(Role.ADMIN);
		try {
			if (!userService.existsById(1L))
				userService.create(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@PostMapping("/create")
	public ResponseEntity<UserDTO> create(@RequestBody User user) {

		try {
			UserDTO createdUser = userService.create(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {

		try {
			UserDTO existingUser = userService.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(existingUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/find/all")
	public ResponseEntity<List<UserDTO>> findAll() {

		try {
			List<UserDTO> existingUsers = userService.findAll();
			if (existingUsers == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.status(HttpStatus.OK).body(existingUsers);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<UserDTO> updateById(@PathVariable Long id, @RequestBody User newUser) {

		try {
			UserDTO updatedUser = userService.updateById(id, newUser);
			return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Boolean> create(@PathVariable Long id) {

		try {
			Boolean isUserDeleted = userService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(isUserDeleted);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
