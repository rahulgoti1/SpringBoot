package com.secure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.model.User;
import com.secure.repository.UserJpaRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserJpaRepository userJpaRepository;

	@GetMapping("/all")
	public List<User> getAll() {

		return userJpaRepository.findAll();
	}

	@GetMapping("/{name}")
	public User findByName(@PathVariable String name) {

		return userJpaRepository.findByName(name);
	}

	@PostMapping("/load")
	public User load(@RequestBody final User user) {
		userJpaRepository.save(user);
		return userJpaRepository.findByName(user.getName());
	}
}
