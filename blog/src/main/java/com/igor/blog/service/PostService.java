package com.igor.blog.service;

import java.util.List;

import com.igor.blog.dto.PostDto;

public interface PostService {
	PostDto createPost(PostDto postDto);
	List<PostDto> getAllPosts();
	PostDto getPostById(Long postId);
	PostDto updatePostById(Long postId,PostDto postDto);
	Void deletePostById(Long postId);
}
