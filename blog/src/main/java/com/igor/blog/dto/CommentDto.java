package com.igor.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
	private Long CommentId;
	private String name;
	private String email;
	private String body;
}
