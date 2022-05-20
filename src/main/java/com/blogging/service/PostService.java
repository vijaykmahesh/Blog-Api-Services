package com.blogging.service;

import com.blogging.dto.CategoryDetailsDTO;
import com.blogging.dto.PostDTO;

public interface PostService {

	PostDTO createPost(PostDTO postDTO);
	
	PostDTO updatePost(PostDTO postDTO,Long postId);
	
	PostDTO getPostById(Long postId);

	void deletePostById(Long postId);
	
	CategoryDetailsDTO getPostByCategoryId(Long categoryId);

}
