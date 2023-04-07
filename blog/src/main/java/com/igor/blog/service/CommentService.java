package com.igor.blog.service;

import java.util.List;

import com.igor.blog.dto.CommentDto;

public interface CommentService {
	CommentDto createComment(Long postId,CommentDto commentDto);
	List<CommentDto> getAllComments(Long postId);
	CommentDto getCommentById(Long postId,Long commentId);
	CommentDto updateCommentByPostId(Long postId,Long commentId,CommentDto commentDto);
	Void deleteCommentByPostId(Long postId,Long commentId);
}
