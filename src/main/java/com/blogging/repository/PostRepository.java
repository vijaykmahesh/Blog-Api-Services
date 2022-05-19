package com.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.model.Posts;

public interface PostRepository extends JpaRepository<Posts, Long> {

}
