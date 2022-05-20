package com.blogging.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.dto.CategoryDetailsDTO;
import com.blogging.dto.PostDTO;
import com.blogging.exceptions.DataNotFoundException;
import com.blogging.exceptions.ErrorWhileCreatingException;
import com.blogging.exceptions.ErrorWhileUpdatingException;
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

	public static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

	@Override
	public PostDTO createPost(PostDTO postDTO) {

		log.info("Start : PostServiceImpl: createPost");
		Optional<User> isUserExist = userRepository.findById(postDTO.getUserId());

		if (isUserExist.isPresent()) {

			Optional<Category> isCategoryExist = categoryRepository.findById(postDTO.getCategoryId());

			if (isCategoryExist.isPresent()) {

				Posts post = PostObjectMapping.toPost(postDTO);
				post.setCategory(isCategoryExist.get());
				post.setUser(isUserExist.get());
				Posts savedPost = postRepository.save(post);
				if (savedPost != null) {
					log.info("post created successfully" + savedPost.toString());
					return PostObjectMapping.toPostDTO(savedPost);
				} else
					throw new ErrorWhileCreatingException("Error while creating post");
			} else
				throw new DataNotFoundException("category not found for id" + postDTO.getCategoryId());
		} else
			throw new DataNotFoundException("user not found for id" + postDTO.getUserId());

	}

	@Override
	public PostDTO updatePost(PostDTO postDTO, Long postId) {

		log.info("Start : PostServiceImpl: updatePost");
		Optional<Posts> isExist = postRepository.findById(postId);
		if (isExist.isPresent()) {
			log.info("post is present" + isExist.get());
			Optional<User> isUserExist = userRepository.findById(postDTO.getUserId());
			if (isUserExist.isPresent()) {
				log.info("user is present for post" + isUserExist.get());

				Optional<Category> isCategoryExist = categoryRepository.findById(postDTO.getCategoryId());

				if (isCategoryExist.isPresent()) {
					log.info("category is present for post" + postDTO.getCategoryId());
					Posts post = isExist.get();
					post.setAddedDate(postDTO.getAddedDate());
					post.setContent(postDTO.getContent());
					post.setTitle(postDTO.getTitle());
					post.setCategory(isCategoryExist.get());
					post.setUser(isUserExist.get());
					Posts updatedPost = postRepository.save(post);
					if (updatedPost != null) {
						return PostObjectMapping.toPostDTO(updatedPost);
					} else
						throw new ErrorWhileUpdatingException("Error while updating post");
				} else
					throw new DataNotFoundException("Category not found for post" + postDTO.getCategoryId());

			} else
				throw new DataNotFoundException("user not found for post" + postDTO.getUserId());

		} else
			throw new DataNotFoundException("Post not found for id" + postId);
	}

	@Override
	public PostDTO getPostById(Long postId) {
		Optional<Posts> isExist = postRepository.findById(postId);

		if (isExist.isPresent()) {
			throw new DataNotFoundException("Post Not Found For" + postId);
		} else
			return PostObjectMapping.toPostDTO(isExist.get());
	}

	@Override
	public void deletePostById(Long postId) {
		Optional<Posts> isExist = postRepository.findById(postId);

		if (isExist.isPresent()) {
			postRepository.deleteById(postId);
		} else
			throw new DataNotFoundException("Post Not Found For" + postId);
	}

	@Override
	public CategoryDetailsDTO getPostByCategoryId(Long categoryId) {
		Optional<Category> isCategoryExist = categoryRepository.findById(categoryId);
		if (isCategoryExist.isPresent()) {
			return PostObjectMapping.toCategoryDetailsDTO(isCategoryExist.get());
		} else
			throw new DataNotFoundException("no posts found for user with " + categoryId);
	}

}
