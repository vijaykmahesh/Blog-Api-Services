package com.blogging.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.dto.UserDTO;
import com.blogging.exceptions.DataNotFoundException;
import com.blogging.exceptions.DuplicateDataException;
import com.blogging.model.User;
import com.blogging.repository.UserRepository;
import com.blogging.service.UserService;
import com.blogging.utils.UserObjectMapping;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository; 

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		Optional<User> isExist =  userRepository.findByUserNameIgnoreCase(userDTO.getUserName());
		if(isExist.isPresent()) {
			throw new DuplicateDataException("username already exist");
		}
		else {
			User userConverted = UserObjectMapping.toUser(userDTO);
			System.out.println("user obj-----------"+userConverted);
			userConverted = userRepository.save(userConverted);
			return UserObjectMapping.toUserDTO(userConverted);
		}
	}


	@Override
	public UserDTO getUserById(Long userId) {
		Optional<User> isExist =  userRepository.findById(userId);
		
		if(isExist.isPresent()) {
			throw new DataNotFoundException("User Not Found For"+userId);
		}
		else
			return UserObjectMapping.toUserDTO(isExist.get());
	}
}
