package com.blogging.utils;

import com.blogging.dto.UserDTO;
import com.blogging.model.User;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class UserObjectMapping {
	
//	public static User toUser(final UserDTO userDTO) {
//
//		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//
//		mapperFactory.classMap(UserDTO.class, User.class)
//		.byDefault().register();
//		MapperFacade mapper = mapperFactory.getMapperFacade();
//		System.out.println("----------user mapper"+mapper);
//		User dto = mapper.map(userDTO, User.class);
//		System.out.println("----------user mapper"+dto.toString());
//		return dto;
//	}
	
	public static User toUser(UserDTO userDTO) {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(UserDTO.class, User.class).byDefault().register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		User user = mapper.map(userDTO, User.class);
		
		System.out.println("user obj is "+user.toString());
		return user;

	}
	
	public static UserDTO toUserDTO(final User user) {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		mapperFactory.classMap(User.class, UserDTO.class).byDefault().register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		UserDTO dto = mapper.map(user, UserDTO.class);
		return dto;
	}

}
