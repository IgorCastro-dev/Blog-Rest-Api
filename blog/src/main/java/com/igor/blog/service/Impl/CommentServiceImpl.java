package com.igor.blog.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.igor.blog.dto.CommentDto;
import com.igor.blog.entity.Comment;
import com.igor.blog.entity.Post;
import com.igor.blog.exception.BlogResourceException;
import com.igor.blog.exception.ResourceNotFoundException;
import com.igor.blog.mapper.CommentMapper;
import com.igor.blog.repository.CommentRepository;
import com.igor.blog.repository.PostRepository;
import com.igor.blog.service.CommentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{
	
	private PostRepository postRepository;
	private CommentRepository commentRepository;

	@Override
	public CommentDto createComment(Long postId, CommentDto commentDto) {
		Comment comment = CommentMapper.mapToEntity(commentDto);
		Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		comment.setPost(post);
		return CommentMapper.mapToDto(commentRepository.save(comment));
	}

	@Override
	public List<CommentDto> getAllComments(Long postId) {
		List<Comment> comments = commentRepository.findByPostPostId(postId);
		return comments.stream().map(comment -> CommentMapper.mapToDto(comment)).collect(Collectors.toList());
	}

	@Override
	public CommentDto getCommentById(Long postId,Long commentId) {
		Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));
		if(!comment.getPost().getPostId().equals(post.getPostId())) {
			throw new BlogResourceException("this comment not pertence for this post");
		}
		return CommentMapper.mapToDto(comment);
	}

	@Override
	public CommentDto updateCommentByPostId(Long postId, Long commentId,CommentDto commentDto) {
		Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));
		if(!comment.getPost().getPostId().equals(post.getPostId())) {
			throw new BlogResourceException("this comment not pertence for this post");
		}
		comment.setName(commentDto.getName());
		comment.setEmail(commentDto.getEmail());
		comment.setBody(commentDto.getBody());
		
		return CommentMapper.mapToDto(commentRepository.save(comment));
	}

	@Override
	public Void deleteCommentByPostId(Long postId, Long commentId) {
		Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));
		if(!comment.getPost().getPostId().equals(post.getPostId())) {
			throw new BlogResourceException("this comment not pertence for this post");
		}
		commentRepository.delete(comment);
		return null;
	}

}
