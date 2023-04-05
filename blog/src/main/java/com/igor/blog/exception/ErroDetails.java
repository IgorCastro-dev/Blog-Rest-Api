package com.igor.blog.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErroDetails {
	private LocalDateTime timesTamp;
	private String message;
	private String path;
	private String erroCode;
}
