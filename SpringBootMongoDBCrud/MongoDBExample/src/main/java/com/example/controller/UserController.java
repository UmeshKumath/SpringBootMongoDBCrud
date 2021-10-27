package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public List<User> getAllUser(){
		LOG.info("Getting all user");
		return userRepository.findAll();
	}
	
	@GetMapping(value="/{userId}")
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting User with Id: {}. ", userId);
		return userRepository.findById(userId).get();
	}
	
	@PostMapping
	public User addNewUser(@RequestBody User user) {
		LOG.info("Save User");
		return userRepository.save(user);
	}
	
	@GetMapping(value="/settings/{userId}")
	public Object getAllUserSettings(@PathVariable String userId) {
		User user = userRepository.findById(userId).get();
		if(user!=null)
			return user.getUserSettings();
		else
			return "User not Found";
	}
	
	@GetMapping(value="settings/{userId}/{key}")
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		User user = userRepository.findById(userId).get();
		if(user!=null)
			return user.getUserSettings().get(key);
		else
			return "User Not found";
	}
	
	@GetMapping(value="settings/{userId}/{key}/{value}")
	public String addUserSettings(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		User user = userRepository.findById(userId).get();
		if(user!=null) {
			user.getUserSettings().put(key, value);
			userRepository.save(user);
			return "key added";
		} else {
			return "user not found"; 
		}
	}
	
	
}
