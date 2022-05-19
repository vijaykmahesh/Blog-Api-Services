package com.blogging.utils;

import java.util.ArrayList;
import java.util.List;

import com.blogging.dto.PostDTO;
import com.blogging.dto.UserDTO;
import com.blogging.dto.UserDetailsDTO;
import com.blogging.model.Posts;
import com.blogging.model.User;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class UserObjectMapping {

	
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
	
	public static UserDetailsDTO toUserDetailsDTO(final User user) {
		
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		
		mapperFactory.classMap(User.class, UserDetailsDTO.class).byDefault().register();

		MapperFacade mapper = mapperFactory.getMapperFacade();
		UserDetailsDTO dto = mapper.map(user, UserDetailsDTO.class);
		
		if (user.getPosts() != null)
			dto.setPostDtos(mapPosts(user.getPosts()));
		return dto;
			}
	
	
	public static List<PostDTO> mapPosts(List<Posts> postList){
		List<PostDTO> postDTOs = new ArrayList<PostDTO>();

		for (Posts post : postList) {
			PostDTO postDto = PostObjectMapping.toPostDTO(post);
			postDTOs.add(postDto);
		}

		return postDTOs;
	}

}
