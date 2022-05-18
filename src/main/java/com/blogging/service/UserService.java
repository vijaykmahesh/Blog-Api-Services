package com.blogging.service;

import com.blogging.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO user);
	
	UserDTO getUserById(Long userId);

}
