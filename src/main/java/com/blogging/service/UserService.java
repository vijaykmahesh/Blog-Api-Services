package com.blogging.service;

import java.util.List;

import com.blogging.dto.UserDTO;
import com.blogging.dto.UserDetailsDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO user);
	
	UserDTO getUserById(Long userId);
	
	UserDTO updateUser(UserDTO userDto,Long userId);
	
	void deleteUser(Long userId);
	
	UserDetailsDTO getPostsByUserId(Long userId);

}
