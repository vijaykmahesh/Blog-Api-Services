package com.blogging.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.dto.UserDTO;
import com.blogging.service.UserService;

@RestController
@RequestMapping(value = "/services/user")
public class UserController {

	public static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/createUser" }, method = { RequestMethod.POST }, produces = "application/json")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {

		log.info("Start : createUser");
		return userService.createUser(userDTO);
	}

	@RequestMapping(value = { "/updateUser" }, method = { RequestMethod.PUT }, produces = "application/json")
	public UserDTO updateUser(@RequestBody UserDTO userDTO, @RequestParam(name = "userId") Long userId) {

		log.info("Start : updateUser");
		return userService.UpdateUser(userDTO, userId);
	}

	@RequestMapping(value = { "/getUserById" }, method = { RequestMethod.GET }, produces = "application/json")
	public UserDTO getUserById(@RequestParam(name = "userId") Long userId) {

		log.info("Start : getUserById");
		return userService.getUserById(userId);

	}

	@RequestMapping(value = { "/deleteUser" }, method = { RequestMethod.DELETE }, produces = "application/json")
	public ResponseEntity<String> deleteUser(@RequestParam(name = "userId") Long userId) {

		log.info("Start : deleteUser");
		userService.deleteUser(userId);
		return ResponseEntity.ok("user deleted successfully" + userId);

	}

}
