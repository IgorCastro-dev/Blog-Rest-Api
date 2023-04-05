package com.igor.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{


}
