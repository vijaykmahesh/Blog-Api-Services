package com.blogging.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.dto.PostDTO;
import com.blogging.dto.UserDTO;
import com.blogging.service.PostService;
import com.blogging.service.UserService;

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

	

}
