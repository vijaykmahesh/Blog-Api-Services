package com.blogging.utils;

import com.blogging.dto.PostDTO;
import com.blogging.model.Posts;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class PostObjectMapping {

	public static Posts toPost(PostDTO postDTO) {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(PostDTO.class, Posts.class).byDefault().register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Posts post = mapper.map(postDTO, Posts.class);

		System.out.println("post obj is " + post.toString());
		return post;

	}

	public static PostDTO toPostDTO(final Posts post) {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		mapperFactory.classMap(Posts.class, PostDTO.class).byDefault().register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		PostDTO dto = mapper.map(post, PostDTO.class);
		return dto;
	}
}
