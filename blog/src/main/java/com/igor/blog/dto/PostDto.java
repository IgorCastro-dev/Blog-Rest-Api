package com.igor.blog.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
	private Long postId;

	@NotBlank
	@Size(min = 2 )
	private String title;

	@NotBlank
	@Size(min = 10)
	private String description;

	@NotBlank
	@Size(min = 10)
	private String content;
}
