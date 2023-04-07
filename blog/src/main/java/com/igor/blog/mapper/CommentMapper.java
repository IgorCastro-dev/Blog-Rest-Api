package com.igor.blog.mapper;

import com.igor.blog.dto.CommentDto;
import com.igor.blog.entity.Comment;

public class CommentMapper {
	
	public static CommentDto mapToDto(Comment comment) {
		CommentDto commentDto = CommentDto.builder()
										.CommentId(comment.getCommentId())
										.name(comment.getName())
										.email(comment.getEmail())
										.body(comment.getBody())
										.build();
		return commentDto;
	}
	
	public static Comment mapToEntity(CommentDto commentDto) {
		Comment comment = Comment.builder()
										.CommentId(commentDto.getCommentId())
										.name(commentDto.getName())
										.email(commentDto.getEmail())
										.body(commentDto.getBody())
										.build();
		return comment;
	} 
}
