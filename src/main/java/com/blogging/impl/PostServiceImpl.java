package com.blogging.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.dto.PostDTO;
import com.blogging.exceptions.DataNotFoundException;
import com.blogging.exceptions.ErrorWhileCreatingException;
import com.blogging.model.Category;
import com.blogging.model.Posts;
import com.blogging.model.User;
import com.blogging.repository.CategoryRepository;
import com.blogging.repository.PostRepository;
import com.blogging.repository.UserRepository;
import com.blogging.service.PostService;
import com.blogging.utils.PostObjectMapping;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public PostDTO createPost(PostDTO postDTO) {
		
		Optional<User> isUserExist = userRepository.findById(postDTO.getUserId());
		
		if(isUserExist.isPresent()) {
			
			Optional<Category> isCategoryExist = categoryRepository.findById(postDTO.getCategoryId());
			
			if(isCategoryExist.isPresent()) {
				
				Posts post =  PostObjectMapping.toPost(postDTO);
				post.setCategory(isCategoryExist.get());
				post.setUser(isUserExist.get());
				Posts savedPost = postRepository.save(post);
				
				if(savedPost!=null) {
					return PostObjectMapping.toPostDTO(savedPost);
				}
				else
					throw new ErrorWhileCreatingException("Error while creating post");
			}
			else
				throw new DataNotFoundException("category not found for id"+postDTO.getCategoryId());
		}
		else
			throw new DataNotFoundException("user not found for id"+postDTO.getUserId());
			
	}

	
}
