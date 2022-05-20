package com.blogging.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.dto.CategoryDetailsDTO;
import com.blogging.dto.PostDTO;
import com.blogging.service.PostService;

@RestController
@RequestMapping("/services/post")
public class PostController {

	public static final Logger log = LoggerFactory.getLogger(PostController.class);

	@Autowired
	PostService postService;

	@RequestMapping(value = { "/createPost" }, method = { RequestMethod.POST }, produces = "application/json")
	public PostDTO createPost(@RequestBody PostDTO postDTO) {

		log.info("Start : createPost");
		return postService.createPost(postDTO);
	}

	@RequestMapping(value = { "/updatePost" }, method = { RequestMethod.PUT }, produces = "application/json")
	public PostDTO updatePost(@RequestBody PostDTO postDTO,
			@RequestParam(name = "postId", required = true) Long postId) {

		log.info("Start : updatePost");
		return postService.updatePost(postDTO, postId);
	}

	@RequestMapping(value = { "/getPostById" }, method = { RequestMethod.GET }, produces = "application/json")
	public PostDTO getPostById(@RequestParam(name = "postId", required = true) Long postId) {

		log.info("Start : getPostById");
		return postService.getPostById(postId);

	}

	@RequestMapping(value = { "/deletePostById" }, method = { RequestMethod.DELETE }, produces = "application/json")
	public void deletePostById(@RequestParam(name = "postId") Long postId) {

		log.info("Start : deletePostById");
		postService.deletePostById(postId);

	}

	@RequestMapping(value = { "/getPostByCategoryId" }, method = { RequestMethod.GET }, produces = "application/json")
	public CategoryDetailsDTO getPostByCategoryId(@RequestParam(name = "categoryId", required = true) Long categoryId) {

		log.info("Start : getPostByCategoryId");
		return postService.getPostByCategoryId(categoryId);

	}

}
