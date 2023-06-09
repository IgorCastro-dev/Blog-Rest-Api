package com.igor.blog.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.blog.dto.PostDto;
import com.igor.blog.service.PostService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("api/posts")
public class PostController {
	
	private PostService postService;
	
	@PostMapping
	private ResponseEntity<PostDto> createdPost(@Valid @RequestBody PostDto postDto){
		return new ResponseEntity<>(postService.createPost(postDto),HttpStatus.CREATED);
	}
	
	@GetMapping
	private ResponseEntity<List<PostDto>> getAllPosts(){
		return new ResponseEntity<>(postService.getAllPosts(),HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	private ResponseEntity<PostDto> getById(@PathVariable("postId") Long postId){
		return new ResponseEntity<>(postService.getPostById(postId),HttpStatus.OK);
	}
	
	@PutMapping("/{postId}")
	private ResponseEntity<PostDto> updatePostById(@Valid @PathVariable("postId") Long postId,@RequestBody PostDto postDto){
		return new ResponseEntity<>(postService.updatePostById(postId, postDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}")
	private ResponseEntity<String> deletePostById(@PathVariable("postId") Long postId){
		postService.deletePostById(postId);
		return new ResponseEntity<>("Post was deleted",HttpStatus.OK);
	}
	
}













