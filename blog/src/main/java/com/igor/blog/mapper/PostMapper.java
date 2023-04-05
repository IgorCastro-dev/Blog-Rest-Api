package com.igor.blog.mapper;

import com.igor.blog.dto.PostDto;
import com.igor.blog.entity.Post;

public class PostMapper {
	public static PostDto mapToDto(Post post) {
		PostDto postDto = PostDto.builder()
								.postId(post.getPostId())
								.title(post.getTitle())
								.description(post.getDescription())
								.content(post.getContent())
								.build();
		return postDto;
	}
	
	public static Post mapToEntity(PostDto postDto) {
		Post post = Post.builder()
								.postId(postDto.getPostId())
								.title(postDto.getTitle())
								.description(postDto.getDescription())
								.content(postDto.getContent())
								.build();
		return post;
	}
}
