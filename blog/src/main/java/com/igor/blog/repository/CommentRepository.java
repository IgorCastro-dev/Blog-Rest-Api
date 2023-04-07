package com.igor.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByPostPostId(Long postId);
}
