package com.igor.blog.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.igor.blog.dto.PostDto;
import com.igor.blog.entity.Post;
import com.igor.blog.exception.ResourceNotFoundException;
import com.igor.blog.mapper.PostMapper;
import com.igor.blog.repository.PostRepository;
import com.igor.blog.service.PostService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService{
	
	private PostRepository postRepository;
	
	@Override
	public PostDto createPost(PostDto postDto) {
		Post post = postRepository.save(PostMapper.mapToEntity(postDto)); 
		return PostMapper.mapToDto(post);
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		return posts.stream().map(post -> PostMapper.mapToDto(post)).collect(Collectors.toList());
	}

	@Override
	public PostDto getPostById(Long postId) {
		Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		return PostMapper.mapToDto(post);
	}

	@Override
	public PostDto updatePostById(Long postId, PostDto postDto) {
		Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		return PostMapper.mapToDto(post);
	}

	@Override
	public Void deletePostById(Long postId) {
		postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		postRepository.deleteById(postId);
		return null;
	}

}